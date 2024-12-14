package binaryTree.gpto1Mini.grey;

import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    /**
     * Helper method to compare two binary trees.
     *
     * @param expected The expected TreeNode.
     * @param actual   The actual TreeNode.
     * @return true if both trees are identical, false otherwise.
     */
    private boolean areTreesEqual(TreeNode expected, TreeNode actual) {
        if (expected == null && actual == null) {
            return true;
        }
        if (expected == null || actual == null) {
            return false;
        }
        if (expected.val != actual.val) {
            return false;
        }
        return areTreesEqual(expected.left, actual.left) && areTreesEqual(expected.right, actual.right);
    }

    /**
     * Helper method to build a TreeNode from an array representation.
     * The array represents the tree in level order where null indicates absence of a node.
     *
     * @param values The array of Integer values.
     * @return The root TreeNode of the constructed binary tree.
     */
    private TreeNode buildTreeFromLevelOrder(Integer[] values) {
        if (values.length == 0 || values[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(values[0]);
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (index < values.length) {
            TreeNode current = queue.poll();
            if (current != null) {
                Integer leftVal = values[index++];
                if (leftVal != null) {
                    current.left = new TreeNode(leftVal);
                    queue.offer(current.left);
                } else {
                    current.left = null;
                }
                if (index < values.length) {
                    Integer rightVal = values[index++];
                    if (rightVal != null) {
                        current.right = new TreeNode(rightVal);
                        queue.offer(current.right);
                    } else {
                        current.right = null;
                    }
                }
            }
        }
        return root;
    }

    @Test
    void testExample1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        BinaryTree binaryTree = new BinaryTree();
        TreeNode actual = binaryTree.buildTree(preorder, inorder);

        Integer[] expectedLevelOrder = {3, 9, 20, null, null, 15, 7};
        TreeNode expected = buildTreeFromLevelOrder(expectedLevelOrder);

        assertTrue(areTreesEqual(expected, actual), "The constructed tree does not match the expected tree for Example 1.");
    }

    @Test
    void testExample2() {
        int[] preorder = {-1};
        int[] inorder = {-1};

        BinaryTree binaryTree = new BinaryTree();
        TreeNode actual = binaryTree.buildTree(preorder, inorder);

        Integer[] expectedLevelOrder = {-1};
        TreeNode expected = buildTreeFromLevelOrder(expectedLevelOrder);

        assertTrue(areTreesEqual(expected, actual), "The constructed tree does not match the expected tree for Example 2.");
    }

    @Test
    void testSingleLeftChild() {
        int[] preorder = {1, 2};
        int[] inorder = {2, 1};

        BinaryTree binaryTree = new BinaryTree();
        TreeNode actual = binaryTree.buildTree(preorder, inorder);

        Integer[] expectedLevelOrder = {1, 2, null};
        TreeNode expected = buildTreeFromLevelOrder(expectedLevelOrder);

        assertTrue(areTreesEqual(expected, actual), "The constructed tree does not match the expected tree for single left child.");
    }

    @Test
    void testSingleRightChild() {
        int[] preorder = {1, 2};
        int[] inorder = {1, 2};

        BinaryTree binaryTree = new BinaryTree();
        TreeNode actual = binaryTree.buildTree(preorder, inorder);

        Integer[] expectedLevelOrder = {1, null, 2};
        TreeNode expected = buildTreeFromLevelOrder(expectedLevelOrder);

        assertTrue(areTreesEqual(expected, actual), "The constructed tree does not match the expected tree for single right child.");
    }

    @Test
    void testMultipleLevels() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};

        BinaryTree binaryTree = new BinaryTree();
        TreeNode actual = binaryTree.buildTree(preorder, inorder);

        Integer[] expectedLevelOrder = {1, 2, 3, 4, 5, 6, 7};
        TreeNode expected = buildTreeFromLevelOrder(expectedLevelOrder);

        assertTrue(areTreesEqual(expected, actual), "The constructed tree does not match the expected tree for multiple levels.");
    }

    @Test
    void testLeftSkewedTree() {
        int[] preorder = {5, 4, 3, 2, 1};
        int[] inorder = {1, 2, 3, 4, 5};

        BinaryTree binaryTree = new BinaryTree();
        TreeNode actual = binaryTree.buildTree(preorder, inorder);

        // Construct left skewed tree
        Integer[] expectedLevelOrder = {5, 4, null, 3, null, 2, null, 1};
        TreeNode expected = buildTreeFromLevelOrder(expectedLevelOrder);

        assertTrue(areTreesEqual(expected, actual), "The constructed tree does not match the expected left skewed tree.");
    }

    @Test
    void testRightSkewedTree() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};

        BinaryTree binaryTree = new BinaryTree();
        TreeNode actual = binaryTree.buildTree(preorder, inorder);

        // Construct right skewed tree
        Integer[] expectedLevelOrder = {1, null, 2, null, 3, null, 4, null, 5};
        TreeNode expected = buildTreeFromLevelOrder(expectedLevelOrder);

        assertTrue(areTreesEqual(expected, actual), "The constructed tree does not match the expected right skewed tree.");
    }

    @Test
    void testLargeTree() {
        // Construct a large tree with 1000 nodes
        int size = 1000;
        int[] preorder = new int[size];
        int[] inorder = new int[size];
        for (int i = 0; i < size; i++) {
            preorder[i] = i + 1;
            inorder[i] = i + 1;
        }

        BinaryTree binaryTree = new BinaryTree();
        TreeNode actual = binaryTree.buildTree(preorder, inorder);

        // For preorder and inorder being the same, the tree is right skewed
        // We can traverse the tree and check the structure
        TreeNode current = actual;
        for (int i = 1; i <= size; i++) {
            assertNotNull(current, "Node " + i + " should not be null.");
            assertEquals(i, current.val, "Node value mismatch at position " + i);
            current = current.right;
        }
        assertNull(current, "The last node should not have a right child.");
    }
}