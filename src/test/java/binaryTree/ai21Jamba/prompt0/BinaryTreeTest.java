package binaryTree.ai21Jamba.prompt0;
import binaryTree.BinaryTree;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testBuildTree() {
        BinaryTree binaryTree = new BinaryTree();

        // Test case 1: Simple binary tree
        int[] preorder1 = {1, 2, 4, 5, 3, 6};
        int[] inorder1 = {4, 2, 5, 1, 6, 3};
        List<Integer> expectedValues1 = List.of(1, 2, 4, 5, 3, 6);
        assertEquals(expectedValues1, traverseTree(binaryTree.buildTree(preorder1, inorder1)));

        // Test case 2: Single node tree
        int[] preorder2 = {1};
        int[] inorder2 = {1};
        List<Integer> expectedValues2 = List.of(1);
        assertEquals(expectedValues2, traverseTree(binaryTree.buildTree(preorder2, inorder2)));

        // Test case 3: Empty tree
        int[] preorder3 = {};
        int[] inorder3 = {};
        assertEquals(List.of(), traverseTree(binaryTree.buildTree(preorder3, inorder3)));

        // Test case 4: Larger tree
        int[] preorder4 = {1, 2, 3, 4, 5, 6, 7};
        int[] inorder4 = {4, 2, 5, 1, 6, 3, 7};
        List<Integer> expectedValues4 = List.of(1, 2, 3, 4, 5, 6, 7);
        assertEquals(expectedValues4, traverseTree(binaryTree.buildTree(preorder4, inorder4)));
    }

    private List<Integer> traverseTree(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        traverse(root, values);
        return values;
    }

    private void traverse(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        values.add(node.val);
        traverse(node.left, values);
        traverse(node.right, values);
    }
}