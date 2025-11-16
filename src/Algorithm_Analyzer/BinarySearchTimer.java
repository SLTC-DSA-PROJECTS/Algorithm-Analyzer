import java.util.Arrays;

public class BinarySearchTimer {
    public static int binarySearch(int[] a, int key) {
        int low = 0, high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1);

            if (a[mid] == key) return mid;

            if (a[mid] < key) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    private static double timeSearch(int[] sorted, int key) {
        long t1 = System.nanoTime();
        int idx = binarySearch(sorted, key);
        long t2 = System.nanoTime();

        return (t2 - t1) / 1_000_000.0; // in milliseconds
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        long seedBase = 42L;

        System.out.println("Algorithm: Binary Search (array sorted beforehand)");
        System.out.println("Input Size | Time (ms)");
        System.out.println("-----------------------");

        for (int s : sizes) {
            int[] arr = ArrayUtils.generateRandomArray(s, seedBase + s);
            Arrays.sort(arr); // sort first, not part of the timed section
            int key = arr[(int) (Math.random() * arr.length)];

            double timeSearch = timeSearch(arr, key);
            System.out.printf("%9d | %.6f%n", s, timeSearch);
        }
    }
}
