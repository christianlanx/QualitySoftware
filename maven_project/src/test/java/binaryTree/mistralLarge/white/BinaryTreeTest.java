package binaryTree.mistralLarge.white;
import binaryTree.*;

import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void testBuildTree() {
        BinaryTree binaryTree = new BinaryTree();

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

    @Test
    public void testBuildTreeEmpty() {
        BinaryTree binaryTree = new BinaryTree();

        int[] preorder = {};
        int[] inorder = {};

        TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertNull(root);
    }

    @Test
    public void testBuildTreeSingleElement() {
        BinaryTree binaryTree = new BinaryTree();

        int[] preorder = {1};
        int[] inorder = {1};

        TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertNotNull(root);
        assertEquals(1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    public void testBuildTreeAllLeft() {
        BinaryTree binaryTree = new BinaryTree();

        int[] preorder = {1, 2, 3};
        int[] inorder = {3, 2, 1};

        TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertNotNull(root);
        assertEquals(1, root.val);

        assertNotNull(root.left);
        assertEquals(2, root.left.val);

        assertNotNull(root.left.left);
        assertEquals(3, root.left.left.val);
        assertNull(root.left.left.left);
        assertNull(root.left.left.right);

        assertNull(root.left.right);
        assertNull(root.right);
    }

    @Test
    public void testBuildTreeAllRight() {
        BinaryTree binaryTree = new BinaryTree();

        int[] preorder = {1, 2, 3};
        int[] inorder = {1, 2, 3};

        TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertNotNull(root);
        assertEquals(1, root.val);

        assertNull(root.left);

        assertNotNull(root.right);
        assertEquals(2, root.right.val);

        assertNull(root.right.left);

        assertNotNull(root.right.right);
        assertEquals(3, root.right.right.val);
        assertNull(root.right.right.left);
        assertNull(root.right.right.right);
    }
}