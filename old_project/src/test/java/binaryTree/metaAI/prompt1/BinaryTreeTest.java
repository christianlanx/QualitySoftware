package binaryTree.metaAI.prompt1;
import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class BinaryTreeTest {

    BinaryTree binaryTree = new BinaryTree();

    @Test
    public void testBuildTree_Example1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode expected = new TreeNode(3);
        expected.left = new TreeNode(9);
        expected.right = new TreeNode(20);
        expected.right.left = new TreeNode(15);
        expected.right.right = new TreeNode(7);

        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(treesEqual(expected, actual));
    }

    @Test
    public void testBuildTree_Example2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode expected = new TreeNode(-1);

        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(treesEqual(expected, actual));
    }

    @Test
    public void testBuildTree_SingleNode() {
        int[] preorder = {5};
        int[] inorder = {5};
        TreeNode expected = new TreeNode(5);

        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(treesEqual(expected, actual));
    }

    @Test
    public void testBuildTree_LeftSkewed() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {4, 3, 2, 1};
        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(2);
        expected.left.left = new TreeNode(3);
        expected.left.left.left = new TreeNode(4);

        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(treesEqual(expected, actual));
    }

    @Test
    public void testBuildTree_RightSkewed() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {1, 2, 3, 4};
        TreeNode expected = new TreeNode(1);
        expected.right = new TreeNode(2);
        expected.right.right = new TreeNode(3);
        expected.right.right.right = new TreeNode(4);

        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(treesEqual(expected, actual));
    }

    private boolean treesEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val && treesEqual(t1.left, t2.left) && treesEqual(t1.right, t2.right);
    }
}