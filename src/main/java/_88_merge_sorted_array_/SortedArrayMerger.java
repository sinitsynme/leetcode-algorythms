package _88_merge_sorted_array_;

import java.util.Arrays;

public class SortedArrayMerger {

    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1;
        int j = n - 1;

        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && arr2[j] < arr1[i]) {
                arr1[k--] = arr1[i--];
            } else
                arr1[k--] = arr2[j--];
        }
    }


    public void mergeOptimizedButDirty(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1;
        int j = n - 1;

        int k = m + n - 1;

        while (j >= 0 && i >= 0) {
            if (arr2[j] >= arr1[i]) {
                arr1[k] = arr2[j];
                j--;
            } else {
                arr1[k] = arr1[i];
                i--;
            }
            k--;
        }

        while (j >= 0) {
            arr1[k] = arr2[j];
            j--;
            k--;
        }
    }

    public void mergeNotOptimized(int[] arr1, int m, int[] arr2, int n) {
        int[] arr1copy = Arrays.copyOf(arr1, m + n);

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (arr1copy[i] <= arr2[j]) {
                arr1[i + j] = arr1copy[i];
                i++;
            } else {
                arr1[i + j] = arr2[j];
                j++;
            }
        }

        while (i < m) {
            arr1[i + j] = arr1copy[i];
            i++;
        }
        while (j < n) {
            arr1[i + j] = arr2[j];
            j++;
        }

    }
}
