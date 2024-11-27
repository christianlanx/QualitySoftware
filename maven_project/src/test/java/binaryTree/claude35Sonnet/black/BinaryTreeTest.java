package binaryTree.claude35Sonnet.black;
import binaryTree.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    void testBuildTreeExample1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        // Verify root
        assertEquals(3, result.val);
        // Verify left subtree
        assertEquals(9, result.left.val);
        assertNull(result.left.left);
        assertNull(result.left.right);
        // Verify right subtree
        assertEquals(20, result.right.val);
        assertEquals(15, result.right.left.val);
        assertEquals(7, result.right.right.val);
    }

    @Test
    void testBuildTreeExample2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertEquals(-1, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void testBuildTreeWithLeftSkewedTree() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {3, 2, 1};
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertEquals(1, result.val);
        assertEquals(2, result.left.val);
        assertEquals(3, result.left.left.val);
        assertNull(result.right);
    }

    @Test
    void testBuildTreeWithRightSkewedTree() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {1, 2, 3};
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertEquals(1, result.val);
        assertNull(result.left);
        assertEquals(2, result.right.val);
        assertEquals(3, result.right.right.val);
    }

    @Test
    void testBuildTreeWithMaxValues() {
        int[] preorder = {3000, 0, -3000};
        int[] inorder = {-3000, 0, 3000};
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertEquals(3000, result.val);
        assertEquals(0, result.left.val);
        assertEquals(-3000, result.left.left.val);
        assertNull(result.right);
    }

    @Test
    void testBuildTreeWithEqualLengthArrays() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {2, 1, 4, 3, 5};
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertEquals(1, result.val);
        assertEquals(2, result.left.val);
        assertEquals(3, result.right.val);
        assertEquals(4, result.right.left.val);
        assertEquals(5, result.right.right.val);
    }

    @Test
    void testBuildTreeWithSingleNodeTree() {
        int[] preorder = {42};
        int[] inorder = {42};
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertEquals(42, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            binaryTree.buildTree(new int[]{}, new int[]{});
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            binaryTree.buildTree(new int[]{1, 2}, new int[]{1});
        });
    }
}