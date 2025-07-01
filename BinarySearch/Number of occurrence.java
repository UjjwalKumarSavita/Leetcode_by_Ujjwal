// https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1

// tc : O(log n)
// sc : O(log n)
class Solution {
    int countFreq(int[] arr, int target) {
       // approach 1: map bana ke freq store kara le baad me check kar le ki jiki jada freq uska occurence jada hoga
       
       // binar search se bhi ho sakta hai
       //   hint : fist occurence idx  -  last occurance idx + 1  ---> USE THIS FORMULA
        
        int firstIdx = bs_first(arr, target);
        int lastIdx = bs_last(arr, target);
        
        if(firstIdx == -1 && lastIdx == -1) return 0;
        
        return lastIdx - firstIdx + 1;
        
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
