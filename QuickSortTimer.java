public class QuickSortTimer {
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low >= high) return;
        int p = partition(a, low, high);
        quickSort(a, low, p - 1);
        quickSort(a, p + 1, high);
    }

    private static int partition(int[] a, int low, int high) {
        int mid = low + ((high - low) >>> 1);

        if (a[mid] < a[low]) swap(a, low, mid);
        if (a[high] < a[low]) swap(a, low, high);
        if (a[mid] < a[high]) swap(a, mid, high);

        int pivot = a[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                swap(a, i, j);
                i++;
            }
        }

        swap(a, i, high);
        return i;
    }
    private static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static double timeSort(int[] a) {
        long t1 = System.nanoTime();
        quickSort(a);
        long t2 = System.nanoTime();

        return (t2 - t1) / 1_000_000.0;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        long seedBase = 42L;

        System.out.println("Algorithm: Quick Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("-----------------------");

        for (int s : sizes) {
            int[] arr = ArrayUtils.generateRandomArray(s, seedBase + s);
            int[] arrCopy = ArrayUtils.copy(arr);

            double timeSort = timeSort(arrCopy);
            System.out.printf("%9d | %.3f%n", s, timeSort);
        }
    }
}
