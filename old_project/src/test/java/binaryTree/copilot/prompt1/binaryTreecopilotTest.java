package binaryTree.copilot.prompt1;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;

public class binaryTreecopilotTest {

    @Test
    public void testBuildTree_Example1() {
        BinaryTree solution = new BinaryTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode expected = new TreeNode(3);
        expected.left = new TreeNode(9);
        expected.right = new TreeNode(20);
        expected.right.left = new TreeNode(15);
        expected.right.right = new TreeNode(7);
        TreeNode result = solution.buildTree(preorder, inorder);
        assertEquals(treeToString(expected), treeToString(result));
    }

    @Test
    public void testBuildTree_Example2() {
        BinaryTree solution = new BinaryTree();
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode expected = new TreeNode(-1);
        TreeNode result = solution.buildTree(preorder, inorder);
        assertEquals(treeToString(expected), treeToString(result));
    }

    private String treeToString(TreeNode node) {
        if (node == null) {
            return "null";
        }
        String left = node.left != null ? treeToString(node.left) : "null";
        String right = node.right != null ? treeToString(node.right) : "null";
        return node.val + "," + left + "," + right;
    }
}



