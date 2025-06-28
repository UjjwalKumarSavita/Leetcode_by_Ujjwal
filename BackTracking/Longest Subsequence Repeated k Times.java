// time complexity : O(n * (n/k)! )
// space complecity : O(n / k)
class Solution {

    String result  = "";
    
    public String longestSubsequenceRepeatedK(String s, int k) {
        // step 1 : lets find the freq of each charcters in s
        int freq[] = new int[26]; // due lower charcter

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        // jinki freq k se less unko hata dege (subsequence * k) fir check karna hai origina me ye squence
        int [] canUseChar = new int[26];
        int required[] = new int[26]; // subsequence ko find  karene ke liye
        for(int i = 0 ;i < 26; i++){
            if(freq[i] >= k) {
                canUseChar[i] = 1;
                required[i] = freq[i] / k;
            }
        }


        // L * k <= n --> L <= n / k --> L is maxLength we can take
        int n = s.length();
        int maxLen = n / k;
        StringBuilder curr = new StringBuilder();
        backtracking(s , curr, maxLen, canUseChar, required, k);

        return result;
    }

    private void backtracking (String s, StringBuilder curr, int maxLen, int [] canUseChar, int []required, int k){

        //base case

        if(curr.length() > maxLen) return;


        String currString = curr.toString();
        if((currString.length() > result.length() || //length jada to obivious hai update karna hai
            (currString.length() == result.length() && currString.compareTo(result) > 0)) && isSubsequence(currString, s, k) 
            // length equal to lexographically jo lagrge ho es liye bhi sath ye bhi check kar rahe subsequece bhi to ho
        ){
            result = currString;
        }


        for(int i = 25 ;i >= 0 ;i--){
            if(canUseChar[i] == 0 || required[i] == 0) continue;

            // take character
            curr.append((char)( i + 'a')); // idx ke char me convert kar rahe hai
            required[i]--;

            // do
            backtracking(s, curr, maxLen, canUseChar, required, k);

            // undo
            curr.deleteCharAt(curr.length() - 1);
            required[i]++;

        }


    }

    private boolean isSubsequence(String sub, String s, int k){
        int i = 0;
        int n = s.length();

        int j = 0;
        int m = sub.length();
        
        while(i < n && j < m * k){
            if(s.charAt(i) == sub.charAt(j % m)) j++;

            i++;
        }

        return j == m * k;
    }
}