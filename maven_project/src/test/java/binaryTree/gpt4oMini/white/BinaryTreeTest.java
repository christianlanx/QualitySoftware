package binaryTree.gpt4oMini.white;
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
    void testBuildTreeWithValidInput() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertNotNull(root);
        assertEquals(3, root.val);
        assertNotNull(root.left);
        assertEquals(9, root.left.val);
        assertNotNull(root.right);
        assertEquals(20, root.right.val);
        assertNotNull(root.right.left);
        assertEquals(15, root.right.left.val);
        assertNotNull(root.right.right);
        assertEquals(7, root.right.right.val);
    }

    @Test
    void testBuildTreeWithSingleNode() {
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertNotNull(root);
        assertEquals(1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    void testBuildTreeWithEmptyArrays() {
        int[] preorder = {};
        int[] inorder = {};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertNull(root);
    }
    
    @Test
    void testBuildTreeWithNulls() {
        int[] preorder = null;
        int[] inorder = null;
        
        // Since the provided code does not handle null arrays, we should expect it to throw an exception
        assertThrows(NullPointerException.class, () -> {
            binaryTree.buildTree(preorder, inorder);
        });
    }

    @Test
    void testBuildTreeWithUnbalancedTree() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {4, 3, 2, 1};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertNotNull(root);
        assertEquals(1, root.val);
        assertNotNull(root.right);
        assertEquals(2, root.right.val);
        assertNotNull(root.right.right);
        assertEquals(3, root.right.right.val);
        assertNotNull(root.right.right.right);
        assertEquals(4, root.right.right.right.val);
    }
}