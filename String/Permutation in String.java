// https://leetcode.com/problems/permutation-in-string/



// approahc 1
// tc :   O(n * k * logk)
// sc : O(k) : auxilary space

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        // st2 contains st1 --> 
        char arr[] = s1.toCharArray();
        Arrays.sort(arr);
        s1 = new String(arr);

        int n = s1.length();

        int m = s2.length();
        for(int i = 0; i<= m - n ; i++){  // 3. so ---> O(n * k * logk)
            String sub = s2.substring(i, i + n);  //1. O(k)  , k: length of the substirng
            char temp[] = sub.toCharArray();
            Arrays.sort(temp);  //2. O(log k)  : sorting 
            sub = new String(temp);
            if(s1.equals(sub)) return true;
        }

        return false;
    }
}

// slinding window.. Better
// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         int freq1[] = new int[26];
//         int freq2[] = new int[26];

//         for(char c : s1.toCharArray()){
//             freq1[c - 'a']++;
//         }

//         int i = 0;
//         int j = 0;
//         int m = s1.length(); // this is the window size....
//         int n = s2.length();
//         while(j < n){
//             //calculation
//             freq2[s2.charAt(j) - 'a']++;

//             //expand the window
//             if(j - i + 1 < m) j++;  // 
            
//             // time to shrink;
//             else if(j - i +  1 == m){
//                 if(Arrays.equals(freq1, freq2)) return true;
//                 char c = s2.charAt(i);
//                 freq2[c - 'a']--;
//                 i++;
//                 j++;
            
//             }

//             // j++;
//         }

//         return false;
//     }
// }



