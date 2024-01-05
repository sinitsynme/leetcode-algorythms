package _88_merge_sorted_array_;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortedArrayMergerTest {

    private static final SortedArrayMerger sortedArrayMerger = new SortedArrayMerger();

    @Test
    void commonExample() {

        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};
        int m = 3;
        int n = 3;

        int[] expected = {1, 2, 2, 3, 5, 6};

        sortedArrayMerger.merge(arr1, m, arr2, n);
        assertEquals(Arrays.toString(expected), Arrays.toString(arr1));
        assertArrayEquals(expected, arr1);
    }

    @Test
    void secondCommonExample() {

        int[] arr1 = {4, 8, 12, 24, 0, 0, 0};
        int[] arr2 = {2, 5, 6};
        int m = 4;
        int n = 3;

        int[] expected = {2, 4, 5, 6, 8, 12, 24};

        sortedArrayMerger.merge(arr1, m, arr2, n);
        assertArrayEquals(expected, arr1);
    }

    @Test
    void secondArrayIsEmpty() {
        int[] arr1 = {1};
        int[] arr2 = {};
        int m = 1;
        int n = 0;

        int[] expected = {1};

        sortedArrayMerger.merge(arr1, m, arr2, n);
        assertArrayEquals(expected, arr1);
    }

    @Test
    void firstArrayHasOnlyZero() {
        int[] arr1 = {0};
        int[] arr2 = {1};
        int m = 0;
        int n = 1;

        int[] expected = {1};

        sortedArrayMerger.merge(arr1, m, arr2, n);
        assertArrayEquals(expected, arr1);
    }
}