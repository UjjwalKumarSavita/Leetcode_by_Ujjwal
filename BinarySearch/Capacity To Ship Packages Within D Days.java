// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

// | Time Complexity  | **O(n × log(sum))** |
// | Space Complexity | **O(1)**            |

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // Arrays.sort(weights);
        int st = 0;
        int end = 0;// sum hoga sare weights because id day = 1then so sum(arr)

        for(int x : weights){
            st =Math.max(st,x);
            end += x;
        }

        int ans = end;
        while(st <= end){
            int mid = st + (end - st) / 2; // here mid is weight..

            if(isPossible(mid, weights, days)){
                // mid == itna weight ke kya hum sare weights ko itne ddays me shipped kar payengee
                ans = mid;
                System.out.println(ans);

                end = mid - 1;
                //for min vlaue;
            }
            else{
                st = mid + 1; // weigth ko increase karo
            }
        }

        return ans;
    }
    private boolean isPossible(int weight, int [] weights, int days){
        int wt = 0;
        int dayNeed = 1;
        for(int x : weights){

            if(wt + x > weight){
                wt = x;
                dayNeed++;
            }
            else {
                wt += x;
            }

            if(dayNeed > days) return false;
        }

        return true;
    }
}