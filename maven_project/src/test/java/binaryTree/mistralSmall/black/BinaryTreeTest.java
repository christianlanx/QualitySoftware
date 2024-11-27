package binaryTree.mistralSmall.black;
import binaryTree.*;
import binaryTree.BinaryTree.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class BinaryTreeTest {

    @Test
    void testBuildTreeExample1() {
        BinaryTree bt = new BinaryTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = bt.buildTree(preorder, inorder);

        assertNotNull(root);
        assertEquals(3, root.val);
        assertEquals(9, root.left.val);
        assertEquals(20, root.right.val);
        assertEquals(15, root.right.left.val);
        assertEquals(7, root.right.right.val);
    }

    @Test
    void testBuildTreeExample2() {
        BinaryTree bt = new BinaryTree();
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode root = bt.buildTree(preorder, inorder);

        assertNotNull(root);
        assertEquals(-1, root.val);
    }

    // Additional tests can be added here to cover edge cases and other scenarios
}