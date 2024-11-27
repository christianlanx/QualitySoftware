package binaryTree.claude35Sonnet.white;
import binaryTree.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    
    private BinaryTree binaryTree;
    
    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
    }
    
    @Test
    void testBuildTreeWithEmptyArrays() {
        int[] preorder = {};
        int[] inorder = {};
        
        BinaryTree.TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertNull(result);
    }
    
    @Test
    void testBuildTreeWithSingleNode() {
        int[] preorder = {1};
        int[] inorder = {1};
        
        BinaryTree.TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(result);
        assertEquals(1, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }
    
    @Test
    void testBuildTreeWithLeftChild() {
        int[] preorder = {2, 1};
        int[] inorder = {1, 2};
        
        BinaryTree.TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(result);
        assertEquals(2, result.val);
        assertNotNull(result.left);
        assertEquals(1, result.left.val);
        assertNull(result.right);
    }
    
    @Test
    void testBuildTreeWithRightChild() {
        int[] preorder = {1, 2};
        int[] inorder = {1, 2};
        
        BinaryTree.TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(result);
        assertEquals(1, result.val);
        assertNull(result.left);
        assertNotNull(result.right);
        assertEquals(2, result.right.val);
    }
    
    @Test
    void testBuildTreeWithCompleteTree() {
        int[] preorder = {3, 2, 1, 4};
        int[] inorder = {1, 2, 3, 4};
        
        BinaryTree.TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(result);
        assertEquals(3, result.val);
        assertNotNull(result.left);
        assertEquals(2, result.left.val);
        assertNotNull(result.right);
        assertEquals(4, result.right.val);
        assertNotNull(result.left.left);
        assertEquals(1, result.left.left.val);
    }
    
    @Test
    void testTreeNodeConstructors() {
        // Test empty constructor
        BinaryTree.TreeNode node1 = new BinaryTree.TreeNode();
        assertEquals(0, node1.val);
        assertNull(node1.left);
        assertNull(node1.right);
        
        // Test constructor with value
        BinaryTree.TreeNode node2 = new BinaryTree.TreeNode(5);
        assertEquals(5, node2.val);
        assertNull(node2.left);
        assertNull(node2.right);
        
        // Test constructor with value and children
        BinaryTree.TreeNode left = new BinaryTree.TreeNode(3);
        BinaryTree.TreeNode right = new BinaryTree.TreeNode(7);
        BinaryTree.TreeNode node3 = new BinaryTree.TreeNode(5, left, right);
        assertEquals(5, node3.val);
        assertNotNull(node3.left);
        assertEquals(3, node3.left.val);
        assertNotNull(node3.right);
        assertEquals(7, node3.right.val);
    }
}