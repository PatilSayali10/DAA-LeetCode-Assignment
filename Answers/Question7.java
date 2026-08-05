class Solution {

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] arr, int l, int h){

        if(l >= h){
            return;
        }

        int mid = l + (h - l) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, h);

        merge(arr, l, mid, h);
    }

    public void merge(int[] arr, int l, int mid, int h){

        int[] result = new int[h - l + 1];

        int i = l;
        int j = mid + 1;
        int trace = 0;

        while(i <= mid && j <= h){
            if(arr[i] <= arr[j]){
                result[trace] = arr[i];
                trace++;
                i++;
            }else{
                result[trace] = arr[j];
                trace++;
                j++;
            }
        }

        while(i <= mid){
            result[trace] = arr[i];
            trace++;
            i++;
        }

        while(j <= h){
            result[trace] = arr[j];
            trace++;
            j++;

        }

        int k=0;

        for(i = l; i <= h; i++){
            arr[i] = result[k];
            k++;
        }
    }
}

