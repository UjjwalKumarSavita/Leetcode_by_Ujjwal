// https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1?

// | Metric           | Complexity |
// | ---------------- | ---------- |
// | Time Complexity  | `O(n)`     |
// | Space Complexity | `O(k)`     |


import java.util.*;
class Solution {
    public int longestkSubstr(String s, int k) {
        
        // longest substring with k unique charcter to set bana lenge
        Map<Character, Integer> map = new HashMap<>();
        
        int i = 0;
        int j = 0;
        
        int n = s.length();
        int maxLen = -1;
        
        while(j < n){
            char c = s.charAt(j);
            map.put( c, map.getOrDefault(c , 0) + 1);
            
            if(map.size() < k) j++;
            
            else if(map.size() == k){
                maxLen = Math.max(maxLen, j - i + 1 );
                j++;
            }
            else if(map.size() > k){
                while(map.size() > k){
                    char ch = s.charAt(i) ;
                    map.put(ch, map.getOrDefault(ch,0) - 1);
                    if(map.get(ch) == 0) map.remove(ch);
                    i++;
                }
                j++;
            }
        }
        return maxLen;
    }
}