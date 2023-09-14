/*    Date:-11-09-23
Problem Link:-https://practice.geeksforgeeks.org/problems/lucky-numbers2911/1
Problem name:- "Lucky Number"    */

//Solution:------------------------------------------------------------

// A Java program to check if a number is a lucky number.

class Solution
{
    // Function to check if the given number is a lucky number.
    // n: Input number to be checked.
    // Returns true if the number is lucky, false otherwise.
    public static boolean isLucky(int n)
    {
        // Start the check from the first step of the lucky number process.
        return check(n, 2);
    }
    
    // Recursive helper function to perform the lucky number check.
    // n: The current number to be checked.
    // count: The current step of the lucky number process.
    // Returns true if the number is lucky, false otherwise.
    public static boolean check(int n, int count)
    {
        // If the number is divisible by the current step, it's not a lucky number.
        if (n % count == 0)
            return false;
        
        // If we have completed all the steps and the number is not divisible, it's a lucky number.
        if (count > n)
            return true;
        
        // Calculate the next step in the lucky number process and recursively check.
        n = n - (n / count);
        return check(n, ++count);
    }
}

