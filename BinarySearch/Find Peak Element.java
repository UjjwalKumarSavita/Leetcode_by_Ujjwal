// https://leetcode.com/problems/find-peak-element/

class Solution {
    public int findPeakElement(int[] arr) {
        int st =0;
        int n = arr.length;
        int end = arr.length - 1;
        
        while(st <= end){
            int mid = st + (end - st) / 2;
            
            if((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == (n - 1) ||arr[mid] > arr[mid + 1])) return mid;
            
            else if(arr[mid] < arr[mid + 1]) st = mid + 1;
            
            else  end = mid -1;
        }
        
        return 0;
    }
}