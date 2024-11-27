package binaryTree.gpt4oMini.black;
import binaryTree.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    private final BinaryTree binaryTree = new BinaryTree();

    @Test
    void testBuildTreeExample1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode expected = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertEquals(expected.val, result.val);
        assertEquals(expected.left.val, result.left.val);
        assertEquals(expected.right.val, result.right.val);
        assertEquals(expected.right.left.val, result.right.left.val);
        assertEquals(expected.right.right.val, result.right.right.val);
    }

    @Test
    void testBuildTreeExample2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode expected = new TreeNode(-1);
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertEquals(expected.val, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void testBuildTreeWithLeftChild() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {4, 3, 2, 1};
        TreeNode expected = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4, null, null),
                                null),
                        null),
                null);
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertEquals(expected.val, result.val);
        assertEquals(expected.left.val, result.left.val);
        assertEquals(expected.left.left.val, result.left.left.val);
        assertEquals(expected.left.left.left.val, result.left.left.left.val);
    }

    @Test
    void testBuildTreeWithRightChild() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {1, 2, 3, 4};
        TreeNode expected = new TreeNode(1,
                null,
                new TreeNode(2,
                        null,
                        new TreeNode(3,
                                null,
                                new TreeNode(4))));
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertEquals(expected.val, result.val);
        assertNull(result.left);
        assertEquals(expected.right.val, result.right.val);
        assertEquals(expected.right.right.val, result.right.right.val);
        assertEquals(expected.right.right.right.val, result.right.right.right.val);
    }

    @Test
    void testEmptyTree() {
        int[] preorder = {};
        int[] inorder = {};
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertNull(result);
    }
}