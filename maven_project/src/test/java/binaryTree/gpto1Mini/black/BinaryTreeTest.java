package binaryTree.gpto1Mini.black;

import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void testBuildTreeExample1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        
        BinaryTree.TreeNode expected = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        
        BinaryTree.TreeNode actual = new BinaryTree().buildTree(preorder, inorder);
        assertTrue(areTreesEqual(expected, actual), "The constructed tree does not match the expected tree for Example 1.");
    }

    @Test
    void testBuildTreeExample2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        
        BinaryTree.TreeNode expected = new TreeNode(-1);
        
        BinaryTree.TreeNode actual = new BinaryTree().buildTree(preorder, inorder);
        assertTrue(areTreesEqual(expected, actual), "The constructed tree does not match the expected tree for Example 2.");
    }

    @Test
    void testBuildTreeSingleNode() {
        int[] preorder = {1};
        int[] inorder = {1};
        
        BinaryTree.TreeNode expected = new TreeNode(1);
        
        BinaryTree.TreeNode actual = new BinaryTree().buildTree(preorder, inorder);
        assertTrue(areTreesEqual(expected, actual), "The constructed tree does not match the expected tree for a single node.");
    }

    @Test
    void testBuildTreeLeftSkewed() {
        int[] preorder = {4, 3, 2, 1};
        int[] inorder = {1, 2, 3, 4};
        
        BinaryTree.TreeNode expected = new TreeNode(4,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1),
                                null),
                        null),
                null);
        
        BinaryTree.TreeNode actual = new BinaryTree().buildTree(preorder, inorder);
        assertTrue(areTreesEqual(expected, actual), "The constructed tree does not match the expected left-skewed tree.");
    }

    @Test
    void testBuildTreeRightSkewed() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {1, 2, 3, 4};
        
        BinaryTree.TreeNode expected = new TreeNode(1,
                null,
                new TreeNode(2,
                        null,
                        new TreeNode(3,
                                null,
                                new TreeNode(4))));
        
        BinaryTree.TreeNode actual = new BinaryTree().buildTree(preorder, inorder);
        assertTrue(areTreesEqual(expected, actual), "The constructed tree does not match the expected right-skewed tree.");
    }

    @Test
    void testBuildTreeComplex() {
        int[] preorder = {5, 3, 2, 4, 8, 7, 9};
        int[] inorder = {2, 3, 4, 5, 7, 8, 9};
        
        BinaryTree.TreeNode expected = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2),
                        new TreeNode(4)),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)));
        
        BinaryTree.TreeNode actual = new BinaryTree().buildTree(preorder, inorder);
        assertTrue(areTreesEqual(expected, actual), "The constructed tree does not match the expected complex tree.");
    }

    /**
     * Helper method to compare two binary trees for equality.
     *
     * @param expected The expected tree node.
     * @param actual The actual tree node.
     * @return true if both trees are identical in structure and node values, false otherwise.
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
}