// method 3 :
//tc : O(n^3)

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Set<List<Integer>> list = new HashSet<>(); // array list bana ke 3sum vale kitah se sare test case pass nahi kar rah 
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int st = j + 1;
                int end = n - 1;
                while (st < end) {
                    long sum = (long) nums[i] + nums[j] + nums[st] + nums[end];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[st], nums[end]));

                        while (st < end && nums[st] == nums[st + 1]) st++;
                        while (st < end && nums[end] == nums[end - 1]) end--;

                        st++;
                        end--;
                    } 
                    else if (sum < target) st++;
                    else end--;
                }
            }
        }
        // return new ArrayList<>(list);
        return list;
    }
}

// metod 2 :
// tc :O(n^3)
// sc : O(n) hashet bana ke liye
// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         int n = nums.length;
//         Set<List<Integer>> set = new HashSet<>();

//         for (int i = 0; i < n - 3; i++) {
//             for (int j = i + 1; j < n - 2; j++) {
//                 // Set<Integer> seen = new HashSet<>();
//                 Set<Long> seen = new HashSet<>();
//                 for (int k = j + 1; k < n; k++) {
//                     // int val = target - nums[i] - nums[j] - nums[k]; // large values ke liye wrong de raha
//                     long val = (long) target - nums[i] - nums[j] - nums[k];
//                     if (val <= Integer.MAX_VALUE && val >= Integer.MIN_VALUE) {
//                         // due to very largevalue humko ye check lagana padaa
//                         // [1000000000,1000000000,1000000000,1000000000] 
//                         //target :-294967296 es type ke number ke liye
//                         if (seen.contains(val)) {
//                             List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], (int) val);
//                             Collections.sort(list);
//                             set.add(list);
//                         }
//                         seen.add((long ) nums[k]);
//                     }
//                 }
//             }
//         }

//         return new ArrayList<>(set);
//     }
// }

// METHOD 1:
// TLE         288/294 (pass)
// tc : O(n^4) ~~ 1.6 * 10^9 hai
// sc : O(n) // set banane vala
// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {

//         int n = nums.length;
//         Set<List<Integer>> set = new HashSet<>();

//         for(int i = 0; i < n - 3 ; i++){
//             for(int j = i + 1 ; j < n - 2 ;j++){
//                 for(int k = j + 1 ;k < n - 1; k++){
//                     for(int l = k+ 1; l < n ; l++){
//                         int sum = nums[i] + nums[j] + nums[k] + nums[l];
//                         if(sum == target) {
//                             List<Integer> list = Arrays.asList(nums[i] , nums[j] , nums[k] , nums[l]);
//                             Collections.sort(list);
//                             set.add(list);
//                         }
//                     }
//                 }
//             }
//         }
//         return new ArrayList<>(set);
//     }
// }