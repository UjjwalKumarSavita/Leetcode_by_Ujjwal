// | Time Complexity  | `O(k)` |
// | Space Complexity | `O(k)` |

class Solution {
    public char kthCharacter(int k) {
        StringBuilder st = new StringBuilder();
        st.append('a');
        while(st.length()<= k){
            int len = st.length();
            for(int i = 0 ; i < len ;i++){
                st.append((char) ('a' + ((st.charAt(i) - 'a') + 1) % 26));
            }
        }


        return st.charAt(k - 1);
    }
}