package utils;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wei tan
 */
public class RandomUtils {

    public static int[] randomIntArr(int length, int bound) {
        Random random = new Random();

        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int nextInt = random.nextInt(bound);
            result[i] = nextInt;
        }

        System.out.println("randomIntArr: " + Arrays.toString(result));

        return result;
    }
}
