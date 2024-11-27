package binaryTree.mistralLarge.black;
import binaryTree.*;
import binaryTree.BinaryTree.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void testBuildTreeExample1() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = binaryTree.buildTree(preorder, inorder);

        // Expected tree structure:
        //     3
        //    / \
        //   9  20
        //     /  \
        //    15   7

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

    @Test
    public void testBuildTreeExample2() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {-1};
        int[] inorder = {-1};

        TreeNode root = binaryTree.buildTree(preorder, inorder);

        // Expected tree structure:
        //    -1

        assertNotNull(root);
        assertEquals(-1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    public void testBuildTreeSingleElement() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1};
        int[] inorder = {1};

        TreeNode root = binaryTree.buildTree(preorder, inorder);

        // Expected tree structure:
        //    1

        assertNotNull(root);
        assertEquals(1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    public void testBuildTreeMultipleElements() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {4, 2, 5, 3, 1};

        TreeNode root = binaryTree.buildTree(preorder, inorder);

        // Expected tree structure:
        //     1
        //    / \
        //   2   3
        //  /   /
        // 4   5

        assertNotNull(root);
        assertEquals(1, root.val);

        assertNotNull(root.left);
        assertEquals(2, root.left.val);

        assertNotNull(root.left.left);
        assertEquals(4, root.left.left.val);
        assertNull(root.left.left.left);
        assertNull(root.left.left.right);

        assertNull(root.left.right);

        assertNotNull(root.right);
        assertEquals(3, root.right.val);

        assertNotNull(root.right.left);
        assertEquals(5, root.right.left.val);
        assertNull(root.right.left.left);
        assertNull(root.right.left.right);

        assertNull(root.right.right);
    }

    @Test
    public void testBuildTreeEmpty() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {};
        int[] inorder = {};

        TreeNode root = binaryTree.buildTree(preorder, inorder);

        // Expected tree structure:
        //    null

        assertNull(root);
    }
}