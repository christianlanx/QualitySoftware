package binaryTree.gpt4o.grey;

import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinaryTreeTest {

    private boolean compareTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }
        return compareTrees(t1.left, t2.left) && compareTrees(t1.right, t2.right);
    }

    @Test
    void testExample1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BinaryTree solution = new BinaryTree();
        TreeNode expected = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode result = solution.buildTree(preorder, inorder);
        assertTrue(compareTrees(expected, result));
    }

    @Test
    void testExample2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        BinaryTree solution = new BinaryTree();
        TreeNode expected = new TreeNode(-1);
        TreeNode result = solution.buildTree(preorder, inorder);
        assertTrue(compareTrees(expected, result));
    }

    @Test
    void testSingleElement() {
        int[] preorder = {42};
        int[] inorder = {42};
        BinaryTree solution = new BinaryTree();
        TreeNode expected = new TreeNode(42);
        TreeNode result = solution.buildTree(preorder, inorder);
        assertTrue(compareTrees(expected, result));
    }

    @Test
    void testTwoElements() {
        int[] preorder = {1, 2};
        int[] inorder = {2, 1};
        BinaryTree solution = new BinaryTree();
        TreeNode expected = new TreeNode(1, new TreeNode(2), null);
        TreeNode result = solution.buildTree(preorder, inorder);
        assertTrue(compareTrees(expected, result));
    }

    @Test
    void testUnbalancedTreeRight() {
        int[] preorder = {1, 3, 5, 7};
        int[] inorder = {1, 3, 5, 7};
        BinaryTree solution = new BinaryTree();
        TreeNode expected = new TreeNode(1, null, 
                         new TreeNode(3, null, 
                         new TreeNode(5, null, 
                         new TreeNode(7))));
        TreeNode result = solution.buildTree(preorder, inorder);
        assertTrue(compareTrees(expected, result));
    }

    @Test
    void testUnbalancedTreeLeft() {
        int[] preorder = {7, 5, 3, 1};
        int[] inorder = {1, 3, 5, 7};
        BinaryTree solution = new BinaryTree();
        TreeNode expected = new TreeNode(7, 
                          new TreeNode(5, 
                          new TreeNode(3, 
                          new TreeNode(1), null), null), null);
        TreeNode result = solution.buildTree(preorder, inorder);
        assertTrue(compareTrees(expected, result));
    }
}