package binaryTree.metaAI.white;
import binaryTree.*;

import binaryTree.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    public void setup() {
        binaryTree = new BinaryTree();
    }

    @Test
    public void testBuildTree_Null_Preorder() {
        assertThrows(NullPointerException.class, () -> binaryTree.buildTree(null, new int[]{1, 2, 3}));
    }

    @Test
    public void testBuildTree_Null_Inorder() {
        assertThrows(NullPointerException.class, () -> binaryTree.buildTree(new int[]{1, 2, 3}, null));
    }

    @Test
    public void testBuildTree_Empty_Preorder() {
        assertNull(binaryTree.buildTree(new int[]{}, new int[]{1, 2, 3}));
    }

    @Test
    public void testBuildTree_Empty_Inorder() {
        assertNull(binaryTree.buildTree(new int[]{1, 2, 3}, new int[]{}));
    }

    @Test
    public void testBuildTree_Simple_Tree() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertNotNull(root);
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.right.val);
        assertEquals(4, root.left.left.val);
        assertEquals(5, root.left.right.val);
        assertEquals(6, root.right.left.val);
        assertEquals(7, root.right.right.val);
    }

    @Test
    public void testBuildTree_Complex_Tree() {
        int[] preorder = {1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 7};
        int[] inorder = {8, 4, 9, 2, 10, 5, 11, 1, 6, 3, 7};
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        assertNotNull(root);
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.right.val);
        assertEquals(4, root.left.left.val);
        assertEquals(5, root.left.right.val);
        assertEquals(6, root.right.left.val);
        assertEquals(7, root.right.right.val);
        assertEquals(8, root.left.left.left.val);
        assertEquals(9, root.left.left.right.val);
        assertEquals(10, root.left.right.left.val);
        assertEquals(11, root.left.right.right.val);
    }
}