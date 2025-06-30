// APPROACH 2: ACHA TELL 1 DIFF KAB AYEGEA ---> ONLY WHEN ( (num + 1) - num == 5 )--> eg ( 6 - 5 == 1)
TC : O(n)  
// SC : O(n) ; for map

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
// pass only  91 / 206 : two pointer se 

// class Solution {
//     public int findLHS(int[] nums) {
//         Arrays.sort(nums);
//         int st= 0; 
//         int end = nums.length - 1;

//         while(st <= end){
//             int diff = nums[end] - nums[st];
//             if( diff == 1) return end - st + 1;
//             else if( diff == 2 && nums[st] != nums[st + 1]) st++;
//             else end--;

//         }
//         return 0;
//     }
// }