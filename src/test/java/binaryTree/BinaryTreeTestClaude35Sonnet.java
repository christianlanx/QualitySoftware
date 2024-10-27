package binaryTree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTestClaude35Sonnet {
    private BinaryTree binaryTree;

    @Before
    public void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    public void testEmptyArrays() {
        int[] preorder = {};
        int[] inorder = {};
        assertNull(binaryTree.buildTree(preorder, inorder));
    }

    @Test
    public void testSingleNode() {
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertEquals(1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    public void testBalancedTree() {
        int[] preorder = {2, 1, 3};
        int[] inorder = {1, 2, 3};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertEquals(2, root.val);
        assertNotNull(root.left);
        assertNotNull(root.right);
        assertEquals(1, root.left.val);
        assertEquals(3, root.right.val);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }

    @Test
    public void testLeftSkewedTree() {
        int[] preorder = {3, 2, 1};
        int[] inorder = {1, 2, 3};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertEquals(3, root.val);
        assertNotNull(root.left);
        assertNull(root.right);
        assertEquals(2, root.left.val);
        assertNotNull(root.left.left);
        assertEquals(1, root.left.left.val);
    }

    @Test
    public void testRightSkewedTree() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {1, 2, 3};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertEquals(1, root.val);
        assertNull(root.left);
        assertNotNull(root.right);
        assertEquals(2, root.right.val);
        assertNull(root.right.left);
        assertNotNull(root.right.right);
        assertEquals(3, root.right.right.val);
    }

    @Test
    public void testComplexTree() {
        int[] preorder = {4, 2, 1, 3, 6, 5, 7};
        int[] inorder = {1, 2, 3, 4, 5, 6, 7};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        // Verify root
        assertEquals(4, root.val);
        
        // Verify left subtree
        assertEquals(2, root.left.val);
        assertEquals(1, root.left.left.val);
        assertEquals(3, root.left.right.val);
        
        // Verify right subtree
        assertEquals(6, root.right.val);
        assertEquals(5, root.right.left.val);
        assertEquals(7, root.right.right.val);
    }

    @Test
    public void testTreeNodeConstructors() {
        // Test empty constructor
        BinaryTree.TreeNode node1 = new BinaryTree.TreeNode();
        assertEquals(0, node1.val);
        assertNull(node1.left);
        assertNull(node1.right);
        
        // Test value-only constructor
        BinaryTree.TreeNode node2 = new BinaryTree.TreeNode(5);
        assertEquals(5, node2.val);
        assertNull(node2.left);
        assertNull(node2.right);
        
        // Test full constructor
        BinaryTree.TreeNode left = new BinaryTree.TreeNode(1);
        BinaryTree.TreeNode right = new BinaryTree.TreeNode(3);
        BinaryTree.TreeNode node3 = new BinaryTree.TreeNode(2, left, right);
        assertEquals(2, node3.val);
        assertEquals(1, node3.left.val);
        assertEquals(3, node3.right.val);
    }

    // @Test
    // public void testMinimumValue() {
    //     int[] preorder = {Integer.MIN_VALUE + 1, Integer.MIN_VALUE};
    //     int[] inorder = {Integer.MIN_VALUE, Integer.MIN_VALUE + 1};
    //     BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        
    //     assertEquals(Integer.MIN_VALUE + 1, root.val);
    //     assertNotNull(root.left);
    //     assertEquals(Integer.MIN_VALUE, root.left.val);
    // }

    @Test
    public void testMaximumValue() {
        int[] preorder = {Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
        int[] inorder = {Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertEquals(Integer.MAX_VALUE - 1, root.val);
        assertNotNull(root.right);
        assertEquals(Integer.MAX_VALUE, root.right.val);
    }
}