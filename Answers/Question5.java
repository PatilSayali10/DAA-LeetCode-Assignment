class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1){   //if array has only one element then it is ony peak automatically example-[5] 
            return 0;
        }
        
        else if(nums[0]>nums[1]){  //if first element is peak then we will return index 0 because first element don't have left side to check example-[9,5,2] :- here 9>5
            return 0;
        }
        
        else if(nums[nums.length-1]>nums[nums.length-2]){ // here we are checking last element is peak or not example-[2,5,9] :- 9>5
            return nums.length-1;
        }
        
        else{   //Binary search
            int low = 1;
            int high = nums.length-2;

            while(low<=high){
                int mid = (low + high)/2;

                if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){  //[1,4,8,3,2]:- 8>4 and 8>3 then we will return index 2
                    return mid;
                }
                else if(nums[mid]<nums[mid+1]){  //[1,3,5,8,10] :- 5<8 then array will increase towards right
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            return -1;
        }
    }
}
