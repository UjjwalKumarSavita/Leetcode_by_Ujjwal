// similarly binary search se karo
// https://www.geeksforgeeks.org/problems/search-in-an-almost-sorted-array/1

class Solution {
    public int findTarget(int arr[], int target) {
        int st = 0;
        int n = arr.length;
        int end = n - 1;
        
        while(st <= end){
            int mid = st + (end - st) / 2;
            
            if(arr[mid] == target) return mid;
            else if(mid > st && arr[mid - 1] == target) return mid -1;
            else if(mid < end && arr[mid + 1] == target) return mid +1;
            
            else if(arr[mid] > target) end = mid - 1;
            else if(arr[mid] < target) st = mid +1;
        }
        
        return -1;
        
    }
}