import java.util.*;

class ArrayUtils {

    static int[] generateRandomArray(int n, long seed) {
        Random rnd = new Random(seed);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = rnd.nextInt(1_000_000);
        return a;
    }
    static int[] copy(int[] src) {
        return Arrays.copyOf(src, src.length);
    }
}
