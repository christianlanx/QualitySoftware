package binaryTree.gpt35Turbo.grey;

import binaryTree.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeTest {

    @Test
    public void testBuildTreeExample1() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertEquals(3, root.val);
        assertEquals(9, root.left.val);
        assertEquals(20, root.right.val);
        assertEquals(15, root.right.left.val);
        assertEquals(7, root.right.right.val);
    }

    @Test
    public void testBuildTreeExample2() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {-1};
        int[] inorder = {-1};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertEquals(-1, root.val);
    }
}