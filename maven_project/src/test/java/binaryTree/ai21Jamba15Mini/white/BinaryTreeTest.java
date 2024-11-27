package binaryTree.ai21Jamba15Mini.white;
import binaryTree.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class BinaryTreeTest {

    private BinaryTree.TreeNode root;

    @BeforeEach
    public void setUp() {
        // Initialize your test data here
    }

    @Test
    public void testBuildTree_EmptyPreorder() {
        int[] preorder = {};
        int[] inorder = {};
        root = BinaryTree.buildTree(preorder, inorder);
        // Assert the expected structure of the empty tree
    }

    @Test
    public void testBuildTree_SingleNode() {
        int[] preorder = {1};
        int[] inorder = {1};
        root = BinaryTree.buildTree(preorder, inorder);
        // Assert the single node tree structure
    }

    @Test
    public void testBuildTree_SimpleTree() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {2, 1, 3};
        root = BinaryTree.buildTree(preorder, inorder);
        // Assert the structure of the simple tree
    }

    @Test
    public void testBuildTree_ComplexTree() {
        int[] preorder = {1, 2, 3, 4, 5, 6};
        int[] inorder = {2, 4, 1, 6, 3, 5};
        root = BinaryTree.buildTree(preorder, inorder);
        // Assert the structure of the complex tree
    }

    @Test
    public void testBuildTree_DuplicateValues() {
        int[] preorder = {1, 2, 2, 3};
        int[] inorder = {2, 1, 3};
        root = BinaryTree.buildTree(preorder, inorder);
        // Assert the structure considering duplicate values
    }

    // Add more test cases as needed to cover different scenarios
}