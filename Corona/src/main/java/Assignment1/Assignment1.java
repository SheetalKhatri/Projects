package Assignment1;

/**
 * @author Sheetal Khatri
 * @date: 7/14/2020
 * version:14.0.1
 */
public class Assignment1 {
    //    removes vowel from the String
    public static void removeVowel(String str) {
        char[] c = str.toCharArray();
        for (int b = 0; b < c.length; b++) {
            char now = c[b];
            switch (now) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    continue;
            }
            System.out.print(now);
        }
        System.out.println();
    }

    //    prints second highest length word
    public static void secondHighest(String sentence) {
        String sen[] = sentence.split(" ");        // max = cat, balll
        String senHighest = sen[0];  //  cat balll tapp
        String senSecondHighest = sen[0];
        for (int i = 1; i < sen.length; i++) {
            if (sen[i].length() > senHighest.length()) {
                senSecondHighest = senHighest;
                senHighest = sen[i];
            } else {
                if (sen[i].length() > senSecondHighest.length()) {
                    senSecondHighest = sen[i];
                }
            }
        }
        System.out.println(senSecondHighest);
    }


}
