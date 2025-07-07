// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/

// tc : O(n * logn) + O(day log n) // sorting  + heap for all day 
// sc: O(n)

class Solution {
    public int maxEvents(int[][] events) {
        // step 1
        Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));

        // step 2
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int day = events[0][0];
        // 1 se kyu hi start karna skip some day if event starts such (5.7), (15,22)
        
        int count = 0;
        int idx = 0;
        int n = events.length;
        while(idx < n || !pq.isEmpty()){

            //some optimize 
            if(pq.isEmpty()){
                day = events[idx][0];
            }

            // try to pick all events who start day is equal to day
            while(idx < n && events[idx][0] == day){
                
                // priority me end dalenge
                pq.add(events[idx][1]);
                // count++;/
                idx++;
            }

            //remove that event from the pq which was yo attedned
            if(!pq.isEmpty()){
                pq.poll();
                count++;
            }

            day++;
            // skips those day whose end is less the day
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
        }
        return count;
    }
}