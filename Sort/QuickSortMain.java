import java.util.Arrays;
import java.util.Scanner;

class QuickSortMain {
    public static void main(String[] args) {
        int[] arr = readInput();
        System.out.println("Original Array: " + Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println("  Sorted Array: " + Arrays.toString(arr));
    }

    private static int[] readInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("# of elements: ");
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        sc.close();
        return arr;
    }

    private static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            sort(arr, start, pivot - 1);
            sort(arr, pivot + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++)
            if (arr[j] < pivot)
                swap(arr, ++i, j);

        swap(arr, ++i, end);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return;
    }
}