class Solution {
    public int[] twoSum(int []nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>(); // nums[i] --> idx
        for(int i = 0; i < nums.length; i++){
            int nextVal = target - nums[i];  // target = nums[i] + nextVal 
            if(map.containsKey(nextVal)){
                return new int[]{i , map.get(nextVal)};
            }
            map.put(nums[i] , i);
        }
        return new int[]{};
    }
}

// // METHOD 1.
// TC : O(N^2)
// SC : o(1)

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int n = nums.length;
//         int arr[] = new int[2];
//         for(int i = 0 ; i < n-1 ;i++){
//             int f = nums[i];
//             for(int j = i+ 1;j < n; j++){
//                 if(nums[j] == target - f) {
//                     arr[0] = i;
//                     arr[1] = j;
//                     return arr;
//                 }
//             }
//         }
//         return new int[]{};
//     }
// }