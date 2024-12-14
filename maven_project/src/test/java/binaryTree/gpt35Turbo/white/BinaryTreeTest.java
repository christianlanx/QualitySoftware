package binaryTree.gpt35Turbo.white;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import binaryTree.BinaryTree;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    void testBuildTree_Example1() {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertEquals(3, root.val);
        assertEquals(9, root.left.val);
        assertEquals(20, root.right.val);
        assertEquals(15, root.right.left.val);
        assertEquals(7, root.right.right.val);
    }

    @Test
    void testBuildTree_EmptyInput() {
        int[] preorder = {};
        int[] inorder = {};

        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertEquals(null, root);
    }

    // Add more test cases as needed

}