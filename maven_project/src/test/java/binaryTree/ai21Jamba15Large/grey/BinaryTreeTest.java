package binaryTree.ai21Jamba15Large.grey;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import binaryTree.TreeNode;

public class BinaryTreeTest {

    private BinaryTree binaryTree = new BinaryTree();

    @Test
    void testBuildTreeExample1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode expected = new TreeNode(3, 
                                         new TreeNode(9), 
                                         new TreeNode(20, 
                                                      new TreeNode(15), 
                                                      new TreeNode(7)));
        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertEquals(expected, actual);
    }

    @Test
    void testBuildTreeExample2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode expected = new TreeNode(-1);
        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertEquals(expected, actual);
    }

    @Test
    void testBuildTreeNull() {
        int[] preorder = {};
        int[] inorder = {};
        TreeNode expected = null;
        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertEquals(expected, actual);
    }

    @Test
    void testBuildTreeLargeInput() {
        int[] preorder = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] inorder = {4, 2, 5, 1, 8, 6, 9, 3, 11, 10, 12, 7, 14, 13, 15};
        TreeNode expected = new TreeNode(1, 
                                         new TreeNode(2, 
                                                      new TreeNode(4), 
                                                      new TreeNode(5)), 
                                         new TreeNode(3, 
                                                      new TreeNode(8, 
                                                                   new TreeNode(6), 
                                                                   new TreeNode(9)), 
                                                      new TreeNode(7, 
                                                                   new TreeNode(11, 
                                                                                new TreeNode(10), 
                                                                                new TreeNode(12)), 
                                                                   new TreeNode(14, 
                                                                                new TreeNode(13), 
                                                                                new TreeNode(15)))));
        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertEquals(expected, actual);
    }

    @Test
    void testBuildTreeSingleNode() {
        int[] preorder = {1};
        int[] inorder = {1};
        TreeNode expected = new TreeNode(1);
        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertEquals(expected, actual);
    }

    @Test
    void testBuildTreeNegativeValues() {
        int[] preorder = {-10, -5, 0, 5, 10};
        int[] inorder = {-10, -5, 0, 5, 10};
        TreeNode expected = new TreeNode(-10, 
                                         new TreeNode(-5, 
                                                      null, 
                                                      new TreeNode(0, 
                                                                   null, 
                                                                   new TreeNode(5, 
                                                                                null, 
                                                                                new TreeNode(10)))));
        TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertEquals(expected, actual);
    }

    @Test
    void testBuildTreeDuplicateValues() {
        int[] preorder = {1, 2, 2, 3};
        int[] inorder = {2, 1, 2, 3};
        assertThrows(IllegalArgumentException.class, () -> binaryTree.buildTree(preorder, inorder));
    }

    @Test
    void testBuildTreeMismatchedLengths() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {1, 2};
        assertThrows(IllegalArgumentException.class, () -> binaryTree.buildTree(preorder, inorder));
    }

    @Test
    void testBuildTreeInvalidInput() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {4, 5, 6};
        assertThrows(IllegalArgumentException.class, () -> binaryTree.buildTree(preorder, inorder));
    }
}