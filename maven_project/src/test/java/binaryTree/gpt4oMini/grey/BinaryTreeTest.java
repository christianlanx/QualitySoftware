package binaryTree.gpt4oMini.grey;

import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    private final BinaryTree binaryTree = new BinaryTree();

    @Test
    public void testBuildTreeExample1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertEquals(3, root.val);
        assertEquals(9, root.left.val);
        assertEquals(20, root.right.val);
        assertEquals(15, root.right.left.val);
        assertEquals(7, root.right.right.val);
    }

    @Test
    public void testBuildTreeExample2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertEquals(-1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    public void testBuildTreeWithMultipleLevels() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.right.val);
        assertEquals(4, root.left.left.val);
        assertEquals(5, root.left.right.val);
        assertEquals(6, root.right.left.val);
        assertEquals(7, root.right.right.val);
    }

    @Test
    public void testBuildTreeWithSingleLeftChild() {
        int[] preorder = {2, 1};
        int[] inorder = {1, 2};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertEquals(2, root.val);
        assertEquals(1, root.left.val);
        assertNull(root.right);
    }

    @Test
    public void testBuildTreeWithSingleRightChild() {
        int[] preorder = {1, 2};
        int[] inorder = {1, 2};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertEquals(1, root.val);
        assertNull(root.left);
        assertEquals(2, root.right.val);
    }

    @Test
    public void testBuildTreeEmptyArrays() {
        int[] preorder = {};
        int[] inorder = {};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertNull(root);
    }

    @Test
    public void testBuildTreeInvalidArrays() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {2, 3, 1};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.right.val);
    }
}