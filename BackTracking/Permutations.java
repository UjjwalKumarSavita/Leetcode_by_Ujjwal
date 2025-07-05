https://leetcode.com/problems/permutations/description/

// | Aspect               | 1st Code (Swapping)    | 2nd Code (Set + List)                        |
// | -------------------- | ---------------------- | -------------------------------------------- |
// | **Time Complexity**  | O(n × n!)              | O(n × n!)                                    |
// | **Space Complexity** | O(n × n!)              | O(n × n!)                                    |
// | **Extra Space**      | Minimal                | Uses extra `Set`                             |
// | **Use Case**         | More efficient & clean | Easier to understand if `Set` logic is clear |


class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    int n ;
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        solve(0, nums);
        return ans;
    }

    private void solve(int idx, int [] nums){
        if(idx == n){
            List<Integer> sublist = new ArrayList<>();
            for(int x : nums){
                sublist.add(x);
            }
            ans.add(sublist);
            return ;
        }

        for(int i = idx ; i < n ;i++){

            // do
            swap(i, idx, nums);
            
            // explore
            solve(idx + 1, nums);
            
            // undo
            swap(i, idx, nums);
        }
    }

    private void swap(int i , int idx, int []nums){
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }
}

//APPROACH 1.
// using hashset

// class Solution {
//     List<List<Integer>> ans = new ArrayList<>();
//     Set<Integer> set = new HashSet();
//     int n;

//     public List<List<Integer>> permute(int[] nums) {
//         n = nums.length;

//         solve(new ArrayList<>(), nums);
//         return ans;
//     }

//     private void solve(List<Integer> temp, int [] nums){
//         if(temp.size() == n) {
//             ans.add(new ArrayList<>(temp));
//             return ;
//         }

//         for(int i = 0 ; i < n ; i++ ){
            
//             if(!set.contains(nums[i])){
//                 // do the work
//                 temp.add(nums[i]);
//                 set.add(nums[i]);
            
//                 // explore
//                 solve(temp, nums);

//                 // undo the work
//                 temp.remove(temp.size() - 1);
//                 set.remove(nums[i]);
//             }
//         }
//     }
// }