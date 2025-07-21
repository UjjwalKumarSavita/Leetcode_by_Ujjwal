// https://leetcode.com/problems/delete-duplicate-folders-in-system/description/

// SC = O(N × L)
// Tc = O(N × L × log L)

import java.util.AbstractMap;
import java.util.*;
class Solution {
    static class Node{
        String val;
        String subFolder ;
        Map<String ,Node> children;

        Node(String val){
            this.val = val;
            subFolder = "";
            this.children = new HashMap<>();
        }
    }
    private Node getNode(String val){
        return new Node(val);
    }


    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        // apne trie ko banane ke liye root 
        Node root = getNode("/");

        //ab sare path me ja ke trie me insert karenge
        for(List<String> path : paths){
            insert(root, path);
        }

        // populate saree subfolders ko krengee
        Map<String , Integer> subFolder = new HashMap<>();
        populatesNode(root, subFolder);

        // at the time of populte dublicates aayee hongee unko remove karenge
        // dublicate remove
        removeDuplicate(root, subFolder);

        //after deletion of the duplicate we can construct our result
        List<String> path = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        constructResult(root, path, result);


        return result;
    }

    // step 1:
    // tc := (N * L) 
    // SC :=	O(N * L)	N = total paths, L = avg length of each path
    private void insert(Node root , List<String> path){
        
        // give path se root Node ke map me vlaue dalenge
        for(String folder : path){
            root.children.putIfAbsent(folder, getNode(folder));

            root =  root.children.get(folder);
        }
    }

    // step 2 :: populate karna hai ab tooo
    // TC := O(N * L * log L)	
    // SC := O(N * L)	Sorting children nodes during recursion
    private String populatesNode(Node root, Map<String, Integer> subFolderMap){

        //folder ke subPaths jitene honge uske liye ye map me value dal le list me 
        List<Map.Entry<String, String>> subFolderPaths = new ArrayList<>();

        for(Map.Entry<String, Node> entry : root.children.entrySet()){
            String subFolderResult = populatesNode(entry.getValue(), subFolderMap);

            //subfolder path me add
            // subFolderPaths.add(new AbstractMap.SimpleEntry<>(entry.getKey(), subFolderResult));
            subFolderPaths.add(new AbstractMap.SimpleEntry<>(entry.getKey(), subFolderResult));

        }

        //sort karenge
        subFolderPaths.sort(Comparator.comparing(Map.Entry :: getKey));


        //Now sare folder se complete path banayeege
        StringBuilder complete = new StringBuilder();

        for(Map.Entry<String, String>entry : subFolderPaths){
            complete.append("(").append(entry.getKey()).append(entry.getValue()).append(")");
        }

        String completeStr = complete.toString();
        root.subFolder = completeStr;

        if(!completeStr.isEmpty() ){
            subFolderMap.put(completeStr, subFolderMap.getOrDefault(completeStr, 0) + 1);
        }

        return completeStr;
    }

    // step :: 3
    // TC == O(N * L)	
    // SC == O(H)	
    // H = height of trie (depth of folder nesting)
    private void removeDuplicate (Node root, Map<String , Integer> subFolderMap){
         Iterator<Map.Entry<String, Node>> it = root.children.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Node> entry = it.next();
            Node child = entry.getValue();

            if (!child.subFolder.isEmpty() && subFolderMap.get(child.subFolder) > 1) {
                it.remove();
            } else {
                removeDuplicate(child, subFolderMap);
            }
        }
    }

    //step 4 :: construct result from trie structure
    // tc == O(N * L)	
    // sc == O(L)	DFS traversal of trie
    private void constructResult(Node root, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, Node> entry : root.children.entrySet()) {
            path.add(entry.getKey());
            result.add(new ArrayList<>(path));
            constructResult(entry.getValue(), path, result);
            path.remove(path.size() - 1);
        }
    }

}