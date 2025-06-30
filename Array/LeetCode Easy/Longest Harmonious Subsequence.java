// APPROACH 2: ACHA TELL 1 DIFF KAB AYEGEA ---> ONLY WHEN ( (num + 1) - num == 5 )--> eg ( 6 - 5 == 1)
// TC : O(n)  
// SC : O(n) ; for map
import java.util.*;
class Solution{
    public int findLHS(int [] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int maxLen = 0;
        for(int x : map.keySet()){

            if(map.containsKey(x+1)){
                int len = map.get(x) + map.get(x+1);
                maxLen = Math.max(maxLen , len);
            }
        }
        return maxLen;
    }
}



// APPROACH 1 :
// tc : O(N logN)
// sc : O(1)
// class Solution {
//     public int findLHS(int[] nums) {
//         Arrays.sort(nums);
//         int i = 0, maxLen = 0;

//         for (int j = 0; j < nums.length; j++) {
//             while (nums[j] - nums[i] > 1) {
//                 i++;
//             }
//             if (nums[j] - nums[i] == 1) {
//                 maxLen = Math.max(maxLen, j - i + 1);
//             }
//         }

//         return maxLen;
//     }
// }