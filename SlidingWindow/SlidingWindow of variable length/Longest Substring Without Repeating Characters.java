// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// | Metric           | Complexity     |
// | ---------------- | -------------- |
// | Time Complexity  | `O(n)`         |
// | Space Complexity | `O(min(n, m))` |

// without repeating mean all unique
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int  n = s.length();
        
        int maxLen = 0;

        while(j < n){

            char c = s.charAt(j);

            //calculation
            map.put(c, map.getOrDefault(c, 0) +1);


            // all unique characters....
            if(map.size() == j - i + 1) {
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            }

            else if(map.size() < j - i +1) {
                //duplicate aa gahe hai
                while(map.size() < j - i +1){
                    char ch = s.charAt(i);
                    map.put(ch, map.getOrDefault(ch, 0) -1);
                    if(map.get(ch) == 0) map.remove(ch); 
                    i++;
                }
                j++;
            }
        }
        return maxLen;
    }
}