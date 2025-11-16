package Algorithm_Analyzer;

public class LinearSearchTimer {
    public static int linearSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) return i;
        }

        return -1;
    }

    private static double timeSearch(int[] a, int key) {
        long t1 = System.nanoTime();
        int idx = linearSearch(a, key);
        long t2 = System.nanoTime();

        return (t2 - t1) / 1_000_000.0; // in milliseconds
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        long seedBase = 42L;

        System.out.println("Algorithm: Linear Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("-----------------------");

        for (int s : sizes) {
            int[] arr = ArrayUtils.generateRandomArray(s, seedBase + s);
            int key = arr[(int) (Math.random() * arr.length)];

            double timeSearch = timeSearch(arr, key);
            System.out.printf("%9d | %.3f%n", s, timeSearch);
        }
    }
}
