//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean ans=false;
        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];
        for(int i = 0; i < V; i++) {
            if (!visited[i]) {
                ans = DFS(adj, i, visited, recStack);
                if (ans)
                    return true;
            }   
        }
        return false;
    }    
        
    public boolean DFS(ArrayList<ArrayList<Integer>> adj, int s, boolean visited[], boolean recStack[]) {
        visited[s] = true;
        recStack[s] = true;
        for (int u : adj.get(s)) {
            if (!visited[u]) {
                if (DFS(adj, u, visited, recStack))
                    return true;
            } else if (recStack[u]==true) {
                return true;
            }
        }
        recStack[s] = false;
        return false;
    }
}
