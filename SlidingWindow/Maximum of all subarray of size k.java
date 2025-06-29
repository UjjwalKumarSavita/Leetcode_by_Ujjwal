// interviewbit
// https://www.interviewbit.com/problems/sliding-window-maximum/

// tc : O(n);
// sc : O(k);
import java.util.*;
class Solution {
    public int[] slidingMaximum(final int[] A, int k) {
        int n = A.length;
        
        int i = 0; 
        int j = 0;
        // int max = Integer.MIN_VALUE;
        
        int ans[] = new int[n - k +1];
        List<Integer> list = new ArrayList<>();
        
        
        while(j < n){
            //calculation
            while(!list.isEmpty() &&  list.get(list.size() - 1) < A[j]){
                
                // list se element hatao
                list.remove(list.size() -1);
            }
            list.add(A[j]);
            // max = Math.max(max, A[j]);
            
            
            //size expand
            if(j - i + 1 < k) j++;
            
                        
            //slid the window
            else if(j - i + 1 == k){
                //calculation se ans find karna
                ans[i] = list.get(0);
                
                //slid the window
                if(list.get(0) == A[i]) list.remove(0);
                
                i++;
                j++;
                
            }
        }
        
        return ans;
    }
}
