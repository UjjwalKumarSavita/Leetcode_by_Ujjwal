class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        if(n > m) return false;

        int i = 0;
        int j = 0;
        while(i < n && j < m){
            char c = s.charAt(i);
            char ch = t.charAt(j);

            if(c == ch) {
                j++;
                i++;
            }
            else {
                j++;
            }
        }
        if(i == n) return true; // pure s ko dekh liya hai mil gayi hai puri

        return false;

    }
}