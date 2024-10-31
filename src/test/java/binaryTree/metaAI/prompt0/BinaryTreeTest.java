package binaryTree.metaAI.prompt0;
import binaryTree.BinaryTree;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class BinaryTreeTest {

    BinaryTree binaryTree = new BinaryTree();

    // Test null tree
    @Test
    public void testNullTree() {
        int[] preorder = {};
        int[] inorder = {};
        assertNull(binaryTree.buildTree(preorder, inorder));
    }

    // Test single node tree
    @Test
    public void testSingleNodeTree() {
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTree.TreeNode node = binaryTree.buildTree(preorder, inorder);
        assertNotNull(node);
        assertEquals(1, node.val);
        assertNull(node.left);
        assertNull(node.right);
    }

    // Test balanced tree
    @Test
    public void testBalancedTree() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        BinaryTree.TreeNode node = binaryTree.buildTree(preorder, inorder);
        assertNotNull(node);
        assertEquals(1, node.val);
        assertEquals(2, node.left.val);
        assertEquals(3, node.right.val);
        assertEquals(4, node.left.left.val);
        assertEquals(5, node.left.right.val);
        assertEquals(6, node.right.left.val);
        assertEquals(7, node.right.right.val);
    }

    // Test unbalanced tree
    @Test
    public void testUnbalancedTree() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {3, 2, 1};
        BinaryTree.TreeNode node = binaryTree.buildTree(preorder, inorder);
        assertNotNull(node);
        assertEquals(1, node.val);
        assertEquals(2, node.left.val);
        assertEquals(3, node.left.left.val);
        assertNull(node.right);
    }

    // Test large tree
    @Test
    public void testLargeTree() {
        int[] preorder = {1, 2, 4, 8, 9, 5, 3, 6, 10, 11, 7};
        int[] inorder = {8, 4, 9, 2, 5, 10, 1, 6, 11, 3, 7};
        BinaryTree.TreeNode node = binaryTree.buildTree(preorder, inorder);
        assertNotNull(node);
        assertEquals(1, node.val);
        assertEquals(2, node.left.val);
        assertEquals(3, node.right.val);
        assertEquals(4, node.left.left.val);
        assertEquals(5, node.left.right.val);
        assertEquals(6, node.right.left.val);
        assertEquals(7, node.right.right.val);
        assertEquals(8, node.left.left.left.val);
        assertEquals(9, node.left.left.right.val);
        assertEquals(10, node.right.left.left.val);
        assertEquals(11, node.right.left.right.val);
    }
}