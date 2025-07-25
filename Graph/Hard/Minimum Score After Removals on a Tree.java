// https://leetcode.com/problems/minimum-score-after-removals-on-a-tree/description/

// tc :: O(n^2)
// SC :: O(N)
import java.util.*;
class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;

        // adj list banayengee --> TC : O(N)
        Map<Integer, List<Integer> > adj = new HashMap<>(); 
        for(int i = 0 ; i < n ;i++ ) adj.put(i, new ArrayList<>());
        for(int [] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int subtreeXor[] = new int[n];
        int inTime[] = new int[n];
        int outTime[] = new int[n];
        int timer[] =  new int[1];

        dfs(0, -1, adj, nums, subtreeXor, inTime, outTime, timer); // TC :: O(E + V) ~~ O(N)
        
        // Now result calculate karenge
        int result = Integer.MAX_VALUE;
        for(int u = 1; u < n ; u++){ // TC :: O(N ^ 2)
            for(int v = u + 1 ;v < n ;v++){
                int xor1, xor2, xor3;

                if(isAncestor(u , v, inTime, outTime)){
                    xor1 = subtreeXor[v]; // child kar xor
                    xor2 = subtreeXor[u] ^ xor1;
                    xor3 = subtreeXor[0] ^ xor1 ^ xor2;
                }
                else if(isAncestor(v, u, inTime, outTime)){
                    xor1 = subtreeXor[u]; // child kar xor
                    xor2 = subtreeXor[v] ^ xor1;
                    xor3 = subtreeXor[0] ^ xor1 ^ xor2;
                }
                else{
                    // dono u and v same subtree  me na ho
                    xor1 = subtreeXor[u];
                    xor2 = subtreeXor[v];
                    xor3 = subtreeXor[0] ^ xor1 ^ xor2;
                }

                int max = Math.max(xor1, Math.max(xor2, xor3));
                int min = Math.min(xor1, Math.min(xor2, xor3));

                int score = max - min;
                result = Math.min(score, result);
            }
        }
        return result;
    }

    private void dfs(int node, int parent, Map<Integer, List<Integer>> adj, int nums[],int subtreeXor[], int inTime[], int outTime[], int timer[]){
        subtreeXor[node] = nums[node];
        inTime[node] = timer[0]++;

        //dfs ka loop
        for(int ngbr : adj.get(node)){
            if(ngbr != parent){
                dfs(ngbr, node, adj,nums, subtreeXor, inTime, outTime, timer);
                subtreeXor[node] ^= subtreeXor[ngbr]; 
            }
        }

        outTime[node] = timer[0]++;
    }

    private boolean isAncestor(int u, int v, int inTime[], int outTime[]){
        return inTime[v] >= inTime[u] && outTime[v] <= outTime[u];
    }
}