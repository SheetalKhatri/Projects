package Storage;

import Security.Security;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Storage {
    private Security security = new Security();

    /**
     * Hashes the service name, and returns the full path to the file that contains this
     * service's password.
     *
     * @param account - The account name to find (e.g. "google", "facebook")
     * @return
     */
    private String getFilenameForService(String account) {
        String hashAccountName = security.hashAccountName(account);
        String path = System.getProperty("user.home") + File.separator + "passwords" + File.separator + hashAccountName;
        return path + ".txt";
    }

    public String readTheEncryptedPasswordForAccount(String account) {
        try {
            String accountFilename = this.getFilenameForService(account);
            FileInputStream fs = new FileInputStream(accountFilename);

            return new String(fs.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.err.println("Something went wrong when trying to read encrypted password: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public void writePasswordToRespectiveAccount(String account, String encryptedPassword) {
        try {
            String accountFileName = this.getFilenameForService(account);
            FileOutputStream bos = new FileOutputStream(accountFileName);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(bos,StandardCharsets.UTF_8));
            bw.write(encryptedPassword);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
