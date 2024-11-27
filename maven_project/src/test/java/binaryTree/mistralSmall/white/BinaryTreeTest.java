package binaryTree.mistralSmall.white;
import binaryTree.*;
import binaryTree.BinaryTree.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    public void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    public void testBuildTreeWithEmptyPreorderAndInorder() {
        int[] preorder = {};
        int[] inorder = {};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertNull(root);
    }

    @Test
    public void testBuildTreeWithSingleElement() {
        int[] preorder = {1};
        int[] inorder = {1};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertNotNull(root);
        assertEquals(1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    public void testBuildTreeWithTwoElements() {
        int[] preorder = {1, 2};
        int[] inorder = {2, 1};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertNotNull(root);
        assertEquals(1, root.val);
        assertNotNull(root.left);
        assertEquals(2, root.left.val);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertNull(root.right);
    }

    @Test
    public void testBuildTreeWithMultipleElements() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertNotNull(root);
        assertEquals(3, root.val);
        assertNotNull(root.left);
        assertEquals(9, root.left.val);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertNotNull(root.right);
        assertEquals(20, root.right.val);
        assertNotNull(root.right.left);
        assertEquals(15, root.right.left.val);
        assertNull(root.right.left.left);
        assertNull(root.right.left.right);
        assertNotNull(root.right.right);
        assertEquals(7, root.right.right.val);
        assertNull(root.right.right.left);
        assertNull(root.right.right.right);
    }
}