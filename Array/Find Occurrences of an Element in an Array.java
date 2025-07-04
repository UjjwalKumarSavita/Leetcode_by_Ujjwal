// https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/

class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ;i < nums.length ;i++){
            if(x == nums[i]) list.add(i);
        }

        int n = queries.length;
        int ans[] = new int[n];
        for(int j = 0 ; j < n ; j++){
            int m = queries[j];
            ans[j] = m > list.size() ? -1 : list.get(m - 1);
        }

        return ans;
    }
}