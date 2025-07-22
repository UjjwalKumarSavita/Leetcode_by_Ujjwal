// https://leetcode.com/problems/maximum-erasure-value/description/

// sliding window + HashSet
// tc : O(n)
// sc : O(n)
import java.util.*;
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;
        int sum = 0;
        Set<Integer> set = new HashSet<>();

        int maxScore = 0;

        while(j < n){
            while(set.contains(nums[j])){
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            set.add(nums[j]);
            sum += nums[j];
            maxScore = Math.max(maxScore, sum);
            j++;
        }
        return maxScore;

    }
}