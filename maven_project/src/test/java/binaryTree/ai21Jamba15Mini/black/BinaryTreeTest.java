package binaryTree.ai21Jamba15Mini.black;
import binaryTree.*;
import binaryTree.BinaryTree.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    void testExample1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode expected = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        BinaryTree tree = new BinaryTree();
        TreeNode actual = tree.buildTree(preorder, inorder);
        assertEquals(expected, actual);
    }

    @Test
    void testExample2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode expected = new TreeNode(-1);
        BinaryTree tree = new BinaryTree();
        TreeNode actual = tree.buildTree(preorder, inorder);
        assertEquals(expected, actual);
    }

    // Add more test cases to cover different scenarios:
    // - Empty arrays
    // - Single node trees
    // - Trees with multiple levels
    // - Edge cases with duplicate values
}