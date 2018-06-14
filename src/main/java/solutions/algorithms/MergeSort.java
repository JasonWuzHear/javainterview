package solutions.algorithms;

public class MergeSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }

    public static void sort(int[] arr, int low, int high) {
        if (low > high) return; // base case

        int mid = (low+high)/2;

        sort(arr, low, mid);
        sort(arr, mid+1, high);

        merge(arr, low, mid, high);
    }

    static void merge(int[] arr, int low, int mid, int high) {
        // initializing and copying
        int[] left = copy(arr, low, mid);
        int[] right = copy(arr, mid+1, high);
        int nL = left.length;
        int nR = right.length;

        int l = 0;
        int r = 0;

        int i = low;
        while((l<nL) && (r<nR)) {
            if (right[r] > left[l]) {
                arr[i] = left[l];
                l++;
            } else {
                arr[i] = right[r];
                r++;
            }

            i++;
        }

        while (l<nL) {
            arr[i] = left[l];
            l++;
            i++;
        }

        while (r<nR) {
            arr[i] = right[r];
            r++;
            i++;
        }
    }

    static int[] copy(int[] arr, int low, int high) {
        int n = high - low + 1;
        int[] temp = new int[n];
        for (int i=0; i<n; i++)
            temp[i] = arr[low + i];
        return temp;
    }
}