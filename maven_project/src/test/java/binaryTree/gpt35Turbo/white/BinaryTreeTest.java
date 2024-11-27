package binaryTree.gpt35Turbo.white;
import binaryTree.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    @Test
    void testBuildTree() {
        BinaryTree binaryTree = new BinaryTree();

        // Test case 1: Empty input arrays
        int[] preorder1 = {};
        int[] inorder1 = {};
        assertNull(binaryTree.buildTree(preorder1, inorder1));

        // Test case 2: Single node tree
        int[] preorder2 = {1};
        int[] inorder2 = {1};
        BinaryTree.TreeNode expectedNode2 = new BinaryTree.TreeNode(1);
        assertEquals(expectedNode2.val, binaryTree.buildTree(preorder2, inorder2).val);

        // Test case 3: Balanced binary tree
        int[] preorder3 = {3, 9, 20, 15, 7};
        int[] inorder3 = {9, 3, 15, 20, 7};
        BinaryTree.TreeNode expectedNode3 = new BinaryTree.TreeNode(3);
        expectedNode3.left = new BinaryTree.TreeNode(9);
        expectedNode3.right = new BinaryTree.TreeNode(20);
        expectedNode3.right.left = new BinaryTree.TreeNode(15);
        expectedNode3.right.right = new BinaryTree.TreeNode(7);
        assertEquals(expectedNode3.val, binaryTree.buildTree(preorder3, inorder3).val);
    }
}