package binaryTree.claude35Haiku.white;

import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;
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
    void testBuildTree_BasicScenario() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(root);
        assertEquals(3, root.val);
        assertEquals(9, root.left.val);
        assertEquals(20, root.right.val);
        assertEquals(15, root.right.left.val);
        assertEquals(7, root.right.right.val);
    }

    @Test
    void testBuildTree_EmptyArrays() {
        int[] preorder = {};
        int[] inorder = {};
        
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNull(root);
    }

    @Test
    void testBuildTree_SingleNode() {
        int[] preorder = {1};
        int[] inorder = {1};
        
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(root);
        assertEquals(1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    void testBuildTree_LeftSkewedTree() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {4, 3, 2, 1};
        
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(root);
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.left.left.val);
        assertEquals(4, root.left.left.left.val);
    }

    @Test
    void testBuildTree_RightSkewedTree() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {1, 2, 3, 4};
        
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(root);
        assertEquals(1, root.val);
        assertEquals(2, root.right.val);
        assertEquals(3, root.right.right.val);
        assertEquals(4, root.right.right.right.val);
    }

    @Test
    void testBuildTree_ComplexTree() {
        int[] preorder = {4, 2, 1, 3, 6, 5, 7};
        int[] inorder = {1, 2, 3, 4, 5, 6, 7};
        
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(root);
        assertEquals(4, root.val);
        assertEquals(2, root.left.val);
        assertEquals(6, root.right.val);
        assertEquals(1, root.left.left.val);
        assertEquals(3, root.left.right.val);
        assertEquals(5, root.right.left.val);
        assertEquals(7, root.right.right.val);
    }

    @Test
    void testBuildTree_NullArrays() {
        assertThrows(NullPointerException.class, () -> {
            binaryTree.buildTree(null, null);
        });
    }
}