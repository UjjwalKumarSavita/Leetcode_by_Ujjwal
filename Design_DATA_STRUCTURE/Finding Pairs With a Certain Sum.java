// https://leetcode.com/problems/finding-pairs-with-a-certain-sum/description/

// | Method      | Time Complexity | Space Complexity |
// | ----------- | --------------- | ---------------- |
// | Constructor | O(n1 + n2)      | O(n1 + n2 + u2)  |
// | `add()`     | O(1)            | O(1)             |
// | `count()`   | O(n1)           | O(1)             |

// where n1 is length of the nums1
// and n2 is for nums2

import java.util.*;

class FindSumPairs {
    int [] nums1;
    int [] nums2;

    // ADD VAGRA KE LIYE
    Map<Integer,Integer> map1 = new HashMap<>(); // freq of num1
    Map<Integer,Integer> map2 = new HashMap<>(); // freq of num2

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = new int[nums1.length];
        this.nums2 = new int[nums2.length];

        for(int i  = 0 ; i < nums1.length; i++){
            this.nums1[i] = nums1[i];
            // map2.put(nums[2], map1.getOrDefault(nums[2], 0)+ 1);
        }
        for(int i  = 0 ; i < nums2.length; i++){
            this.nums2[i] = nums2[i];
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0)+ 1);
        }
    }
    
    public void add(int index, int val) {
        int oldValue = nums2[index];

        // to uski freq kaam karni hogii
        map2.put(oldValue, map2.getOrDefault(oldValue, 0) - 1);
        if (map2.get(oldValue) == 0) {
            map2.remove(oldValue);
        }

        nums2[index] += val;

        // new ko map me dal ke uski freq ko increase kar denge
        map2.put(nums2[index], map2.getOrDefault(nums2[index], 0) + 1);
    }
    
    public int count(int tot) {
        int count = 0;
        for(int x : nums1){
            int temp = tot - x ;
            if(map2.containsKey(temp)) {
                // ye map 2 me hogi to 
                count += map2.get(temp);
            }
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */