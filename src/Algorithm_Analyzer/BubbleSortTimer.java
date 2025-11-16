public class BubbleSortTimer {
    public static void bubbleSort(int[] a) {
        boolean swapped;
        int n = a.length;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (a[i - 1] > a[i]) {
                    int tmp = a[i - 1]; a[i - 1] = a[i]; a[i] = tmp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    private static double timeSort(int[] a) {
        long t1 = System.nanoTime();
        bubbleSort(a);
        long t2 = System.nanoTime();

        return (t2 - t1) / 1_000_000.0;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        long seedBase = 42L;

        System.out.println("Algorithm: Bubble Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("-----------------------");

        for (int s : sizes) {
            int[] base = ArrayUtils.generateRandomArray(s, seedBase + s);
            int[] arr = ArrayUtils.copy(base);

            double timeSort = timeSort(arr);
            System.out.printf("%9d | %.3f%n", s, timeSort);
        }
    }
}
