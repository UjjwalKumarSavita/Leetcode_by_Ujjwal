// https://www.geeksforgeeks.org/problems/maximum-value-in-a-bitonic-array3001/1?

// bitonic  : strickly increasing and strickly decreasing
// tc: log(n)
// sc:1
class Solution {
    public int findMaximum(int[] arr) {
        int st =0;
        int n = arr.length;
        int end = arr.length - 1;
        
        while(st <= end){
            int mid = st + (end - st) / 2;
            
            if((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == (n - 1) ||arr[mid] > arr[mid + 1])) return arr[mid];
            
            else if(mid > 0 && arr[mid] > arr[mid - 1]) st = mid + 1;
            
            else  end = mid -1;
        }
        
        return 0;
        
    }
}