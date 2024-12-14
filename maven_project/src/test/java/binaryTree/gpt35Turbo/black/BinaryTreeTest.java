package binaryTree.gpt35Turbo.black;

import binaryTree.BinaryTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BinaryTreeTest {

    @Test
    void testBuildTreeExample1() {
        BinaryTree.TreeNode expected = new BinaryTree.TreeNode(3);
        expected.left = new BinaryTree.TreeNode(9);
        expected.right = new BinaryTree.TreeNode(20, new BinaryTree.TreeNode(15), new BinaryTree.TreeNode(7));

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        BinaryTree.TreeNode result = new BinaryTree().buildTree(preorder, inorder);

        assertEquals(expected.val, result.val);
        assertEquals(expected.left.val, result.left.val);
        assertEquals(expected.right.val, result.right.val);
        assertEquals(expected.right.left.val, result.right.left.val);
        assertEquals(expected.right.right.val, result.right.right.val);
        assertNull(result.left.left);
        assertNull(result.left.right);
        assertNull(result.right.left.left);
        assertNull(result.right.left.right);
        assertNull(result.right.right.left);
        assertNull(result.right.right.right);
    }

    @Test
    void testBuildTreeExample2() {
        BinaryTree.TreeNode expected = new BinaryTree.TreeNode(-1);

        int[] preorder = {-1};
        int[] inorder = {-1};

        BinaryTree.TreeNode result = new BinaryTree().buildTree(preorder, inorder);

        assertEquals(expected.val, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }
}