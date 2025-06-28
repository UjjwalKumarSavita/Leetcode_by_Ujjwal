class Solution {
    public int maximumSumSubarray(int[] arr, int k) {
        
        // APNA SLIDING FIXED TMEP
        int n = arr.length;
        
        int i = 0; // window length ko expand and shrink krne ke liye
        int j = 0;
        
        int maxSum = 0;
        int sum = 0;
        while(j < n){
            sum += arr[j];
            
            //if window size small ho k se
            // if(j - i + 1 < k) j++; // size increase karte ja rahe hai
            
            //else if window ka size equal ko k
            if(j - i + 1 == k) maxSum = Math.max(maxSum, sum);
            
            // size large ho gaya to shrink karo window ko or sum se vo hatoa
            else if( j - i + 1 > k) {
                sum -= arr[i];
                maxSum = Math.max(maxSum, sum);
                i++;
            }
            
            j++;
        }
        return maxSum;
        
        
        
        //APPROACH 3. . SLIDING WINDOW
        // TC : O(N)
        // SC : O(1)
        // int maxSum = 0;
        // int n = arr.length;
        
        // //first window ka sum
        // for(int i = 0; i < k ; i++){
        //     maxSum += arr[i];
        // }
        
        // int i = k;
        // int sum = maxSum;
        // while(i < n){
        //     sum += arr[i] - arr[i - k];
        //     maxSum = Math.max(sum, maxSum);
        //     i++;
        // }
        // return maxSum;
        
           
        // APPROACH 2.
        // PREFIX SUM FIND KAR KE BHI SOLVE HO JAYEGAA
        
        
        // APPROACH 1.
        // brute force: TLE   (1110 / 1111 PASS)
        
        // int maxSum = 0;
        // int n = arr.length;
        
        // for(int i = 0 ; i < n - k + 1 ; i++){
        //     int sum = 0;
        //     for(int j = i ; j < i + k ; j++){
        //         sum += arr[j];
        //     }
        //     maxSum = Math.max(maxSum, sum);
        // }
        
        // return maxSum;
        
    }
}