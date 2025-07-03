// https://leetcode.com/problems/find-the-original-typed-string-ii/
import java.util.*;

// ************************APPROACH 1 :-->>  TLE in both the case
// // // tc : O( n + m * k * maxFreq)  recursion : 711/ 846 testcase || memorirsation : 830 / 846 :: 
// // // sc : O(n * k)

// class Solution {
//     int mod = 1000000007;
//     int dp [][];
//     public int possibleStringCount(String word, int k) {
//         if(word.length() < k) return 0;
        
//         // lets find the freq of char
//         int n = word.length();

//         ArrayList<Integer> freq = new ArrayList<>();
//         int count = 1; 
//         for(int i = 1; i < n ;i++ ){  // tc : O(n)
//             if(word.charAt(i) != word.charAt(i-1)){
//                 freq.add(count);
//                 count = 1;
//             }
//             else{
//                 count++;
//             }
//         }
//         freq.add(count);

//         long possibleStr = 1;
//         for(int x : freq){  // tc : O(n)
//             possibleStr = (possibleStr * x) % mod;
//         }


//         if(freq.size() >= k) return (int)possibleStr;

//         // for memor
//         int m = freq.size();
//         dp = new int [ m + 1][ k + 1];
//         for(int []x : dp) Arrays.fill(x, -1);

//         long invalid = findInValid(0, 0, freq, k); // 0 = idx (for traverse over freq), 0 = count 

//         return (int) ( possibleStr - invalid + mod) % mod;
//     }


//     // tc :  O(m * k * maxFreq) // m = freq.size(), k = given, maxFreq= any element 
//     private long findInValid(int idx, int count, ArrayList<Integer> freq, int k){

//         // base case:
//         if(idx >= freq.size()){
//              return (count < k) ? 1: 0; // invalid then 1 valid then 0;
//         }

//         if( dp[idx][count] != -1) return dp[idx][count];
//         long result = 0;
        
//         for(int take = 1 ; take <= freq.get(idx); take++){
//             if (count + take < k) {
//                 // for invlaid 
//                 result = (result + findInValid(idx + 1, take + count, freq,k)) % mod;
//             }
//         }

//         return dp[idx][count] = (int)result;
//     }
// }

// **************** APPROACH 2  TABULATION METHOD *****

// recursion ka just opposite vala tabulation tha yeee  TLE : 833/ 846 test case
// Time Complexity = O(n × k × n) 
// soace complexity = O(n * k);
// class Solution{
//     int mod = (int)1e9 + 7;
//     int dp[][];
//     public int possibleStringCount(String word, int k) {
//         if(word.length() < k) return 0;

//         List<Integer> freq = new ArrayList<>();
//         int n = word.length();
//         int count = 1;
//         for(int i = 1 ; i < n ; i++){
//             if(word.charAt(i) != word.charAt(i - 1)){
//                 freq.add(count);
//                 count = 1;
//             }
//             else{
//                 count++;
//             }
//         }
//         freq.add(count);

//         long totalPossible = 1;
//         for(int x : freq){
//             totalPossible = ( totalPossible * x) % mod;
//         }

//         if(freq.size() >= k) return (int)totalPossible;

//         // tabulation method : rcurion ka just opposite
//         int m = freq.size();
//         dp = new int [m + 1][ k + 1];

//         // base case
//         for( int i = k - 1; i >= 0 ; i-- ){
//             dp[m][i] = 1;// last indx me sab fill kar diyaaaaa 
//         }

//         // actual code
//         for(int idx = m - 1 ; idx >= 0; idx-- ){ 
//             // idex pe change ho raha h
//             for(int co = k -1 ; co >= 0 ; co--){
//                 //coutn ke liye
//                 long result = 0;
//                 for(int take = 1 ; take <= freq.get(idx); take++ ){
//                     if(take + co < k){
//                         result = (result + dp[idx + 1][co + take] ) % mod;
//                     }
//                     else{
//                         break;
//                     }
//                 }

//                 dp[idx][co] = (int)result;
//             }
//         }


//         int invalid = dp[0][0];
//         return (int)(totalPossible - invalid + mod) % mod;

//     }

// }

// ***************************** APPRAOCH 3 TBULATION METHON  *******************

class Solution{
    int mod = (int)1e9 + 7;
    int dp[][];
    public int possibleStringCount(String word, int k) {
        if(word.length() < k) return 0;

        List<Integer> freq = new ArrayList<>();
        int n = word.length();
        int count = 1;
        for(int i = 1 ; i < n ; i++){
            if(word.charAt(i) != word.charAt(i - 1)){
                freq.add(count);
                count = 1;
            }
            else{
                count++;
            }
        }
        freq.add(count);

        long totalPossible = 1;
        for(int x : freq){
            totalPossible = ( totalPossible * x) % mod;
        }

        if(freq.size() >= k) return (int)totalPossible;

        // tabulation method : rcurion ka just opposite
        int m = freq.size();
        dp = new int [m + 1][ k + 1];

        // base case
        for( int i = k - 1; i >= 0 ; i-- ){
            dp[m][i] = 1;// last indx me sab fill kar diyaaaaa 
        }

        // actual code
        for(int idx = m - 1 ; idx >= 0; idx-- ){ 
            // idex pe change ho raha h

            int[] prefix = new int[k + 2];
            for (int h = 1; h <= k; h++) {
                prefix[h] = (prefix[h - 1] + dp[idx + 1][h - 1]) % mod;
            }
            for(int co = k -1 ; co >= 0 ; co--){
                //coutn ke liye
                int l = co + 1;
                int r = co + freq.get(idx);

                if (r + 1 > k) {
                    r = k - 1;
                }

                if (l <= r) {
                    dp[idx][co] = (prefix[r + 1] - prefix[l] + mod) % mod;
                }
            }
        }


        int invalid = dp[0][0];
        return (int)(totalPossible - invalid + mod) % mod;

    }

}