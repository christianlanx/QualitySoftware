package binaryTree.gpt4o.black;

import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    @Test
    public void testExample1() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode expected = new TreeNode(3);
        expected.left = new TreeNode(9);
        expected.right = new TreeNode(20);
        expected.right.left = new TreeNode(15);
        expected.right.right = new TreeNode(7);

        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertTrue(isSameTree(expected, result));
    }

    @Test
    public void testExample2() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {-1};
        int[] inorder = {-1};

        TreeNode expected = new TreeNode(-1);

        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertTrue(isSameTree(expected, result));
    }

    @Test
    public void testWithSingleNode() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1};
        int[] inorder = {1};

        TreeNode expected = new TreeNode(1);

        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertTrue(isSameTree(expected, result));
    }

    @Test
    public void testWithTwoNodes() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1,2};
        int[] inorder = {1,2};

        TreeNode expected = new TreeNode(1);
        expected.right = new TreeNode(2);

        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertTrue(isSameTree(expected, result));
    }

    @Test
    public void testWithLeftSkewedTree() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {3,2,1};
        int[] inorder = {1,2,3};

        TreeNode expected = new TreeNode(3);
        expected.left = new TreeNode(2);
        expected.left.left = new TreeNode(1);

        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertTrue(isSameTree(expected, result));
    }

    @Test
    public void testWithRightSkewedTree() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1,2,3};
        int[] inorder = {1,2,3};

        TreeNode expected = new TreeNode(1);
        expected.right = new TreeNode(2);
        expected.right.right = new TreeNode(3);

        TreeNode result = binaryTree.buildTree(preorder, inorder);
        assertTrue(isSameTree(expected, result));
    }
}