/*    Date:-06-09-23
Problem Link:-https://practice.geeksforgeeks.org/problems/mother-vertex/1
Problem name:- "Mother Vertex"    */

//Solution:-------------------------------------------------------------

class Solution {
    // This function finds the mother vertex in a given directed graph.
    // It takes the number of vertices (V) and the adjacency list representation of the graph (adj) as input.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        // Initialize an array to keep track of visited vertices.
        boolean[] vis = new boolean[V];
        
        // Initialize a variable to store the potential mother vertex (mV) as -1.
        int mV = -1;
        
        // Perform a Depth-First Search (DFS) on each unvisited vertex in the graph.
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis);
                
                // Update the potential mother vertex to the last visited vertex in this DFS traversal.
                mV = i;
            }
        }
        
        // Reset the visited array for the second DFS traversal.
        Arrays.fill(vis, false);
        
        // Perform another DFS traversal starting from the potential mother vertex.
        dfs(adj, mV, vis);
        
        // Check if all vertices are visited in the second traversal.
        for (boolean val : vis) {
            if (!val) return -1; // If not all vertices are visited, there is no mother vertex.
        }
        
        // Return the potential mother vertex found.
        return mV;
    }
    
    // Depth-First Search (DFS) function to visit and mark vertices as visited.
    public void dfs(ArrayList<ArrayList<Integer>> adj, int v, boolean[] vis) {
        vis[v] = true; // Mark the current vertex as visited.
        
        // Visit all adjacent vertices of the current vertex in the adjacency list.
        for (int it : adj.get(v)) {
            if (!vis[it]) {
                dfs(adj, it, vis); // Recursively visit unvisited adjacent vertices.
            }
        }
    }
}

