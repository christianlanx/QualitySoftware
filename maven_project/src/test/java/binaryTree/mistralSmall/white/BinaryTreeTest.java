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
    public void testBuildTreeEmptyArrays() {
        int[] preorder = {};
        int[] inorder = {};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertNull(root);
    }

    @Test
    public void testBuildTreeSingleElement() {
        int[] preorder = {1};
        int[] inorder = {1};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertEquals(1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    public void testBuildTreeSimpleTree() {
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
    public void testBuildTreeWithNullValues() {
        int[] preorder = {1, 2, null, 3, null, 4};
        int[] inorder = {1, null, 2, 3, 4};
        TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertEquals(1, root.val);
        assertNull(root.left);
        assertEquals(2, root.right.val);
        assertNull(root.right.left);
        assertEquals(3, root.right.right.val);
        assertEquals(4, root.right.right.right.val);
    }

    @Test
    public void testBuildTreeWithDuplicateValues() {
        int[] preorder = {1, 2, 3, 2};
        int[] inorder = {2, 1, 3, 2};
        TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(2, root.right.val);
    }
}