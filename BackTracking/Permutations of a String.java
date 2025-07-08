// https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1

// | Feature                 | Approach 1 (Unsorted, Local Pruning) | Approach 2 (Sorted, Global Pruning) |
// | ----------------------- | ------------------------------------ | ----------------------------------- |
// | Handles duplicates      | ✅ Partially (locally)                | ✅ Fully (via sorting + pruning)     |
// | Time Complexity         | O(n × n!)                            | O(n × unique permutations)          |
// | Space Complexity        | O(n²) (new objects + call stack)     | O(n) (reused `StringBuilder`)       |
// | Efficiency (Duplicates) | ❌ Less efficient                     | ✅ More efficient                    |



//  APPROACH 2 :
// YE AYESE ESI LIYE YE DUBLICAT KKO BHI COVER KAR RHA HAI
import java.util.*;
class Solution {
    
    ArrayList<String> ans = new ArrayList<>();

    public ArrayList<String> findPermutation(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr); // helps in skipping duplicates

        boolean[] visited = new boolean[arr.length];
        StringBuilder st = new StringBuilder();

        solve(arr, visited, st);
        return ans;
    }
    
    private void solve(char[] arr, boolean[] visited, StringBuilder st){
        if(st.length() == arr.length){
            ans.add(st.toString());
            return;
        }
        
        for(int i = 0 ; i < arr.length ; i++ ){
            if(visited[i]) continue;

            // Skip duplicates
            if(i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;

            visited[i] = true;
            st.append(arr[i]);
            
            solve(arr, visited, st);
            
            visited[i] = false;
            st.deleteCharAt(st.length() -1);
        }
    }
}



// APPROACH 1 : BRANCH HI CUT KAR DIYEEEEE
// class Solution {
//     public ArrayList<String> findPermutation(String s) {
        
//         ArrayList<String> ans = new ArrayList<>();
//         if (s == null || s.length() == 0) return ans;

        
//         StringBuilder ipSt = new StringBuilder(s);
//         StringBuilder opSt = new StringBuilder();
        
//         solve( ipSt, opSt, ans) ;// ipSt :input string &  opSt:- output string hogii
    
//         return ans;
//     }
    
//     private void solve(StringBuilder ipSt, StringBuilder opSt,ArrayList<String> ans){
//         if(ipSt.length() == 0){
            // ans.add(opSt.toString());
//             return ;
//         }
        
//         Set<Character> set = new HashSet<>();
//         for(int i = 0; i < ipSt.length(); i++){
//             char ch = ipSt.charAt(i);
//             if(!set.contains(ch)){
//                 set.add(ch);
                
//                 StringBuilder newIp = new StringBuilder(ipSt);
//                 newIp.deleteCharAt(i);
                
//                 StringBuilder newOp = new StringBuilder(opSt);
//                 newOp.append(ch);
                
//                 solve(newIp, newOp, ans);
//             }
//         }
//     }
// }