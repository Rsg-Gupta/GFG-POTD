/*    Date:-10-09-23
Problem Link:-https://practice.geeksforgeeks.org/problems/insert-a-node-in-a-bst/1
Problem name:- "Insert a node in a BST"    */

//Solution:------------------------------------------------------------
class Solution
{
    int t = 1; // Initialize a counter 't' to keep track of the current node's position.
    int ans = 0; // Initialize a variable 'ans' to store the Kth largest element.

    // Function to return the Kth largest element in the given BST rooted at 'root'.
    public int kthLargest(Node root, int k)
    {
        // Call the helper function KLargest to find the Kth largest element.
        KLargest(root, k);
        
        // Return the result stored in 'ans'.
        return ans;
    }

    // Helper function to find the Kth largest element using reverse inorder traversal.
    public void KLargest(Node root, int k)
    {
        // Base case: If the current node is null or we have already found the Kth largest element, return.
        if (root == null || t >= k)
            return;

        // Recursively visit the right subtree first.
        KLargest(root.right, k);

        // If Kth largest element is found, store it in 'ans' and return.
        if (k == t) {
            ans = root.data;
            return;
        }

        // Increment the counter 't' as we visit nodes.
        t++;

        // Recursively visit the left subtree.
        KLargest(root.left, k);
    }
}
