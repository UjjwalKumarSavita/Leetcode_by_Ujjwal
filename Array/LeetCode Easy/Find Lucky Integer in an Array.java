// https://leetcode.com/problems/find-lucky-integer-in-an-array/

// tc : O(n)
// sc : O(n)
class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = -1;

        for(int x : arr){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }


        // bas yaha pe map ke keySet me traverse kar ke  bhi loop lgaga skate theeee..
        for(int x : arr){
            if(x == map.get(x)) {
                ans = Math.max(ans , x);
            }
        }

        return ans;
    }
}