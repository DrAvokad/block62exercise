package Ciphers;

/**
 * Created by cic on 2017-02-21.
 */
public interface SymmetricCryptoSystem<K> {
    String encode(String clearText, K key);
    String decode(String cipherText, K key);
}
