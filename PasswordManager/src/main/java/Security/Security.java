package Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.Base64;


public class Security {
    private static final int TAG_LENGTH_BITS = 128;
    private static final int SALT_LEN_BYTES = 16;
    private static final int IV_LEN_BYTES = 12;
    private static final String KDF_ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final String CRYPTO_ALGORITHM = "AES/GCM/NoPadding";

    public String hashAccountName(String accountName) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] hash = digest.digest(accountName.getBytes(StandardCharsets.UTF_8));
            String encoded = Base64.getEncoder().encodeToString(hash);
            return encoded;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return accountName;
    }

    public byte[] getRandomNonce(int nBytes) {
        byte[] nonce = new byte[nBytes];
        new SecureRandom().nextBytes(nonce);
        return nonce;
    }

    private SecretKey deriveKey(String masterPassword, byte[] salt) {
        char[] mp = masterPassword.toCharArray();

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(KDF_ALGORITHM);
            KeySpec spec = new PBEKeySpec(mp, salt, 65536, 256);
            SecretKey secret = skf.generateSecret(spec);
            SecretKeySpec key = new SecretKeySpec(secret.getEncoded(), "AES");
            return key;
        } catch (Exception e) {
            System.err.println("An error occurred during deriveKey: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private byte[] padZeroBytes(byte[] source, int bytesToPad) {
        if (bytesToPad <= 0) return source;

        int resultLen = bytesToPad + source.length;
        byte[] result = new byte[resultLen];

        for (int i = 0; i < source.length; ++i) {
            result[i + bytesToPad] = source[i];
        }

        return result;
    }

    public String encryptPassword(String masterPassword, String password) {
        try {
            byte[] salt = this.getRandomNonce(SALT_LEN_BYTES);
            SecretKey key = this.deriveKey(masterPassword, salt);

            byte[] iv = this.getRandomNonce(IV_LEN_BYTES);
            byte[] passwordBytes = password.getBytes();

            Cipher cipher = Cipher.getInstance(CRYPTO_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key, new GCMParameterSpec(TAG_LENGTH_BITS, iv));

            byte[] cipherText = cipher.doFinal(passwordBytes);
            byte[] prefixedCipherText = ByteBuffer.allocate(IV_LEN_BYTES + SALT_LEN_BYTES + cipherText.length)
                    .put(iv)
                    .put(salt)
                    .put(cipherText)
                    .array();

            String encodedEncryptedPassword = Base64.getEncoder().encodeToString(prefixedCipherText);

            return encodedEncryptedPassword;
        } catch (Exception e) {
            System.err.println("An error occurred during encryption: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public String decryptPassword(String masterPassword, String encryptedPassword) {
        if (encryptedPassword == null) return null;

        // decode the encoded cipher text
        byte[] prefixedCipherText = Base64.getDecoder().decode(encryptedPassword);

        // unwrap the iv and the salt prefixes, and put the rest of the bytes into the actual cipher text buffer
        byte[] iv = new byte[IV_LEN_BYTES];
        byte[] salt = new byte[SALT_LEN_BYTES];
        ByteBuffer buf = ByteBuffer.wrap(prefixedCipherText);
        buf.get(iv).get(salt);
        byte[] cipherText = new byte[buf.remaining()];
        buf.get(cipherText);

        // Now, we can begin the actual decryption process, using the IV and salt that we obtained above.
        SecretKey key = this.deriveKey(masterPassword, salt);

        try {
            Cipher cipher = Cipher.getInstance(CRYPTO_ALGORITHM);
            AlgorithmParameterSpec spec = new GCMParameterSpec(TAG_LENGTH_BITS, iv);
            cipher.init(Cipher.DECRYPT_MODE, key, spec);
            cipher.update(cipherText);
            byte[] plaintext = cipher.doFinal();

            return new String(plaintext, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.err.println("Something failed during decryption: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

}
