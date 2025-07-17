// https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/description/

// equation vali condition thi vahi se find karo condition
class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;

        int evenCount = 0; // for rem 0 ke liye 
        int oddCount = 0; // for rem 0 ke liye
        int alterCount = 1;// odd + even  or  even + odd ==> for the reminder 1 ke liye

        for(int num : nums){
            if(num % 2 == 0){ // even
                evenCount++;
            }
            else { // odd
                oddCount++;
            }
        }

        int parity = nums[0] % 2 ;
        for(int i =  1 ; i < n ; i++){
            int currParity = nums[i] % 2 ;

            if(parity != currParity){
                alterCount++;
                parity = currParity;
            }
        }

        int result = Math.max(evenCount, Math.max(oddCount, alterCount));

        return result;
    }
}