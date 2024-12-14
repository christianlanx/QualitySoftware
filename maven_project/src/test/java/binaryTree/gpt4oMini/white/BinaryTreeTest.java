package binaryTree.gpt4oMini.white;

import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void testBuildTree() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(result);
        assertEquals(3, result.val);
        assertEquals(9, result.left.val);
        assertEquals(20, result.right.val);
        assertEquals(15, result.right.left.val);
        assertEquals(7, result.right.right.val);
    }

    @Test
    void testBuildTreeWithEmptyInput() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {};
        int[] inorder = {};
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertNull(result);
    }

    @Test
    void testBuildTreeWithSingleElement() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1};
        int[] inorder = {1};
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(result);
        assertEquals(1, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void testBuildTreeWithUnbalancedTree() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {4, 3, 2, 1};
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(result);
        assertEquals(1, result.val);
        assertNotNull(result.left);
        assertNull(result.right);
        assertEquals(2, result.left.val);
        assertNotNull(result.left.left);
        assertNull(result.left.right);
        assertEquals(3, result.left.left.val);
        assertNotNull(result.left.left.left);
        assertNull(result.left.left.right);
        assertEquals(4, result.left.left.left.val);
    }

    @Test
    void testBuildTreeWithDuplicateValues() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {2, 1, 2};
        int[] inorder = {1, 2, 2};
        
        TreeNode result = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(result);
        assertEquals(2, result.val);
        assertEquals(1, result.left.val);
        assertNotNull(result.right);
        assertEquals(2, result.right.val);
        assertNull(result.left.left);
        assertNull(result.left.right);
        assertNull(result.right.left);
        assertNull(result.right.right);
    }
}