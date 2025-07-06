// https://leetcode.com/problems/split-array-largest-sum/

// | **Time**   | $O(n \cdot \log(\text{sum} - \text{max}))$ |
// | **Space**  | $O(1)$                                     |


class Solution {
    public int splitArray(int[] nums, int k) {
        int st = 0;
        int end = 0;
        for(int x : nums){
            st = Math.max(st, x);
            end += x;
        }
        // st = (end / k)  - 1;
        // if(st < 0) st = 0;

        int ans = 0;

        while(st <= end){
            int mid = st + (end - st) / 2; // ye max value hai jisko keo le leke array ko k part me split karna hai
            
            System.out.println(mid);
            if(split(mid, nums, k) == true){
                ans = mid ;
                end = mid - 1;
            }
            else{
                st = mid + 1;
            }
        }
        return ans;
    }
    private boolean split(int sum , int [] nums, int k){
        int count = 1;
        int s = 0; // sum ke liye
        for(int x : nums){
            if(s + x > sum){
                count++;
                s = x;
            }
            else {
                s += x;
            }

            if(count > k) return false;
        }
        return true;
    }
}