// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

// | Aspect               | Complexity |
// | -------------------- | ---------- |
// | **Time Complexity**  | O(n \* m)  |
// | **Space Complexity** | O(m)       |

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if(m > n) return -1;

        int i = 0;
        

        while(i < n){
            char c = haystack.charAt(i);
            char ch = needle.charAt(0);
            if(c != ch) {
                i++;
                continue;
            }
            if((i + m - 1) < n){
                if(needle.equals(haystack.substring(i,i+ m ))){
                    return i;
                }
            }
            i++;
        }
        return -1;

    }
}