package binaryTree.ai21Jamba15Large.white;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;

public class BinaryTreeTest {

    private BinaryTree binaryTree;
    private int[] preorder;
    private int[] inorder;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
        preorder = new int[]{1, 2, 4, 5, 3, 6};
        inorder = new int[]{4, 2, 5, 1, 3, 6};
    }

    @Test
    void testBuildTree() {
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertNotNull(root);
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(4, root.left.left.val);
        assertEquals(5, root.left.right.val);
        assertEquals(3, root.right.val);
        assertEquals(6, root.right.right.val);
    }

    @Test
    void testBuildTreeWithEmptyArrays() {
        preorder = new int[]{};
        inorder = new int[]{};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertNull(root);
    }

    @Test
    void testBuildTreeWithSingleElement() {
        preorder = new int[]{1};
        inorder = new int[]{1};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertNotNull(root);
        assertEquals(1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    void testBuildTreeWithInvalidInorder() {
        inorder = new int[]{1, 2};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertNull(root);
    }

    @Test
    void testBuildTreeWithInvalidPreorder() {
        preorder = new int[]{1, 2, 3, 4};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertNull(root);
    }
}