// https://www.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1

// | **Time Complexity**  | `O(k × n²)` (in practice, due to pruning) |
// | **Space Complexity** | `O(n + k)`                                |


class Solution {
    
    String res;
    
    public String findMaximumNum(String s, int k) {
        // StringBuilder st = new StringBuilder(s)
        char arr [] = s.toCharArray();
        
         res = new String(s);
        
        solve(arr, k, 0);  // idx : 0
        // s = new String(arr);
        return res;
    }
    
    private void solve(char []arr, int k, int idx){
        if(k == 0 || idx == arr.length) return ;
        
        
        //to find the max Character to swap with idx char
        char maxChar = arr[idx] ;
        for(int i = idx + 1 ; i < arr.length; i++){
            if(maxChar < arr[i]){
                maxChar = arr[i];
            }
        }
        
        if(maxChar != arr[idx]) k--;
        //agar equal hoga to k -- nahikareteeee
        
        for(int i = idx; i < arr.length; i++){
            if(maxChar == arr[i]){
                swap(idx, i, arr);
                
                String curr = new String(arr);
                if(curr.compareTo(res) > 0){
                    res = curr ; // curr max to nahi ho gayi check karete jao 
                }
                
                solve(arr, k , idx + 1); // explore
                
                swap(idx, i, arr); //back track
            }
        }
        
    }
    
    public void swap(int x, int y, char[]arr){
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    
}