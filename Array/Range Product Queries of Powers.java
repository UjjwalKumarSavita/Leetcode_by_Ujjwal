// https://leetcode.com/problems/range-product-queries-of-powers/description/
// tc : O(n) : where n = queries length
// sc : O(1) :: beacause we need to create power array .. 

import java.util.*;
class Solution {
    public int[] productQueries(int n, int[][] queries) {
        // ya to hum stringbuilder bana ke binary me n ko convert kar se bhi set bit ko check kar sakete hai power banane ke liye..
        //BUT WE USE List to do so

        List<Long> power = new ArrayList<>();
        for(int i = 0 ;i <= 31 ; i++){
            if((n & (1 << i)) != 0) power.add((long)(1 << i));
        }

        int result[] =  new int[queries.length];
        int idx = 0;
        for(int x [] : queries){
            int st = x[0];
            int end = x[1];

            long temp = 1;
            for(int i = st ; i <= end ; i++){
                temp = (1L * temp * power.get(i)) % 1000000007;
            }
            result[idx++] = (int)(temp);
        }
        return result;
    }
}