// https://leetcode.com/problems/valid-word/description/

class Solution {
    public boolean isValid(String word) {
        
        int n = word.length();

        if(n < 3) return false;

        int vol = 0;    // count of the vowel
        int cons = 0 ; // count of the consonant

        for(char c : word.toCharArray()){
            
            // logic 2 ....
            if(Character.isLetter(c)){
                char low = Character.toLowerCase(c);
                System.out.println (low);

                if("aeiou".indexOf(low) != -1) vol++;
                else cons++;
            }
            else if(!Character.isDigit(c)) return false;

            // logic 1......
            // //vowel check
            // if( (c == 'a' || c == 'A' ||
            //     c == 'e' || c == 'E' ||
            //     c == 'i' || c == 'I' || 
            //     c == 'o' || c == 'O' || 
            //     c == 'u' || c == 'U' ) ){
            //         vol++;
            // }
            // else if (( (c >= 65 && c <= 90) || (c >= 97 && c <= 122) )) {
            //     cons++; 
            // }
            // else if(!Character.isDigit(c)) return false;
        } 

        if(vol == 0 || cons == 0) return false;
        return true;
    }
}