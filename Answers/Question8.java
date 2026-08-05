class Solution {
    public int findKthLargest(int[] nums, int k) {

        mergeSort(nums, 0, nums.length - 1);

        return nums[nums.length - k];
    }

    void mergeSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    void merge(int[] arr, int left, int mid, int right) {

        int[] trace = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j]) {
                trace[k] = arr[i];
                i++;
            } else {
                trace[k] = arr[j];
                j++;
            }

            k++;
        }

        while (i <= mid) {
            trace[k] = arr[i];
            i++;
            k++;
        }

        while (j <= right) {
            trace[k] = arr[j];
            j++;
            k++;
        }

        for (int m = 0; m < trace.length; m++) {
            arr[left + m] = trace[m];
        }
    }
}
