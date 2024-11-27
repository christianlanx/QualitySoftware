package binaryTree.ai21Jamba15Large.white;
import binaryTree.*;
import binaryTree.BinaryTree.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void testBuildTree() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode expected = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertEquals(expected.val, result.val);
        assertEquals(expected.left.val, result.left.val);
        assertEquals(expected.right.val, result.right.val);
        assertEquals(expected.right.left.val, result.right.left.val);
        assertEquals(expected.right.right.val, result.right.right.val);
    }

    @Test
    void testBuildTreeWithEmptyArrays() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {};
        int[] inorder = {};
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertNull(result);
    }

    @Test
    void testBuildTreeWithSingleElement() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1};
        int[] inorder = {1};
        TreeNode expected = new TreeNode(1);
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertEquals(expected.val, result.val);
    }

    @Test
    void testBuildTreeWithInvalidInput() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1, 2};
        int[] inorder = {1};
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertNull(result);
    }

    @Test
    void testBuildTreeWithDifferentInput() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1, 2, 3};
        int[] inorder = {2, 1, 3};
        TreeNode expected = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertEquals(expected.val, result.val);
        assertEquals(expected.left.val, result.left.val);
        assertEquals(expected.right.val, result.right.val);
    }
}