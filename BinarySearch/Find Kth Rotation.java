// https://www.geeksforgeeks.org/problems/rotation4723/1

// tc : O(log n)
import java.util.*;

class Solution {
    public int findKRotation(List<Integer> arr) {
        
        // hint : find the idx of minimun element bass idx hi rotation hoga
        return bs_(arr);
        
    }
    
    private int bs_(List<Integer> arr){
        int n = arr.size();
        int st = 0;
        int end = arr.size() - 1;
        
        while(st <= end){
             if (arr.get(st) <= arr.get(end)) {
                return st;
            }
            int mid = st + (end - st)/2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;
            
            if(arr.get(mid) <= arr.get(prev) && arr.get(mid) <= arr.get(next)) return mid;
            
            else if(arr.get(mid) >= arr.get(st)){
                // ye sorted part hai or min idx unsorted me hoga
                st = mid + 1;
            }
            else {
                end = mid -1;
            }
        }
        
        return 0;
    }
}