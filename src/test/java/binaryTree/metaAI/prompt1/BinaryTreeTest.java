package binaryTree.metaAI.prompt1;
import binaryTree.BinaryTree;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeTest {

    BinaryTree binaryTree = new BinaryTree();

    @Test
    public void testExample1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode expected = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        assertEquals(expected, binaryTree.buildTree(preorder, inorder));
    }

    @Test
    public void testExample2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode expected = new TreeNode(-1);
        assertEquals(expected, binaryTree.buildTree(preorder, inorder));
    }

    @Test
    public void testEmptyInput() {
        int[] preorder = {};
        int[] inorder = {};
        assertNull(binaryTree.buildTree(preorder, inorder));
    }

    @Test
    public void testSingleElement() {
        int[] preorder = {1};
        int[] inorder = {1};
        TreeNode expected = new TreeNode(1);
        assertEquals(expected, binaryTree.buildTree(preorder, inorder));
    }

    @Test
    public void testMultipleElements() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        TreeNode expected = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        assertEquals(expected, binaryTree.buildTree(preorder, inorder));
    }

    private void assertEquals(TreeNode expected, TreeNode actual) {
        assertEquals(expected.val, actual.val);
        if (expected.left != null) {
            assertEquals(expected.left.val, actual.left.val);
        } else {
            assertNull(actual.left);
        }
        if (expected.right != null) {
            assertEquals(expected.right.val, actual.right.val);
        } else {
            assertNull(actual.right);
        }
    }
}