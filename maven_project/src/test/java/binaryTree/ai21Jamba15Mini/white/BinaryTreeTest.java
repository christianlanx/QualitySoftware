package binaryTree.ai21Jamba15Mini.white;
import binaryTree.*;
import binaryTree.BinaryTree.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    void testBuildTree() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {4, 2, 5, 1, 3};
        BinaryTree.TreeNode expected = new BinaryTree.TreeNode(1, 
                                            new BinaryTree.TreeNode(2, 
                                                    new BinaryTree.TreeNode(4), 
                                                    new BinaryTree.TreeNode(5)), 
                                            new BinaryTree.TreeNode(3));
        BinaryTree.TreeNode actual = BinaryTree.buildTree(preorder, inorder);
        assertEquals(expected, actual);
    }

    @Test
    void testBuildTreeEmptyPreorder() {
        int[] preorder = {};
        int[] inorder = {4, 2, 5, 1, 3};
        BinaryTree.TreeNode actual = BinaryTree.buildTree(preorder, inorder);
        assertNull(actual);
    }

    @Test
    void testBuildTreeEmptyInorder() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {};
        BinaryTree.TreeNode actual = BinaryTree.buildTree(preorder, inorder);
        assertNull(actual);
    }

    @Test
    void testBuildTreeSingleNode() {
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTree.TreeNode expected = new BinaryTree.TreeNode(1);
        BinaryTree.TreeNode actual = BinaryTree.buildTree(preorder, inorder);
        assertEquals(expected, actual);
    }
}