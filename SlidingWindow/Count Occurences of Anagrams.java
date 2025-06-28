import java.util.*;

class Solution {

    int search(String pat, String txt) {
        int k = pat.length();
        
        //freq of character of pat
        Map<Character, Integer> freq1 = new HashMap<>();
        for(char c : pat.toCharArray()){
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }
        
        int i = 0;
        int j = 0;
        int n = txt.length();
        int count = 0;
        
        Map<Character, Integer> map = new HashMap<>();
       
        
        while(j < n){
            char c = txt.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            // size expand karo pahele to
            if(j - i + 1 < k) j++;
            
            else if(j - i + 1 == k) {
                // --> calcultion
                if(map.equals(freq1)){
                    count++;
                }
                
                // --> window ko shift kro agee &  jo sabse pahele aya ta usko hato
                char ch = txt.charAt(i);
                map.put(ch, map.getOrDefault(ch , 0) -1);
                if(map.get(ch) == 0) map.remove(ch);
                i++;
                j++;
            }        
        }
        
        return count;
    }
}