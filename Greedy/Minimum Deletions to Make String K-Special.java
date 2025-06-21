class Solution {
    public int minimumDeletions(String word, int k) {
        //STEP 1. FREQ FIND OF CHARACTERS IN THE STRING
        int freq[] = new int[26];
        int n = word.length();
        for(char ch : word.toCharArray()){
            freq[ch- 'a']++;
        }

        int res = n;
        // Arrays.sort(freq);
        for(int i = 0; i < 26 ; i++){
            int del = 0;
            for(int j = 0 ;j < 26;j++){
                if(i == j) continue;

                // agar freq[j] small hoga freq[i] se to freq[j] ko pura delete
                if(freq[j] < freq[i]){
                    del += freq[j];
                }

                // (freq[i] - freq[j] > k) to hum ko sub ko kam karna hoga
                else if(Math.abs(freq[j] - freq[i]) > k){
                    del += Math.abs(freq[j] - freq[i] - k);
                }
            }
            res = Math.min(res, del);
        }


        return res;
    }
}