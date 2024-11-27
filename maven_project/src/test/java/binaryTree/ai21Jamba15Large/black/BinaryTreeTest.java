package binaryTree.ai21Jamba15Large.black;
import binaryTree.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class BinaryTreeTest {

    @Test
    void testBuildTreeExample1() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode expected = new TreeNode(3, 
                                         new TreeNode(9), 
                                         new TreeNode(20, 
                                                      new TreeNode(15), 
                                                      new TreeNode(7)));
        Assertions.assertEquals(expected, binaryTree.buildTree(preorder, inorder));
    }

    @Test
    void testBuildTreeExample2() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode expected = new TreeNode(-1);
        Assertions.assertEquals(expected, binaryTree.buildTree(preorder, inorder));
    }

    @Test
    void testBuildTreeNullInput() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = null;
        int[] inorder = null;
        Assertions.assertThrows(NullPointerException.class, () -> binaryTree.buildTree(preorder, inorder));
    }

    @Test
    void testBuildTreeEmptyInput() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {};
        int[] inorder = {};
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> binaryTree.buildTree(preorder, inorder));
    }

    @Test
    void testBuildTreeDifferentLengthInput() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1, 2, 3};
        int[] inorder = {1, 2};
        Assertions.assertThrows(IllegalArgumentException.class, () -> binaryTree.buildTree(preorder, inorder));
    }

    @Test
    void testBuildTreeLargeInput() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = new int[3000];
        int[] inorder = new int[3000];
        for (int i = 0; i < 3000; i++) {
            preorder[i] = inorder[i] = i - 1500;
        }
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        Assertions.assertNotNull(root);
        // Further checks can be added to verify the tree structure
    }
}