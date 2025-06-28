import  java.util.*;
class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adjList) {
        // code here
        
        Map<Integer, List<Integer> >  adj = new HashMap<>();
        int n = adjList.size();
        for(int u = 0; u < n;u++){
            adj.putIfAbsent(u, new ArrayList<>());
            for(int i : adjList.get(u)){
                adj.get(u).add(i);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        boolean visited[] = new boolean[n];
        bfs(adj, 0, visited, result);
        return result;
    }
    
    private void bfs(Map<Integer, List<Integer> >  adj, int u, boolean[] visited, ArrayList<Integer> result){
        Queue<Integer> que = new LinkedList<>();
        que.offer(u);
        visited[u] = true;
        result.add(u);
        
        while(!que.isEmpty()){
            int curr = que.poll();
            for(int v: adj.get(curr)){
                if(!visited[v]){
                    que.add(v);
                    visited[v] = true;
                    result.add(v);
                }
            }
        }
    }
}