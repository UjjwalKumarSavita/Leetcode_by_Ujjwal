// https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1

class Solution {

    static int findFloor(int[] arr, int x) {
        int st = 0;
        int end = arr.length -1;
        int ans = -1;
        
        while(st <= end){
            int mid = st + (end - st) /2;
            
            // if(arr[mid] == x) return mid;
            if(arr[mid] <= x){
                ans = mid;
                st = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        
        return ans;
    }
}
