// | Time Complexity  | O(log₁₀x) or O(1) |
// | Space Complexity | O(1)              |
class Solution {
    public int reverse(int x) {
        if(x>Integer.MAX_VALUE || x < Integer.MIN_VALUE)
            return 0;
        int rem,ans=0,n=x;
        if(n<0)
        n=-1*n;
        while(n>0){
            rem =n%10;
            if((ans > Integer.MAX_VALUE / 10) || ( ans == Integer.MAX_VALUE && rem > 7)) return 0;
            if((ans < Integer.MIN_VALUE / 10) || (ans == Integer.MIN_VALUE && rem < -8)) return 0;
            ans = ans*10 + rem;
            n/=10;
        }
        if (x<0)
        return -1*ans;
        return ans;
    }
}
