package binaryTree.metaAI.black;
import binaryTree.*;
import binaryTree.BinaryTree.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    private BinaryTree binaryTree = new BinaryTree();

    @Test
    public void testBuildTree_Example1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode expected = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(equals(expected, actual));
    }

    @Test
    public void testBuildTree_Example2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode expected = new TreeNode(-1);
        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(equals(expected, actual));
    }

    @Test
    public void testBuildTree_EmptyArrays() {
        int[] preorder = {};
        int[] inorder = {};
        TreeNode expected = null;
        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertEquals(expected, actual);
    }

    private boolean equals(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val && equals(t1.left, t2.left) && equals(t1.right, t2.right);
    }
}