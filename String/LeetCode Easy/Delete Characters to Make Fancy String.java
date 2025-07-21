// https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/

class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        if(n < 3) return  s;

        StringBuilder st = new StringBuilder();
        st.append(s.charAt(0)).append(s.charAt(1));
        
        for(int i = 2 ;i < n ; i++){
            char c = s.charAt(i);
            char c1 = s.charAt(i - 1);
            char c2 = s.charAt(i - 2);
            if(c == c1 && c == c2) continue;
            st.append(c);
        }
        return st.toString();
    }
}