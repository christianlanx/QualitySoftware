package binaryTree.gpt4oMini.black;

import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    
    private final BinaryTree binaryTree = new BinaryTree();

    @Test
    void testBuildTree_example1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertEquals(3, result.val);
        assertEquals(9, result.left.val);
        assertEquals(20, result.right.val);
        assertEquals(15, result.right.left.val);
        assertEquals(7, result.right.right.val);
    }

    @Test
    void testBuildTree_example2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertEquals(-1, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void testBuildTree_multipleLevels() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertEquals(1, result.val);
        assertEquals(2, result.left.val);
        assertEquals(4, result.left.left.val);
        assertEquals(5, result.left.right.val);
        assertEquals(3, result.right.val);
        assertEquals(6, result.right.left.val);
        assertEquals(7, result.right.right.val);
    }

    @Test
    void testBuildTree_leftHeavyTree() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertEquals(1, result.val);
        assertEquals(2, result.left.val);
        assertEquals(3, result.left.left.val);
        assertEquals(4, result.left.left.left.val);
        assertEquals(5, result.left.left.left.left.val);
    }

    @Test
    void testBuildTree_rightHeavyTree() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertEquals(1, result.val);
        assertEquals(2, result.right.val);
        assertEquals(3, result.right.right.val);
        assertEquals(4, result.right.right.right.val);
        assertEquals(5, result.right.right.right.right.val);
    }

    @Test
    void testBuildTree_sameValueNegativePosition() {
        int[] preorder = {-1, -2, -3};
        int[] inorder = {-3, -2, -1};
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertEquals(-1, result.val);
        assertEquals(-2, result.left.val);
        assertEquals(-3, result.left.left.val);
    }
}