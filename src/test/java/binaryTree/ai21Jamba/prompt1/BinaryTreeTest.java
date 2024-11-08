package binaryTree.ai21Jamba.prompt1;
import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;

import org.junit.Test;
import org.junit.Assert;

public class BinaryTreeTest {

    @Test
    public void testBuildTreeExample1() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode expected = new TreeNode(3,
                                         new TreeNode(9),
                                         new TreeNode(20,
                                                      new TreeNode(15),
                                                      new TreeNode(7)));
        Assert.assertEquals(expected, binaryTree.buildTree(preorder, inorder));
    }

    @Test
    public void testBuildTreeExample2() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode expected = new TreeNode(-1);
        Assert.assertEquals(expected, binaryTree.buildTree(preorder, inorder));
    }

    @Test
    public void testBuildTreeWithMoreComplexTree() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {4, 2, 5, 1, 3};
        TreeNode expected = new TreeNode(1,
                                         new TreeNode(2,
                                                      new TreeNode(4),
                                                      new TreeNode(5)),
                                         new TreeNode(3));
        Assert.assertEquals(expected, binaryTree.buildTree(preorder, inorder));
    }

    @Test
    public void testBuildTreeWithEmptyArrays() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {};
        int[] inorder = {};
        TreeNode expected = null;
        Assert.assertEquals(expected, binaryTree.buildTree(preorder, inorder));
    }

    @Test
    public void testBuildTreeWithNullArrays() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = null;
        int[] inorder = null;
        TreeNode expected = null;
        Assert.assertEquals(expected, binaryTree.buildTree(preorder, inorder));
    }

    @Test
    public void testBuildTreeWithMismatchedLengthArrays() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1, 2, 3};
        int[] inorder = {1, 2};
        TreeNode expected = null;
        Assert.assertEquals(expected, binaryTree.buildTree(preorder, inorder));
    }

    @Test
    public void testBuildTreeWithDuplicateValues() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1, 2, 2, 3};
        int[] inorder = {2, 1, 2, 3};
        TreeNode expected = new TreeNode(1,
                                         new TreeNode(2),
                                         new TreeNode(2,
                                                      null,
                                                      new TreeNode(3)));
        Assert.assertEquals(expected, binaryTree.buildTree(preorder, inorder));
    }

    @Test
    public void testBuildTreeWithNegativeValues() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {-1, -2, -3};
        int[] inorder = {-2, -1, -3};
        TreeNode expected = new TreeNode(-1,
                                         new TreeNode(-2),
                                         new TreeNode(-3));
        Assert.assertEquals(expected, binaryTree.buildTree(preorder, inorder));
    }
}