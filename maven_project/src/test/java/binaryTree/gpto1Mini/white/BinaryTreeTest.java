package binaryTree.gpto1Mini.white;
import binaryTree.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private void assertTreesEqual(BinaryTree.TreeNode expected, BinaryTree.TreeNode actual) {
        if (expected == null && actual == null) {
            return;
        }
        assertNotNull(actual, "Actual tree node is null while expected is not.");
        assertEquals(expected.val, actual.val, "Node values do not match.");
        assertTreesEqual(expected.left, actual.left);
        assertTreesEqual(expected.right, actual.right);
    }

    @Test
    void testEmptyTree() {
        BinaryTree bt = new BinaryTree();
        int[] preorder = {};
        int[] inorder = {};
        BinaryTree.TreeNode root = bt.buildTree(preorder, inorder);
        assertNull(root, "The tree should be null for empty input.");
    }

    @Test
    void testSingleNode() {
        BinaryTree bt = new BinaryTree();
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTree.TreeNode root = bt.buildTree(preorder, inorder);
        assertNotNull(root, "The root should not be null.");
        assertEquals(1, root.val, "The root value should be 1.");
        assertNull(root.left, "Left child should be null.");
        assertNull(root.right, "Right child should be null.");
    }

    @Test
    void testCompleteBinaryTree() {
        BinaryTree bt = new BinaryTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BinaryTree.TreeNode expected = new BinaryTree.TreeNode(3,
                new BinaryTree.TreeNode(9),
                new BinaryTree.TreeNode(20, new BinaryTree.TreeNode(15), new BinaryTree.TreeNode(7)));
        BinaryTree.TreeNode actual = bt.buildTree(preorder, inorder);
        assertTreesEqual(expected, actual);
    }

    @Test
    void testLeftSkewedTree() {
        BinaryTree bt = new BinaryTree();
        int[] preorder = {4, 3, 2, 1};
        int[] inorder = {1, 2, 3, 4};
        BinaryTree.TreeNode expected = new BinaryTree.TreeNode(4,
                new BinaryTree.TreeNode(3,
                        new BinaryTree.TreeNode(2,
                                new BinaryTree.TreeNode(1),
                                null),
                        null),
                null);
        BinaryTree.TreeNode actual = bt.buildTree(preorder, inorder);
        assertTreesEqual(expected, actual);
    }

    @Test
    void testRightSkewedTree() {
        BinaryTree bt = new BinaryTree();
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {1, 2, 3, 4};
        BinaryTree.TreeNode expected = new BinaryTree.TreeNode(1,
                null,
                new BinaryTree.TreeNode(2,
                        null,
                        new BinaryTree.TreeNode(3,
                                null,
                                new BinaryTree.TreeNode(4))));
        BinaryTree.TreeNode actual = bt.buildTree(preorder, inorder);
        assertTreesEqual(expected, actual);
    }

    @Test
    void testMultipleBranches() {
        BinaryTree bt = new BinaryTree();
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        BinaryTree.TreeNode expected = new BinaryTree.TreeNode(1,
                new BinaryTree.TreeNode(2,
                        new BinaryTree.TreeNode(4),
                        new BinaryTree.TreeNode(5)),
                new BinaryTree.TreeNode(3,
                        new BinaryTree.TreeNode(6),
                        new BinaryTree.TreeNode(7)));
        BinaryTree.TreeNode actual = bt.buildTree(preorder, inorder);
        assertTreesEqual(expected, actual);
    }

    @Test
    void testInvalidInput_MismatchedArrays() {
        BinaryTree bt = new BinaryTree();
        int[] preorder = {1, 2};
        int[] inorder = {2, 3};
        BinaryTree.TreeNode actual = bt.buildTree(preorder, inorder);
        // Since the implementation does not handle mismatched inputs explicitly,
        // we verify that the constructed tree matches the possible partial tree.
        BinaryTree.TreeNode expected = new BinaryTree.TreeNode(1,
                new BinaryTree.TreeNode(2),
                null);
        assertTreesEqual(expected, actual);
    }

    @Test
    void testDuplicateValues() {
        BinaryTree bt = new BinaryTree();
        int[] preorder = {1, 2, 2};
        int[] inorder = {2, 1, 2};
        BinaryTree.TreeNode root = bt.buildTree(preorder, inorder);
        assertNotNull(root, "Root should not be null.");
        assertEquals(1, root.val, "Root value should be 1.");
        assertNotNull(root.left, "Left child should not be null.");
        assertEquals(2, root.left.val, "Left child value should be 2.");
        assertNotNull(root.right, "Right child should not be null.");
        assertEquals(2, root.right.val, "Right child value should be 2.");
    }

    @Test
    void testLargeTree() {
        BinaryTree bt = new BinaryTree();
        int n = 1000;
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            preorder[i] = i + 1;
            inorder[i] = i + 1;
        }
        BinaryTree.TreeNode actual = bt.buildTree(preorder, inorder);
        assertNotNull(actual, "The tree should not be null.");
        // Verify the tree is a right skewed tree
        BinaryTree.TreeNode current = actual;
        for (int i = 1; i < n; i++) {
            assertNull(current.left, "Left child should be null.");
            assertNotNull(current.right, "Right child should not be null.");
            assertEquals(i + 1, current.right.val, "Incorrect right child value.");
            current = current.right;
        }
        assertNull(current.left, "Left child should be null.");
        assertNull(current.right, "Right child should be null.");
    }
}