// ye question ka actual solution sliding window se nahi but agar only positive element sho te to ho jata sliding window se
// https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/0

// | Approach             | Time Complexity | Space Complexity | Works with Negatives? |
// | -------------------- | --------------- | ---------------- | --------------------- |
// | HashMap (Prefix Sum) | `O(n)`          | `O(n)`           | ✅ Yes                 |
// | Sliding Window       | `O(n)`          | `O(1)`           | ❌ No (only positives) |


import java.util.*;
class Solution {
    public int maxLen(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If the subarray from index 0 to i has sum == k
            if (sum == k) {
                maxLen = i + 1;
            }

            // If (sum - k) exists in map, we found a subarray with sum == k
            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }

            // Store the first occurrence of this sum
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
        
        //if only positve elements will present then we can do like this also
        // int k = 0;
        
        // int i = 0;
        // int j = 0;
        // int n = arr.length;
        
        // int sum = 0;
        // int maxLen = 0;
        // while(j < n){
        //     sum += arr[j];
            
        //     // expand 
        //     if(sum < k) j++;
            
        //     else if(sum == k){
        //         maxLen = Math.max(maxLen, j - i + 1);
        //     }
        //     else if(sum > k ){
        //         //shrink the window
        //         while(sum > k){
        //             sum -= arr[i];
        //             i++;
        //         }
        //      }
        //     j++;
        // }
        // return maxLen;
    }
}