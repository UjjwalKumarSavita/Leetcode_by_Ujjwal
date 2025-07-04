// https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/description/

// TC : len increase by 2 then ---> log(n)
// for the recusion tak stack also decrease by half ---> sc : log(n)

class Solution{
    public char kthCharacter(long k, int[] operations) {
        if(k == 1)  return 'a';

        int n = operations.length;
        long len = 1;
        int opType = 0;
        long newK = k;

        for(int i = 0 ;i < n ;i++){
            len *= 2;
            if(len >= k){
                opType = operations[i];
                newK = k - len / 2;
                break;
            }
        }

        char ch = kthCharacter(newK, operations);
        System.out.println(ch);

        return (opType == 0) ? ch : (ch == 'z') ? 'a' : (char)(ch + 1);
    }
}

// it give TLE :  746 / 901
// tc : 2^ n

// class Solution {
//     public char kthCharacter(long k, int[] operations) {
//         //give code for the perivious code
//         StringBuilder st = new StringBuilder();
//         st.append('a');
        
//         for(int x : operations){
//             if(x == 0) st.append(st);
//             else{
//                 int len = st.length();
//                 for(int i = 0; i< len ;i++){
//                     st.append((char) ( 'a' + ((st.charAt(i) - 'a') + 1) % 26)) ;
//                 }
//             }
//         }

//         return st.charAt((int)(k - 1));
//     }
// }