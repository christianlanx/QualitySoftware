package binaryTree.gpt4o.black;
import binaryTree.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinaryTreeTest {

    private BinaryTree binaryTree = new BinaryTree();

    @Test
    public void testBuildTreeExample1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode expected = new TreeNode(3,
                             new TreeNode(9),
                             new TreeNode(20,
                                   new TreeNode(15),
                                   new TreeNode(7))
                );
        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(compareTrees(expected, actual));
    }

    @Test
    public void testBuildTreeExample2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode expected = new TreeNode(-1);
        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(compareTrees(expected, actual));
    }

    @Test
    public void testBuildTreeSingleElement() {
        int[] preorder = {42};
        int[] inorder = {42};
        TreeNode expected = new TreeNode(42);
        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(compareTrees(expected, actual));
    }

    @Test
    public void testBuildTreeLeftSkewed() {
        int[] preorder = {3, 2, 1};
        int[] inorder = {1, 2, 3};
        TreeNode expected = new TreeNode(3,
                             new TreeNode(2,
                                   new TreeNode(1),
                                   null),
                             null);
        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(compareTrees(expected, actual));
    }

    @Test
    public void testBuildTreeRightSkewed() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {1, 2, 3};
        TreeNode expected = new TreeNode(1,
                             null,
                             new TreeNode(2,
                                   null,
                                   new TreeNode(3)));
        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(compareTrees(expected, actual));
    }
  
    private boolean compareTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && compareTrees(t1.left, t2.left) && compareTrees(t1.right, t2.right);
    }
}