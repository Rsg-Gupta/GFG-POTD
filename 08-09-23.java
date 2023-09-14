/*    Date:-08-09-23
Problem Link:-https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1
Problem name:- "Binary tree to BST"    */

//Solution:-----------------Binary tree to BST --------------------------------------------
class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}

class Solution
{
    // Function to convert a Binary Tree to a Binary Search Tree (BST).
    // The given root is the root of the Binary Tree.
    // Returns the root of the generated BST.
    Node binaryTreeToBST(Node root)
    {
      // Create an empty list to store the inorder traversal of the Binary Tree.
      ArrayList<Integer> list = new ArrayList<>();
      
      // Perform an inorder traversal of the Binary Tree to populate the list.
      inOrder(root, list);
      
      // Sort the list to obtain values in ascending order.
      Collections.sort(list);
      
      // Create a BST from the sorted list and return its root.
      return makeBST(list, 0, list.size() - 1);
    }
    
    // Function to perform an inorder traversal of the Binary Tree and populate the list.
    public void inOrder(Node root, ArrayList<Integer> list)
    {
        if (root == null) return; // Base case: If the current node is null, return.
        
        // Recursively traverse the left subtree.
        inOrder(root.left, list);
        
        // Add the value of the current node to the list.
        list.add(root.data);
        
        // Recursively traverse the right subtree.
        inOrder(root.right, list);
    }
    
    // Function to create a balanced BST from a sorted list of values.
    public Node makeBST(ArrayList<Integer> list, int start, int end)
    {
        // Base case: If the start index is greater than the end index, return null.
        if (start > end) return null;
        
        // Calculate the mid index of the current subarray.
        int mid = (start + end) / 2;
        
        // Create a new node with the value at the mid index.
        Node node = new Node(list.get(mid));
        
        // Recursively build the left and right subtrees.
        node.left = makeBST(list, start, mid - 1);
        node.right = makeBST(list, mid + 1, end);
        
        // Return the current node, which represents the root of the BST.
        return node;
    }
}
