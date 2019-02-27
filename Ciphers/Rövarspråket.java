package Ciphers;

/**
 * Created by cic on 2017-02-21.
 */
public class Rövarspråket implements SymmetricCryptoSystem<Void> {

    private static String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";

    private boolean isConsonant(char clear) {
        return consonants.indexOf(clear) > -1;
    }

    private String encodeChar(char clear) {
        String code = "" + clear;
        if(isConsonant(clear)) {
            code = code + "o" + Character.toLowerCase(clear);
        }
        return code;
    }

    @Override
    public String encode(String clearText, Void key) {
        StringBuilder code = new StringBuilder();
        for(char clear : clearText.toCharArray()) {
            code.append(encodeChar(clear));
        }
        return code.toString();
    }

    @Override
    public String decode(String cipherText, Void key) {
        StringBuilder clear = new StringBuilder();

        for(int i=0; i < cipherText.length(); i++) {
            char code = cipherText.charAt(i);
            clear.append(code);
            if(isConsonant(code))
                i+=2;
        }
        return clear.toString();
    }
}
