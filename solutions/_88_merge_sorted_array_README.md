## Solution for [Task 88 - Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)

**Category:** EASY

### Some sort of a "solution"

If we threw our mind away, maybe the easiest solution would be this one: to insert second array into the first one and
then sort the first array using language's API. But this solution costs `O(nlogn)` in the best case.

* Runtime: `O(nlogn)`
* Memory: `O(1)` (arrays are given)

### Brute force solution

Let's pretend we are to complete another merge stage of merge sort. 

To quickly merge two arrays lets use the classic 'Two pointers' method.

The main problem here is to store the result in the same first array. 
Let's use brute force logic and just copy the first array

```
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
```

And then use `arr1copy` instead of arr1 to get results.

* Runtime: `O(m + n)`
* Memory: `O(m + n)`

#### Submit

Passed, but memory wasn't optimized. We need to do something more tricky

### Trying to optimize memory

The way not to use the third array is achievable! We need to start merging arrays into the *end* of first array, not into
the beginning. 

We need to initialize `i` at index of number before the first zero, that is `m-1` and `j` in the end of the second array.


```
        int i = m - 1;
        int j = n - 1;

        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && arr2[j] < arr1[i]) {
                arr1[k--] = arr1[i--];
            } else
                arr1[k--] = arr2[j--];
        }
```

* Runtime: `O(m + n)`
* Memory: `O(1)`

#### Submit

Passed with optimized memory