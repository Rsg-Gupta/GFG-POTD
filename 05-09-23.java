/*    Date:-05-09-23
Problem Link:-https://practice.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1
Problem name:- "Print adjacency list
"    */

//Solution:-------------------------------------------------------------

class Solution {
    // This function constructs an adjacency list representation of a graph.
    // It takes the number of vertices (V) and an array of edges as input.
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        // Create a list to store the adjacency list for each vertex.
        List<List<Integer>> adj_list = new ArrayList<>();
        
        // Initialize the adjacency list for each vertex with an empty list.
        for (int i = 0; i < V; i++) {
            adj_list.add(new ArrayList<Integer>());
        }
        
        // Iterate through the given edges and add each edge to the adjacency list.
        for (int[] a : edges) {
            // Since it's an undirected graph, we add both a[0] to a[1] and a[1] to a[0].
            adj_list.get(a[0]).add(a[1]);
            adj_list.get(a[1]).add(a[0]);
        }
        
        // Return the adjacency list representation of the graph.
        return adj_list;
    }
}
