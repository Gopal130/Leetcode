class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int[] merged = new int[m + n];

        int i = 0, j = 0, k = 0;

        // Merge the two sorted arrays
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k] = nums1[i];
                i++;
            } else {
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of nums1
        while (i < m) {
            merged[k] = nums1[i];
            i++;
            k++;
        }

        // Copy remaining elements of nums2
        while (j < n) {
            merged[k] = nums2[j];
            j++;
            k++;
        }

        int size = m + n;

        // Find median
        if (size % 2 == 1) {
            return merged[size / 2];
        } else {
            return (merged[size / 2 - 1] + merged[size / 2]) / 2.0;
        }
    }
}