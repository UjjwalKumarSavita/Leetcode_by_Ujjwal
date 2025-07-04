// https://www.geeksforgeeks.org/problems/search-in-a-matrix17201720/1

// row as well as column sorted : Binary Seach
// tc : O(m +n)
// sc : O(1)

class Solution {
    public static boolean matSearch(int mat[][], int x) {
        int  i = 0;
        int j = mat[0].length - 1;
        
        int row = mat.length;
        int col = mat[0].length;
        
        while( (i >= 0 && i < row) && (j >=0 && j < col) ){
            
            if(mat[i][j] == x) return true;
            
            else if(mat[i][j] < x) i++;
            else if(mat[i][j] > x) j--;
        }
        return false;
    }
}