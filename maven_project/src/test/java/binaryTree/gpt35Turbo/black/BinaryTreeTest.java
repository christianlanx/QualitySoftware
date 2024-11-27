package binaryTree.gpt35Turbo.black;
import binaryTree.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void testExample1() {
        BinaryTree bt = new BinaryTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode result = bt.buildTree(preorder, inorder);

        TreeNode expected = new TreeNode(3);
        expected.left = new TreeNode(9);
        expected.right = new TreeNode(20);
        expected.right.left = new TreeNode(15);
        expected.right.right = new TreeNode(7);

        assertEquals(expected.val, result.val);
        assertEquals(expected.left.val, result.left.val);
        assertEquals(expected.right.val, result.right.val);
        assertEquals(expected.right.left.val, result.right.left.val);
        assertEquals(expected.right.right.val, result.right.right.val);
    }

    @Test
    public void testExample2() {
        BinaryTree bt = new BinaryTree();
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode result = bt.buildTree(preorder, inorder);

        TreeNode expected = new TreeNode(-1);

        assertEquals(expected.val, result.val);
    }
}