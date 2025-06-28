import java.util.*;
class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        
        
        // sliding window...
        // TC : O(N).
        // SC : O(K).
        int i = 0 ;
        int j = 0;
        int n = arr.length;
        
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        if(n == 0) return ans;
        
        while(j < n){
            if(arr[j] < 0) list.add(arr[j]);
            
            // step1 : size ko expand karna
            if(j - i + 1 < k) j++;
            
            // step 2 ; size of window is == k
            else if( j - i + 1 == k){
                // --> calculation
                if(list.size() == 0) {
                    ans.add(0);
                }
                else {
                    ans.add(list.get(0));
                }
                
                // --> window ko slide karna hai
                if(list.size() > 0 && list.get(0) == arr[i]) list.remove(0);
                
                i++;
                j++;
            }
        }
        return ans;
    }
}