package binaryTree.gpt4o.white;
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
    void testBuildTreeWithSingleElement() {
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertNotNull(root);
        assertEquals(1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    void testBuildTreeWithMultipleElements() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertNotNull(root);
        assertEquals(3, root.val);

        assertNotNull(root.left);
        assertEquals(9, root.left.val);
        assertNull(root.left.left);
        assertNull(root.left.right);

        assertNotNull(root.right);
        assertEquals(20, root.right.val);

        assertNotNull(root.right.left);
        assertEquals(15, root.right.left.val);
        assertNull(root.right.left.left);
        assertNull(root.right.left.right);

        assertNotNull(root.right.right);
        assertEquals(7, root.right.right.val);
        assertNull(root.right.right.left);
        assertNull(root.right.right.right);
    }

    @Test
    void testBuildTreeWithEmptyArrays() {
        int[] preorder = {};
        int[] inorder = {};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertNull(root);
    }

    @Test
    void testBuildTreeWithLeftSkewedTree() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {3, 2, 1};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertNotNull(root);
        assertEquals(1, root.val);
        assertNotNull(root.left);
        assertEquals(2, root.left.val);
        assertNotNull(root.left.left);
        assertEquals(3, root.left.left.val);
        assertNull(root.left.left.left);
        assertNull(root.left.left.right);
        assertNull(root.left.right);
        assertNull(root.right);
    }

    @Test
    void testBuildTreeWithRightSkewedTree() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {1, 2, 3};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertNotNull(root);
        assertEquals(1, root.val);
        assertNotNull(root.right);
        assertEquals(2, root.right.val);
        assertNotNull(root.right.right);
        assertEquals(3, root.right.right.val);
        assertNull(root.right.right.left);
        assertNull(root.right.right.right);
        assertNull(root.right.left);
        assertNull(root.left);
    }

    @Test
    void testBuildTreeWithMixedSkewness() {
        int[] preorder = {10, 5, 1, 7, 40, 50};
        int[] inorder = {1, 5, 7, 10, 40, 50};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertNotNull(root);
        assertEquals(10, root.val);

        assertNotNull(root.left);
        assertEquals(5, root.left.val);

        assertNotNull(root.left.left);
        assertEquals(1, root.left.left.val);
        assertNull(root.left.left.left);
        assertNull(root.left.left.right);
        
        assertNotNull(root.left.right);
        assertEquals(7, root.left.right.val);
        assertNull(root.left.right.left);
        assertNull(root.left.right.right);

        assertNotNull(root.right);
        assertEquals(40, root.right.val);

        assertNotNull(root.right.right);
        assertEquals(50, root.right.right.val);
        assertNull(root.right.left);
        assertNull(root.right.right.left);
        assertNull(root.right.right.right);
    }
}