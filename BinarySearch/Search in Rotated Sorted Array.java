// https://leetcode.com/problems/search-in-rotated-sorted-array/

// rotated means sorted hogaaa pahlee kabhii --> to binary search soch skate  hai
// tc:logn

class Solution {
    public int search(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;


        //binary search template
        while(st <= end){
            int mid = st + (end - st) / 2;
            if(nums[mid] ==  target) return mid;
            else if(nums[st] <= nums[mid]){ // we are in sorted part
                if(nums[st]<= target && nums[mid] > target){
                    end = mid - 1;
                }
                else{
                    st = mid + 1;
                }
            }
            else if(nums[mid] <= nums[end]){ // ye part sorted ho then
                if(nums[end] >= target && nums[mid] < target){
                    st = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}