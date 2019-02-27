package Ciphers;

import java.util.stream.IntStream;

/**
 * Created by cic on 2017-02-21.
 */
public class CaesarCipher implements SymmetricCryptoSystem<Integer> {

    @Override
    public String encode(String clearText, Integer key) {
        IntStream clears = clearText.chars();
        IntStream codes = clears.map(clear -> (clear + key) % Character.MAX_VALUE);
        StringBuilder builder = new StringBuilder();
        codes.forEach(code -> builder.append((char)code));
        return builder.toString();
    }

    private int clearChar(int code, Integer key) {
        int clear = (code - key) % Character.MAX_VALUE;

        if(clear < 0) {
            clear += Character.MAX_VALUE;
        }

        return clear;
    }

    @Override
    public String decode(String cipherText, Integer key) {
        IntStream codes = cipherText.chars();
        IntStream clears = codes.map(code-> clearChar(code,key));
        StringBuilder builder = new StringBuilder();
        clears.forEach(clear -> builder.append((char)clear));
        return builder.toString();
    }
}
