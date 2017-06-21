/**
 * Uses the Vigenère Cipher with a multiple-letter keyword to decrypt the encrypted plaintext.
 * @author Harry Baines
 */
public class Encryption {

    private final int ALPHA_SIZE = 26;

    private String key;
    private char[] keyword;
    private String message;
    private String ciphertext;
    private String plaintext;
    private int keyInc;

    public Encryption(String key, String message) {

        this.key = key;
        this.message = message;
        keyInc = 0;
        keyword = new char[message.length()];
        ciphertext = message;

        generateKeyword();
        encryptMessage();
        decryptMessage();

    }

    public boolean encryptMessage() {

        char[] cipherchars = ciphertext.toCharArray();

        char calculatedChar;
        int keyInc = 0;

        for (int i = 0; i < message.length(); i++) {

            if (message.charAt(i) != ' ') {

                calculatedChar = (char) ((int)(keyword[keyInc]) + (message.charAt(i) - 97));

                if ((int)(calculatedChar) > 90)
                    calculatedChar = (char) ((int) (calculatedChar) - ALPHA_SIZE);

                cipherchars[i] = calculatedChar;

                keyInc++;

                if (keyInc > 2)
                    keyInc = 0;
            }
        }

        ciphertext = String.valueOf(cipherchars);
        return true;
    }

    public boolean decryptMessage() {

        char[] cipherchars = ciphertext.toCharArray();

        char calculatedChar;
        int keyInc = 0;

        for (int i = 0; i < message.length(); i++) {

            if (message.charAt(i) != ' ') {

                calculatedChar = (char) (97 + ((int)((cipherchars[i] - 97) - (int)(keyword[keyInc]))));

                //if ((int)(calculatedChar) > 90)
                    //calculatedChar = (char) ((int) (calculatedChar) - ALPHA_SIZE);

                cipherchars[i] = calculatedChar;

                keyInc++;

                if (keyInc > 2)
                    keyInc = 0;
            }
        }

        plaintext = String.valueOf(cipherchars);
        return true;
    }

    public boolean generateKeyword() {

        for (int i = 0; i < message.length(); i++) {

            if (keyInc > 2)
                keyInc = 0;

            keyword[i] = key.charAt(keyInc);

            keyInc++;

        }

        return true;

    }

    public void printDetails() {

        System.out.println("PLAINTEXT: " + message);
        System.out.println("KEY: " + key);
        System.out.println("KEYWORD: " + String.valueOf(keyword));
        System.out.println("CIPHERTEXT: " + ciphertext);
        System.out.println("DECRYPTED CIPHERTEXT: " + plaintext);

    }

    public char[] getKeyword() {
        return keyword;
    }

    public String getKey() {
        return key;
    }

    private void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

}