// https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/description/

// tc : O(n)
// sc : O(n)
import java.util.*;
class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum =0;
        int j = 0;
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        while(j < n){
            if(nums[j] <= 0){ // ye negative vale ko alaga se karenge
                maxSum = Math.max(maxSum, nums[j]);
            }

            else if(!set.contains(nums[j])){
                sum += nums[j];
                set.add(nums[j]);
                
            }
            j++;
        }

        return (sum == 0 ) ? maxSum : sum;
    }
}