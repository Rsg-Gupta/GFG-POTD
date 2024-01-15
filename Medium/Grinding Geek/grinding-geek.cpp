//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
    public:
    int max_courses(int n, int total, vector<int> &cost)
    {
        //Code Here
        
        vector<vector<int>> dp(n + 1, vector<int> (total + 1));
        
        for(int i = n - 1; i >= 0; i--) 
        {
            for(int j = 0; j <= total; j++) 
            {
                int notPick = dp[i + 1][j];
                int pick = 0;
                
                if(cost[i] <= j)
                    pick = 1 + dp[i + 1][j - cost[i] + (0.9 * cost[i])];
                
                dp[i][j] = max(pick, notPick);
            }
        }
        
        return dp[0][total];
    }
};


//{ Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        int k;
        cin>>k;
        vector<int> arr(n);
        for(int i=0;i<n;i++) cin>>arr[i];
        Solution ob;
        cout<<ob.max_courses(n,k,arr)<<endl;
    }
}
// } Driver Code Ends