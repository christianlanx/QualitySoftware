package binaryTree.claude35Haiku.white;
import binaryTree.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree binaryTree = new BinaryTree();

    @Test
    void testBuildTree_NormalCase() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(root);
        assertEquals(3, root.val);
        
        // Validate left subtree
        assertNotNull(root.left);
        assertEquals(9, root.left.val);
        assertNull(root.left.left);
        assertNull(root.left.right);
        
        // Validate right subtree
        assertNotNull(root.right);
        assertEquals(20, root.right.val);
        
        // Validate right subtree children
        assertNotNull(root.right.left);
        assertEquals(15, root.right.left.val);
        assertNotNull(root.right.right);
        assertEquals(7, root.right.right.val);
    }

    @Test
    void testBuildTree_EmptyArrays() {
        int[] preorder = {};
        int[] inorder = {};
        
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNull(root);
    }

    @Test
    void testBuildTree_SingleNode() {
        int[] preorder = {1};
        int[] inorder = {1};
        
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(root);
        assertEquals(1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    void testBuildTree_LeftSkewedTree() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {4, 3, 2, 1};
        
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(root);
        assertEquals(1, root.val);
        
        // Validate left-skewed tree structure
        assertNotNull(root.left);
        assertEquals(2, root.left.val);
        
        assertNotNull(root.left.left);
        assertEquals(3, root.left.left.val);
        
        assertNotNull(root.left.left.left);
        assertEquals(4, root.left.left.left.val);
    }

    @Test
    void testBuildTree_RightSkewedTree() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {1, 2, 3, 4};
        
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(root);
        assertEquals(1, root.val);
        
        // Validate right-skewed tree structure
        assertNotNull(root.right);
        assertEquals(2, root.right.val);
        
        assertNotNull(root.right.right);
        assertEquals(3, root.right.right.val);
        
        assertNotNull(root.right.right.right);
        assertEquals(4, root.right.right.right.val);
    }

    @Test
    void testBuildTree_ComplexTree() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(root);
        assertEquals(1, root.val);
        
        // Validate left subtree
        assertNotNull(root.left);
        assertEquals(2, root.left.val);
        
        assertNotNull(root.left.left);
        assertEquals(4, root.left.left.val);
        
        assertNotNull(root.left.right);
        assertEquals(5, root.left.right.val);
        
        // Validate right subtree
        assertNotNull(root.right);
        assertEquals(3, root.right.val);
        
        assertNotNull(root.right.left);
        assertEquals(6, root.right.left.val);
        
        assertNotNull(root.right.right);
        assertEquals(7, root.right.right.val);
    }
}