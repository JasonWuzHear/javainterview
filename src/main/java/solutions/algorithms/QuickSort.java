package solutions.algorithms;

public class QuickSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }

    public static void sort(int[] arr, int low, int high) {
        if (low > high) return;

        int part = partition(arr, low, high);

        sort(arr, part + 1, high);
        sort(arr, low, part - 1);
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1; // assume pivot is at bottom, index of the smaller element

        for(int j=low; j<high; j++) {
            if (pivot > arr[j]) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[high] = arr[i+1];
        arr[i+1] = pivot;

        return i+1; // index of the pivot
    }
    
}