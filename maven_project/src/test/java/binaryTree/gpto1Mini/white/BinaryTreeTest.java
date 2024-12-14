package binaryTree.gpto1Mini.white;

import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;

class BinaryTreeTest {

    @Test
    @DisplayName("Test building tree with empty input arrays")
    void testBuildTree_Empty() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {};
        int[] inorder = {};
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        Assertions.assertNull(result, "The result should be null for empty input arrays.");
    }

    @Test
    @DisplayName("Test building tree with single node")
    void testBuildTree_SingleNode() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1};
        int[] inorder = {1};
        TreeNode expected = new TreeNode(1);
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        Assertions.assertTrue(isSameTree(expected, result), "The trees should be identical for single node input.");
    }

    @Test
    @DisplayName("Test building tree with valid preorder and inorder arrays")
    void testBuildTree_ValidTree() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode expected = new TreeNode(3);
        expected.left = new TreeNode(9);
        expected.right = new TreeNode(20);
        expected.right.left = new TreeNode(15);
        expected.right.right = new TreeNode(7);

        TreeNode result = binaryTree.buildTree(preorder, inorder);
        Assertions.assertTrue(isSameTree(expected, result), "The constructed tree should match the expected tree.");
    }

    /**
     * Helper method to compare two binary trees for equality.
     *
     * @param p the first tree
     * @param q the second tree
     * @return true if both trees are identical, false otherwise
     */
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}