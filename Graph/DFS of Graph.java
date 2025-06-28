import java.util.*;
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adjList) {
        // Code here
        
        //here we make the adjaency list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        int n = adjList.size();
        for(int u = 0; u < n ; u++){
            adj.putIfAbsent(u,new ArrayList<>());
            for(int i : adjList.get(u))
                adj.get(u).add(i);
        }
        
        // dfs 
        ArrayList<Integer> list = new ArrayList<>();
        boolean visited[] = new boolean[n];
        dfs(adj, 0, visited, list);
        return list;
    }
    
    private void dfs(Map<Integer, List<Integer>> adj, int u, boolean visited[], ArrayList<Integer> list){
        if(visited[u]== true) return;
        
        visited[u] = true;
        list.add(u);
        for(int v : adj.get(u)){
            if(!visited[v]) dfs(adj, v, visited, list);
        }
    }
}