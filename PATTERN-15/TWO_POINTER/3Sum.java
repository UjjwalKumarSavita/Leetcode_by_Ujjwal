import java.util.*;

class Solution{
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        
        //step 1 : array ko sort karo
        //step 2 : outer loop  + left right move karao ke sum laoo

        Arrays.sort(nums); // step 1
        

        for(int i = 0; i< n-2 ;i++){
            //duplicate le rahe hai so
            if(i > 0  && nums[i] == nums[i - 1]) continue;


            // int target = -nums[i];

            int st = i + 1;
            int end = n -1;

            while(st < end){
                int sum =nums[i]+ nums[st] + nums[end];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i], nums[st], nums[end]));
                    

                     // Skip duplicates for left and right
                    // int leftVal = nums[st];
                    // int rightVal = nums[end];
                    while (st < end && nums[st] == nums[st + 1]) st++;
                    while (st < end && nums[end] == nums[end - 1]) end--;

                    st++;
                    end--;
                }
                else if(sum < 0) st++;
                else end--;
            }
        }
        return list;
    }
}


// method 2
// TC : O(N^2)
// SC : O(N) FOR THE HASHSET

// HINT  : threeSum = outerloop + twoSumProblem

// class Solution{
//     public List<List<Integer>> threeSum(int[] nums){
//         Set<List<Integer>> set = new HashSet<>();
//         int n = nums.length;

//         for(int i = 0; i < n ;i++){
//             Set<Integer> subset = new HashSet<>();

//             //twoSum ka yaha se
//             for(int j = i+ 1; j< n ; j++){
//                 int target = -nums[i] - nums[j];
//                 if(subset.contains(target)){
//                     List<Integer> sublist = Arrays.asList(nums[i], nums[j], target);
//                     Collections.sort(sublist); // set me araange different ki vajh se same value ko different position me man lega or le lenga
//                     set.add(sublist);
//                 }
//                 subset.add(nums[j]); // seen kar chuke perivious
//             }
//         }

//         return new ArrayList<>(set);
//     }
// }






// APPROACH 1:
// BRUTE FORCE : TLE 309/314 (pass)
// TC : O(n^3)
// SC : O(N) // SET BANA RHAE USKE LIYE DUPLICATE KO REMOVE KAR RHAE HAI

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         int n = nums.length;
//         HashSet<List<Integer>> set = new HashSet<>();

//         for (int i = 0; i < n - 2; i++) {
//             for (int j = i + 1; j < n - 1; j++) {
//                 for (int k = j + 1; k < n; k++) {
//                     int val = nums[i] + nums[j] + nums[k];
//                     if (val == 0) {
//                         List<Integer> sublist = new ArrayList<>();
//                         sublist.add(nums[i]);
//                         sublist.add(nums[j]);
//                         sublist.add(nums[k]);
//                         Collections.sort(sublist);
//                         set.add(sublist);
//                     }
//                 }
//             }
//         }
//         // List<List<Integer>> list = new ArrayList<>();
//         // for(List<Integer> x : set){
//         //     list.add(x);
//         // }
//         // return list;


//         // OR
//         return new ArrayList<>(set);
//     }
// }