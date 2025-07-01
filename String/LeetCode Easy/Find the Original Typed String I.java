class Solution {
    public int possibleStringCount(String word) {
        
        int n = word.length();

        int count = 1;
        for(int i = 1 ; i< n; i++){
            if(word.charAt(i) == word.charAt(i - 1)) count++; // equal hoga tabi galat hoga 
        }
        
        return count;
        
        
        
        
        //ACC TO TEST CASE WE THINK SAME CHARACTERS SATH HI HONGE BUT NAHI 
        // TC : O(N) 553/780 TEST CASE 
        // test case tha word = "ere" , output : 1

        // int [] freq = new int[26];
        
        // for(char c : word.toCharArray()){
        //     freq[c - 'a']++;
        // }

        // int count = 1;
        // for(int x : freq){
        //     if(x > 1) count += (x - 1);
        // }

        // return count;
    }
}