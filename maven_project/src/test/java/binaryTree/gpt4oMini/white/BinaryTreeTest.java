package binaryTree.gpt4oMini.white;
import binaryTree.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BinaryTreeTest {
    
    private BinaryTree binaryTree;

    @BeforeEach
    public void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    public void testBuildTree_SimpleTree() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        
        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertArrayEquals(new int[] {root.val, root.left.val, root.right.val, 
                                      root.right.left.val, root.right.right.val}, 
                          new int[] {3, 9, 20, 15, 7});
    }

    @Test
    public void testBuildTree_OnlyLeftChild() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {3, 2, 1};

        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertArrayEquals(new int[] {root.val, root.left.val, root.left.left.val}, 
                          new int[] {1, 2, 3});
    }

    @Test
    public void testBuildTree_OnlyRightChild() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {1, 2, 3};

        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertArrayEquals(new int[] {root.val, root.right.val, root.right.right.val}, 
                          new int[] {1, 2, 3});
    }

    @Test
    public void testBuildTree_EmptyTree() {
        int[] preorder = {};
        int[] inorder = {};

        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertArrayEquals(new int[] {}, toArray(root));
    }

    @Test
    public void testBuildTree_SingleNode() {
        int[] preorder = {1};
        int[] inorder = {1};

        BinaryTree.TreeNode root = binaryTree.buildTree(preorder, inorder);

        assertArrayEquals(new int[] {root.val}, new int[] {1});
    }

    private int[] toArray(BinaryTree.TreeNode node) {
        if (node == null) return new int[]{};
        return new int[]{node.val,
                         toArray(node.left),
                         toArray(node.right)};
    }
}