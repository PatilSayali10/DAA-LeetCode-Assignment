class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int[] arr = new int[m + n];

        int i = 0;
        int j = 0;
        int trace = 0;

        
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                arr[trace] = nums1[i];
                i++;
            } else {
                arr[trace] = nums2[j];
                j++;
            }
            trace++;
        }

        
        while (i < m) {
            arr[trace] = nums1[i];
            i++;
            trace++;
        }

        while (j < n) {
            arr[trace] = nums2[j];
            j++;
            trace++;
        }

        int size = arr.length;

        if (size % 2 == 1) {
            return arr[size / 2];
        } else {
            return (arr[size / 2] + arr[size / 2 - 1]) / 2.0;
        }
    }
}
