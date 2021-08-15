package com.haitd22.dsa._3._1._4;

public class CaesarCipher {
    protected char[] encoder = new char[26];
    protected char[] decoder = new char[26];

    public CaesarCipher(int rotation) {
        for (int k = 0; k < 26; k++) {
            encoder[k] = (char) ('A' + (k + rotation) % 26);
            decoder[k] = (char) ('A' + (k - rotation + 26) % 26);
        }
    }

    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        System.out.println("Encryption code: " + new String(cipher.encoder));
        System.out.println("Decryption code: " + new String(cipher.decoder));
        String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
        String coded = cipher.encrypt(message);
        System.out.println("Secret: " + coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer);
    }

    public String encrypt(String message) {
        return transform(message, encoder);
    }

    public String decrypt(String message) {
        return transform(message, decoder);
    }

    private String transform(String original, char[] code) {
        char[] msg = original.toCharArray();
        for (int i = 0; i < msg.length; i++) {
            if (Character.isUpperCase(msg[i])) {
                int j = msg[i] - 'A';
                msg[i] = code[j];
            }
        }
        return new String(msg);
    }
}
