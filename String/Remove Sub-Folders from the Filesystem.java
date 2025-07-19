// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/

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