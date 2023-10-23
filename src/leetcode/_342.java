package leetcode;

/**
 * @author wei tan
 */
public class _342 {
    public static boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        while (n % 4 == 0) {
            n /= 4;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
    }
}
