import  java.util.*;
class Solution {
    public int numSubseq(int[] nums, int target) {
        // approach 1: 
        // generate all  subsequence  ---> O(2 ^ n)
        // for each subsequence  --> sort --> then min & max find  --> condition check kare & count++ kare  --> O(n) 
        // Tc : O(n * 2^n) :--> tle because of constrain
        // sc : O( 2^n  * n)


        // apprach 2: TWO POINTER
        // TC: O(n log n)
        // SC: O(n)
        Arrays.sort(nums); // squence me min & max puch raha hai to subsequenc me elments order matter nahi karegen
        int n = nums.length;

        int st = 0;
        int end = n - 1;
        int mod = 1000000007;
        int count = 0;

        //power array
        int []power = new int[n];
        power[0] = 1; // 
        for(int i = 1 ; i< n ;i++){
            power[i] = ( power[i - 1] * 2) % mod;
        }

        while(st <= end){
            if(nums[st] + nums[end] <= target){
                count = ( count + power[end - st]) % mod ; // st se end tak sare elements conditon ko satisfy karenge so 
                                                 // ( take and not take) for generating subsequence
                st++;
            }
            else {
                // max Elemts ko neglect karte jooooo
                end--;
            }
        }

        return count;
    }
}