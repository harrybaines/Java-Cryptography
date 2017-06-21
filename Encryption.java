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
    private int keyInc;

    private char[] alphabet;
    private char[] cipherAlphabet;

    public Encryption(String key, String message) {

        this.key = key;
        this.message = message;
        keyInc = 0;
        keyword = new char[message.length()];
        ciphertext = message;

        alphabet = new char[ALPHA_SIZE];
        cipherAlphabet = new char[ALPHA_SIZE];

        for (int i = 0; i < ALPHA_SIZE; i++) {
            alphabet[i] = (char) (i+97);
        }

        generateKeyword();
        encryptMessage();

    }

    public boolean encryptMessage() {

        char[] cipherchars = ciphertext.toCharArray();

        int cipherOffset = 0;

        char calculatedChar;
        int keyInc = 0;

        for (int i = 0; i < message.length(); i++) {


            if (message.charAt(i) != ' ') {

                int offset = message.charAt(i) - 97;

                calculatedChar = (char) ((int)(keyword[keyInc]) + offset);

                System.out.println("Keyword[keyinc] = " + keyword[keyInc] + " Char: " + calculatedChar + " offset = " + offset);

                if ((int)(calculatedChar) > 90) {
                    System.out.println("OOPS");
                }

                System.out.println(calculatedChar);

                cipherchars[i] = calculatedChar;

                keyInc++;

                if (keyInc > 2)
                    keyInc = 0;

            }

        }

        ciphertext = String.valueOf(cipherchars);

        return true;

    }

    public void generateCipherAlphabet(char keyLetter) {

        int keyInt = (int) (keyLetter);
        System.out.println(keyInt);


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

        System.out.println("\nALPHABET: ");
        for (int i = 0; i < alphabet.length; i++) {
            System.out.println(i + ": " + alphabet[i]);
        }
        System.out.println("MESSAGE: " + message);
        printKeyword();
        System.out.println("CIPHERTEXT: " + ciphertext);

    }

    public void printKeyword() {
        for (int i = 0; i < keyword.length; i++) {
            System.out.println(keyword[i]);
        }
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