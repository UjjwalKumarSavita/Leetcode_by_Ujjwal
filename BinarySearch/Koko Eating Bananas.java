// https://leetcode.com/problems/koko-eating-bananas/description/

// | Time Complexity  | **O(n × log(maxPile))** |
// | Space Complexity | **O(1)**                |


class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int st = 1;
        int end = 0;
        for(int x : piles){
            end = Math.max(end, x);
        }

        int ans = end; // jada to khaa hi lega kaam dekhoooooo (MIN WE NEED TO FIND...)
        while(st <= end){
            int mid = st + (end - st) / 2;
            // jo ye mid hoga vahi hamra speed hoga 1 hr me bana khane kii

            if(eat(mid, piles, h) == true){
                // mid ki speed se piles ke sare banana h hr ke andar khaa payegaaa
                ans = mid;
                end = mid - 1; 
            }
            else{ 
                st = mid + 1;
            }
        }
        return ans;
    }
    private boolean eat(int speed, int[] piles, int h){
        int hr = 0;
        for(int x : piles){
            hr += (x / speed);
            
            if(x % speed != 0){
                // eak hr ki or need hogiiiiii
                hr++;
            }
            if(hr > h) return false;
        }
        return true;
    }
}