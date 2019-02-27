package Bags;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by cic on 2017-02-21.
 */
public class StringBag {

    private final int bound;
    private int size;
    private String[] contents;

    StringBag(int bound) {
        size = 0;
        this.bound = bound;
        contents = new String[bound];
    }

    public int getSize() {
        return size;
    }

    public int getBound() {
        return bound;
    }

    public void insert(String stringToAdd) {
        contents[size] = stringToAdd;
        size++;
    }

    public String grab() {
        int index = ThreadLocalRandom.current().nextInt(0,size);
        String grabbedString = contents[index];
        for(int i = index; i < size - 1; i++) {
            contents[i] = contents[i+1];
        }
        size--;
        return grabbedString;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < size; i++) {
            builder.append(contents[i]).append("\n");
        }

        return builder.toString();
    }

}
