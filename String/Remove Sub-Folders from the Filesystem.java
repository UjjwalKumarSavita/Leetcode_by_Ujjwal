// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/
// tc : O(NlogN) + O(N * L) // for sorting + for loop and startsWtih ke check ke liye
// sc : O(N )

import java.util.*;
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();

        Arrays.sort(folder);

        String prev = "";

        for(String path : folder){
            if(prev.isEmpty() || !path.startsWith(prev + "/")){
                ans.add(path);
                prev = path;
            }
        }
        return ans;
    }
}