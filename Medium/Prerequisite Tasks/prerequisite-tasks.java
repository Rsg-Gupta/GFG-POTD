//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int numCourses,int P, int[][] prerequisites)
    {
        // Your Code goes here
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());

        for(int edge[]:prerequisites)
           adj.get(edge[1]).add(edge[0]);

        boolean ans=false;
        boolean visited[] = new boolean[numCourses];
        boolean recStack[] = new boolean[numCourses];  

        for(int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                ans = DFS(adj, i, visited, recStack);
                if (ans)
                    return false;
            }   
        }
        return true; 
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