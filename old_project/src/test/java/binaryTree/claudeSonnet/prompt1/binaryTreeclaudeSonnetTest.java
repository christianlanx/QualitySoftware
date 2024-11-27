package binaryTree.claudeSonnet.prompt1;


import org.junit.Test;

import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;

import org.junit.Before;
import static org.junit.Assert.*;

public class binaryTreeclaudeSonnetTest {
    private BinaryTree solution;
    
    @Before
    public void setUp() {
        solution = new BinaryTree();
    }
    
    // Helper method to convert binary tree to array representation
    private Integer[] treeToArray(TreeNode root) {
        if (root == null) return new Integer[0];
        
        // Calculate the height of the tree
        int height = getHeight(root);
        int size = (1 << height) - 1;
        
        Integer[] result = new Integer[size];
        convertTreeToArray(root, result, 0);
        return result;
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
    
    private void convertTreeToArray(TreeNode node, Integer[] arr, int index) {
        if (node == null || index >= arr.length) return;
        
        arr[index] = node.val;
        if (2 * index + 1 < arr.length) {
            convertTreeToArray(node.left, arr, 2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            convertTreeToArray(node.right, arr, 2 * index + 2);
        }
    }
    
    // Helper method to compare trees
    private boolean areTreesEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        
        return t1.val == t2.val && 
               areTreesEqual(t1.left, t2.right) && 
               areTreesEqual(t1.right, t2.right);
    }
    
    @Test
    public void testExample1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        
        TreeNode result = solution.buildTree(preorder, inorder);
        
        assertNotNull("Tree should not be null", result);
        assertEquals("Root value should be 3", 3, result.val);
        assertEquals("Left child should be 9", 9, result.left.val);
        assertEquals("Right child should be 20", 20, result.right.val);
        assertEquals("Right's left child should be 15", 15, result.right.left.val);
        assertEquals("Right's right child should be 7", 7, result.right.right.val);
    }
    
    @Test
    public void testExample2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        
        TreeNode result = solution.buildTree(preorder, inorder);
        
        assertNotNull("Tree should not be null", result);
        assertEquals("Root value should be -1", -1, result.val);
        assertNull("Left child should be null", result.left);
        assertNull("Right child should be null", result.right);
    }
    
    @Test
    public void testEmptyArrays() {
        int[] preorder = {};
        int[] inorder = {};
        
        TreeNode result = solution.buildTree(preorder, inorder);
        
        assertNull("Tree should be null for empty arrays", result);
    }
    
    @Test
    public void testLeftSkewedTree() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {4, 3, 2, 1};
        
        TreeNode result = solution.buildTree(preorder, inorder);
        
        assertNotNull("Tree should not be null", result);
        assertEquals("Root value should be 1", 1, result.val);
        assertEquals("Left child should be 2", 2, result.left.val);
        assertEquals("Left's left child should be 3", 3, result.left.left.val);
        assertEquals("Left's left's left child should be 4", 4, result.left.left.left.val);
    }
    
    @Test
    public void testRightSkewedTree() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {1, 2, 3, 4};
        
        TreeNode result = solution.buildTree(preorder, inorder);
        
        assertNotNull("Tree should not be null", result);
        assertEquals("Root value should be 1", 1, result.val);
        assertEquals("Right child should be 2", 2, result.right.val);
        assertEquals("Right's right child should be 3", 3, result.right.right.val);
        assertEquals("Right's right's right child should be 4", 4, result.right.right.right.val);
    }
    
    @Test
    public void testCompleteTree() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        
        TreeNode result = solution.buildTree(preorder, inorder);
        
        assertNotNull("Tree should not be null", result);
        assertEquals("Root value should be 1", 1, result.val);
        assertEquals("Left child should be 2", 2, result.left.val);
        assertEquals("Right child should be 3", 3, result.right.val);
        assertEquals("Left's left child should be 4", 4, result.left.left.val);
        assertEquals("Left's right child should be 5", 5, result.left.right.val);
        assertEquals("Right's left child should be 6", 6, result.right.left.val);
        assertEquals("Right's right child should be 7", 7, result.right.right.val);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDifferentLengthArrays() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {1, 2};
        
        solution.buildTree(preorder, inorder);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTraversals() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {1, 3, 4};  // Contains 4 which is not in preorder
        
        solution.buildTree(preorder, inorder);
    }
}