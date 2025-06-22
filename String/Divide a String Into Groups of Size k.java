class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();

        int m = (int) ((n + k -1) / k);
        String[] ans = new String[m];
        int idx = 0;
        for (int i = 0; i < n; i += k) {
            StringBuilder st = new StringBuilder();
            for (int j = i; j < i + k && j < n; j++) {
                st.append(s.charAt(j));
            }

            int x = st.length();
            if(x < k){
                while(x++ < k) st.append(fill);
                
            }
            ans[idx] = st.toString();
            idx++;
        }
        return ans;
    }
}