/*    Date:-12-09-23
Problem Link:-https://practice.geeksforgeeks.org/problems/perfect-numbers3207/1
Problem name:- "Perfect Numbers"    */

//Solution:------------------------------------------------------------
class Solution {
    static int isPerfectNumber(long N) {
        // Check if N is 1 (1 is not a perfect number)
        if (N == 1) {
            return 0;
        }

        long sum = 0; // Initialize a variable to store the sum of proper divisors
        
        // Iterate through numbers from 2 to the square root of N
        for (long i = 2; i <= Math.sqrt(N); i++) {
            // If i is a divisor of N, add both i and N/i to the sum of divisors
            if (N % i == 0) {
                sum += i + N / i;
            }
        }
        
        // If the sum of divisors (excluding N itself) is equal to N, it's a perfect number
        if (sum + 1 == N) {
            return 1; // Return 1 to indicate that N is a perfect number
        } else {
            return 0; // Return 0 to indicate that N is not a perfect number
        }
    }
}

