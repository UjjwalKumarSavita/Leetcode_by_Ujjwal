// https://leetcode.com/problems/maximum-score-from-removing-substrings/description/

import java.util.*;
// tc: O(n) :: ya to if chala hoga ya to else vala so over all O(N)
// sc : O(n) :: for both stringBuilder total N spaces hi liye hongee
class Solution {
    public int maximumGain(String s, int x, int y) {
        int result = 0;
        if(x > y){
            //x matlbe " ab ko remove krooo"
            StringBuilder st = new StringBuilder();
            for(char ch : s.toCharArray()){
                if(!st.isEmpty() && (st.charAt(st.length() - 1) == 'a' && ch == 'b')) {
                    st.deleteCharAt(st.length()-1);
                    result += x;
                }
                else{
                    st.append(ch);
                }
            }

            // ba check karenge....
            // remaing me traverse karenge so upar vali sbustring me traverse karenge
            StringBuilder st2 = new StringBuilder();
            for(int i = 0; i < st.length(); i++){
                char c = st.charAt(i);
                if(!st2.isEmpty() && st2.charAt(st2.length() - 1) == 'b' && c == 'a'){
                    st2.deleteCharAt(st2.length() - 1);
                    result += y;
                }
                else{
                    st2.append(c);
                }
            }
        }
        else{
            //x matlbe " ba ko remove krooo"
            StringBuilder st = new StringBuilder();
            for(char ch : s.toCharArray()){
                if(!st.isEmpty() && (st.charAt(st.length() - 1) == 'b' && ch == 'a')) {
                    st.deleteCharAt(st.length()-1);
                    result += y;
                }
                else{
                    st.append(ch);
                }
            }

            // ba check karenge....
            // remaing me traverse karenge so upar vali sbustring me traverse karenge
            StringBuilder st2 = new StringBuilder();
            for(int i = 0; i < st.length(); i++){
                char c = st.charAt(i);
                if(!st2.isEmpty() && st2.charAt(st2.length() - 1) == 'a' && c == 'b'){
                    st2.deleteCharAt(st2.length() - 1);
                    result += x;
                }
                else{
                    st2.append(c);
                }
            }
        }

        return result;
    }
    
}

// this is correct but :: TLE FOR VERY LONG STRING.. (58 / 77)..
// while overall N times hi chelega but but INDEX OR DELETE WORST CASE ME 'N' TIME 
// WROST CASE O (n ^ 2) ho jaeygaaaa

// class Solution {
//     public int maximumGain(String s, int x, int y) {
//         StringBuilder st = new StringBuilder(s);
        
//         int max_x = 0;
//         if(x > y){
//             max_x = 1;
//             //"ab ke liye jada milengee" :: x max hoga to max zero nahi khoga
//         }
//         return findMax(st, x, y, max_x);
//     }

//     private int findMax(StringBuilder st, int x, int y, int max_x){

//         int result = 0;

        
//             // jo max
//             if(max_x != 0){ // x max hai hamraaa :: to hum "ab hatayenge"
            
//                 String target = "ab";
//                 int index;

//                 while ((index = st.indexOf(target)) != -1) {
//                     result += x;
//                     st.delete(index, index + target.length());
//                 }

//                 // now "ba" ko check akr loo
//                 target = "ba";
//                 while ((index = st.indexOf(target)) != -1) {
//                     result += y;
//                     st.delete(index, index + target.length());
//                 } 

//             }
//             else{ // y max raha hoga to hum apne "ba" ko pahle jitne ho sake utane hatane hongee
//                 String target = "ba";
//                 int index;

//                 while ((index = st.indexOf(target)) != -1) {
//                     result += y;
//                     st.delete(index, index + target.length());
//                 }
//                 target = "ab";

//                 while ((index = st.indexOf(target)) != -1) {
//                     result += x;
//                     st.delete(index, index + target.length());
//                 }

//             }  
           
        
//         return result;
//     }
// }