// https://www.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1

// tc : O(logn) + O(logn) ~~ O(logn)
// sc : O(1)
import java.util.*;
class GFG {
    ArrayList<Integer> find(int arr[], int x) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int first = bs_first(arr, x);
        int last = bs_last(arr, x);
        
        list.add(first);
        list.add(last);
        return list;
    }
    
    
    private int bs_first(int[] arr, int x){
        int st = 0;
        int end = arr.length - 1;
        
        int ans = -1;
        while(st <= end){
            int mid = st + (end - st)/2;
            
            if(arr[mid] == x){
                ans = mid;
                end = mid - 1;
            }
            else if(arr[mid] > x){
                end = mid -1;
            }
            else{
                st = mid + 1;
            }
        }
        
        return ans;
    }
    
    private int bs_last(int[] arr, int x){
        int st = 0;
        int end = arr.length - 1;
        
        int ans = -1;
        while(st <= end){
            int mid = st + (end - st)/2;
            
            if(arr[mid] == x){
                ans = mid;
                st = mid + 1;
            }
            else if(arr[mid] > x){
                end = mid -1;
            }
            else{
                st = mid + 1;
            }
        }
        
        return ans;
    }
}
