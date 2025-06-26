class Solution {
    public int longestSubsequence(String s, int k) {
        int count = 0;
        int n = s.length();
        int decimal = 0;
        int pow = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0')
                count++;
            else if(pow <= k){
                count++;
                k -= pow;
            }

            if(pow <= k){
                pow = pow << 1;
            }
        }
        

        return count;
    }
}

//  recusin se time complexity O(2^n) aa rhai hai jisase TLE aa rhai hai
// class Solution {
//     int n;
//     public int longestSubsequence(String s, int k) {
//         n= s.length();
//         return help(s,k, n-1);
//     }
//     private int help(String s, int k, int idx){
//         if(idx < 0) return 0;

//         int take = 0;
//         int character = s.charAt(idx) - '0';

//         long val = (character == 1 ? (1L << (n- idx -1)) : 0);

//         if (val <= k) take = 1 + help(s,(int)(k - val), idx - 1);

//         int skip = help(s, k, idx - 1);

//         return Math.max(take, skip);


//     }
// }



// // THIS PASS 118 / 153 TEST CASE
// class Solution {
//     public int longestSubsequence(String s, int k) {
//         int n = s.length();
//         int count = 0;

//         // 0 ko agar length me add karenge to length increase hogi or number me koi add nahi hoga
//         for (int i = 0; i < n; i++) {
//             if (s.charAt(i) == '0')
//                 count++;
//         }

//         int pow = 1;
//         int decimal = 0;
//         for (int i = n - 1; i >= 0; i--) {
//             if (s.charAt(i) == '1') {
//                 if (pow > k)
//                     break;
//                 if (decimal + pow <= k) {
//                     decimal = decimal + pow;
//                     count++;
//                 }
//             }
//             pow *= 2;
//         }
//         return count;
//     }
// }
