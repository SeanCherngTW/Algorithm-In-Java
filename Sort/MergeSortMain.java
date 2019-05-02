import java.util.Scanner;
import java.util.Arrays;

class MergeSortMain {
    public static void main(String[] args) {
        int[] arr = readInput();
        System.out.println("Original Array: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted Array:   " + Arrays.toString(arr));
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

    private static void sort(int[] arr) {
        int len = arr.length;

        if (len < 2)
            return;

        int mid = len / 2;

        int[] left = new int[mid];
        int[] right = new int[len - mid];

        for (int i = 0; i < mid; i++)
            left[i] = arr[i];

        for (int i = mid; i < len; i++)
            right[i - mid] = arr[i];

        sort(left);
        sort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {

        int leftLen = left.length;
        int rightLen = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftLen && j < rightLen) {
            if (left[i] < right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        while (i < leftLen)
            arr[k++] = left[i++];

        while (j < rightLen)
            arr[k++] = right[j++];

    }
}