// https://leetcode.com/problems/remove-element/description/
// | Method                  | Time Complexity | Space Complexity |
// | ----------------------- | --------------- | ---------------- |
// | **Method 2 (In-place)** | O(n)            | O(1)             |
// | **Method 1 (List)**     | O(n²)           | O(n)             |

class Solution {
    public int removeElement(int[] nums, int val) {
        //method 2::
        int j = 0;
        int n = nums.length;
        for(int i = 0; i < n ;i++){
            if(nums[i] != val){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                j++;
            }
        }
        return j;


        // method 1 ::
        // int j = 0;
        // int n = nums.length;
        // List<Integer> list = new ArrayList<>();
        // for(int x: nums){
        //     if(x != val) list.add(x);
        // }
        // int len = list.size();
        // for(int i = 0 ;i < len ; i++){
        //     nums[i] = list.remove(0);
        // }
        // return len;
    }
}