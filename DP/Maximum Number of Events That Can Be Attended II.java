// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/description/

// | **Time (Brute)**     | O(n^2 \cdot k)                               |
// | **Time (Optimized)** | O(n \cdot k \cdot \log n)$ using binary search |
// | **Space**            | O(n \cdot k)                                |

import java.util.*;
class Solution {

    int ans = 0;
    int n;
    int dp[][];

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a,b) -> Integer.compare(a[0],b[0])); // NlogN
        n = events.length;

        dp = new int[n + 1][k +1];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        // int count = 0;
        ans = solve(events, k, 0); // 0 is idex tracker  
        return ans;
    }

    private int solve(int[][] events, int k, int idx){
        if(idx >= n || k == 0){
            return 0;
        }
        if(dp[idx][k] != -1) return dp[idx][k];

        int end = events[idx][1];

        //THIS IS FINE BUT WE CAN IMPROVE SOMETHING
        // int i ;
        // for(i = idx+1; i < n; i++){
        //     int st = events[i][0];
        //     if(st > end) {
        //         break;
        //     }
        // }
        // int take = events[idx][2] + solve(events, k - 1, i);
        // // count++;
        // int notTake = 0 + solve(events, k, idx+1);
    
        //  BINARY SEARCH
        int low = idx + 1;
        int high = n - 1;
        int newIdx = n; //out of bound ka case
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(end < events[mid][0]){
                high = mid - 1;
                newIdx = mid;
            }
            else{ 
                low = mid + 1;
            }
        }

        int take = events[idx][2] + solve(events, k - 1, newIdx);
        int notTake = 0 + solve(events, k, idx + 1);
        

        return dp[idx][k] = Math.max(take, notTake);
    }
}