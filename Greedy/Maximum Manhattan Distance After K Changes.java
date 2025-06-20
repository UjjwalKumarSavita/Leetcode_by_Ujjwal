class Solution {
    public int maxDistance(String st, int k) {
        
        int n = 0;
        int s = 0;
        int e = 0;
        int w = 0;

        int maxDis = 0;
        int size = st.length();
        for(int i = 0 ; i < size; i++ ){
            char ch = st.charAt(i);
            if(ch == 'N') n++;
            if(ch == 'S') s++;
            if(ch == 'E') e++;
            if(ch == 'W') w++;

            
            int dis = Math.abs(n - s) + Math.abs(w - e);
            int steps = i + 1;

            int wasteSteps = steps - dis;

            int tryToImprove = 0;
            if(wasteSteps != 0){
                tryToImprove = Math.min(2 * k, wasteSteps);
            }

            maxDis = Math.max(maxDis, dis + tryToImprove);
        }

        return maxDis;
    }
}