// | Category  | Complexity     |
// | --------- | -------------- |
// | **Time**  | `O(n * log D)` |
// | **Space** | `O(1)`         |

// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        // here sare flower ko blow karna hai to max day jo hoga vhai end hoga
        int end = 0;
        for(int x : bloomDay){
            end = Math.max(x, end);
        }
        

        int st = 0;
        int ans = -1;
        while(st <=  end){
            int mid = st + (end - st) / 2;
                System.out.println(mid);

            if(isPossible(mid, bloomDay, m, k) == true){
                // min ke left jao
                end = mid - 1;
                ans = mid;
                System.out.println(ans);
            }
            else{
                st = mid + 1; // no.of day ko increase krooooo
            }
        }
        return ans;
    }

    private boolean isPossible(int day, int [] bloomDay, int m, int k){
        int  flower = 0;
        int bouquets = 0;

        for(int  i = 0 ; i < bloomDay.length; i++){
            
            if(bloomDay[i] <= day){
                flower++;
                if(flower >= k){
                    bouquets++;
                    
                    flower = 0;
                }
            }
            else{
                flower = 0;
            }

            if(bouquets >= m) return true;
        }
        return false;
    } 
}