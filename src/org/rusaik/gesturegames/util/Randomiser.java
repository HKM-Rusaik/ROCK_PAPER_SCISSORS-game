package org.rusaik.gesturegames.util;

import java.util.Random;

public class Randomiser {
    private final Random random;

    public Randomiser() {
        random = new Random();
    }

    public int getRandomNumber(int max) {
        return random.nextInt(max);
    }
}
