/*    Date:-13-09-23
Problem Link:-https://practice.geeksforgeeks.org/problems/largest-number-possible5028/1
Problem name:- "Largest number possible"    */

//Solution:------------------------------------------------------------
class Solution{
    // Function to find the largest N-digit number with a given sum S.
    // N: The number of digits.
    // S: The required sum of digits.
    static String findLargest(int N, int S){
        // If S is 0 and N is greater than 1, there is no valid solution, return "-1".
        if (S == 0 && N > 1) {
            return "-1";
        }
        
        StringBuilder ans = new StringBuilder(); // Initialize a StringBuilder to store the result.
        
        for (int i = 0; i < N; i++) {
            if (S >= 9) {
                // If S is greater than or equal to 9, append 9 to the result and subtract 9 from S.
                ans.append(9);
                S -= 9;
            } else if (S == 0) {
                // If S is 0, append 0 to the result.
                ans.append(0);
            } else {
                // Otherwise, append the minimum of S and 9 to the result and set S to 0.
                ans.append(Math.min(S, 9));
                S = 0;
            }
        }
        
        // If there is still some remaining value in S, it means there is no valid solution, return "-1".
        if (S > 0) {
            return "-1";
        }
        
        // Convert the StringBuilder to a string and return the result.
        return ans.toString();
    }
}

