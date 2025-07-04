// https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

// Binary search :  MIN( MAX )
// | Time       | `O(n * log(sum(arr) - max(arr)))` |
// | Space      | `O(1)`                            |


class Solution {
    public static int findPages(int[] arr, int k) {
        
        int n = arr.length; // no of books
        if(n < k) return -1 ; // number of student more than nu. of books 
        
        
        int st = arr[0] , end =0;
        for(int x : arr){
            if(st < x) st = x;
            end += x;
        }
        // st = max(arr)
        // end = sum(arr)
        
        int ans = -1;
        while(st <= end){  // tc : log(sum(arr) - max(arr)))`
            int mid = st + (end - st) / 2;
            
            if(isValid(mid, k, arr) == true){ // tc : O(n) : isValid ka TC
                ans = mid;
                end =mid - 1;
            }
            else{
                st = mid + 1;
            }
        }
        
        return ans;
    }
    
    private static boolean isValid(int take, int k, int []arr){
        // take = kitne pages ka le max
        int st = 1; // student count
        int page = 0; // page count
        for(int x : arr){
            page += x;
            if(page > take){
                st++;
                page = x; // next student ko ab denge pages
            }
            
            if(st > k){
                return false; // assign studnet se jada ki need hai
            }
        }
        return true;
    }
}