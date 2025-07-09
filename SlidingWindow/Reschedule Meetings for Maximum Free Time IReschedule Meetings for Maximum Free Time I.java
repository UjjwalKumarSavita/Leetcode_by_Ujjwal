// https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i/description/


// tc : O(n)
// sc:O(n)
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        //gap count kar lo sabse pahel
        int n = startTime.length;
        int gap[]= new int [n + 1];

        gap[0] = startTime[0];
        for(int i = 1; i < n ;i++){
            gap[i] = startTime[i] - endTime[i - 1];
        }

        gap[n] = eventTime - endTime[n - 1];

        int max = 0;
        int j =0;
        int i = 0;
        int sum = 0;
        while(j < n+ 1){
            sum += gap[j];

            // shirink the window  id window size greater than k + 1
            while(j - i + 1 > k + 1){
                sum -= gap[i];
                i++;
            }

            max = Math.max(max, sum);
            j++;
        }

        return max;
    }
}