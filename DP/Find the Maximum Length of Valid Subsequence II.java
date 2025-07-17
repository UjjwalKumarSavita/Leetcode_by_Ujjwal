// https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-ii/description/

// esame last vala tablulation vala case yaha laga rha rahe hai
import java.util.*;
class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        
        int dp[][] = new int[k][n];
        // 0 = zero row is for the mode 0 vala
        // 1 = first row is for the mode 1 vala
        // k -1 = zero row is for the mode k vala
        
        for(int []x : dp){
            Arrays.fill(x, 1);
        }

        int maxLen = 0;
        for(int i = 1 ;i < n ;i++){
            for(int j = 0 ; j < i; j++){
                int mod = (nums[i] + nums[j]) % k;

                dp[mod][i] = Math.max(dp[mod][i], dp[mod][j] + 1);
                maxLen = Math.max(maxLen, dp[mod][i]);
            }
        }

        return maxLen;
    }
}