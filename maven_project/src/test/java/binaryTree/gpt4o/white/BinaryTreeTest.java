package binaryTree.gpt4o.white;

import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void testNullTree() {
        BinaryTree binaryTree = new BinaryTree();
        assertNull(binaryTree.buildTree(new int[]{}, new int[]{}), "Expected null tree for empty inputs.");
    }

    @Test
    public void testSingleNodeTree() {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode result = binaryTree.buildTree(new int[]{1}, new int[]{1});
        assertNotNull(result, "Expected non-null tree for single node input.");
        assertEquals(1, result.val, "Root value does not match expected.");
        assertNull(result.left, "Expected no left child for single node tree.");
        assertNull(result.right, "Expected no right child for single node tree.");
    }

    @Test
    public void testBinaryTree() {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode result = binaryTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        assertNotNull(result, "Expected non-null tree for valid input.");
        assertEquals(3, result.val, "Root value does not match expected.");
        
        // Validate left subtree
        assertNotNull(result.left, "Expected left child for root.");
        assertEquals(9, result.left.val, "Left child value does not match expected.");
        assertNull(result.left.left, "Expected no left child.");
        assertNull(result.left.right, "Expected no right child.");
        
        // Validate right subtree
        assertNotNull(result.right, "Expected right child for root.");
        assertEquals(20, result.right.val, "Right child value does not match expected.");
        
        assertNotNull(result.right.left, "Expected left child for right child of root.");
        assertEquals(15, result.right.left.val, "Left child of right subtree does not match expected.");
        
        assertNotNull(result.right.right, "Expected right child for right child of root.");
        assertEquals(7, result.right.right.val, "Right child of right subtree does not match expected.");
    }

    @Test
    public void testLeftSkewedTree() {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode result = binaryTree.buildTree(new int[]{4, 3, 2, 1}, new int[]{1, 2, 3, 4});
        
        assertNotNull(result, "Expected non-null tree for valid input.");
        assertEquals(4, result.val, "Root value does not match expected.");
        
        assertNotNull(result.left, "Expected left child for root.");
        assertEquals(3, result.left.val, "Left child value does not match expected.");
        
        assertNotNull(result.left.left, "Expected left child for left child of root.");
        assertEquals(2, result.left.left.val, "Left child of left child does not match expected.");
        
        assertNotNull(result.left.left.left, "Expected left child for left child of left child.");
        assertEquals(1, result.left.left.left.val, "Leftmost child value does not match expected.");
        
        assertNull(result.right, "Expected no right child for left skewed tree.");
    }

    @Test
    public void testRightSkewedTree() {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode result = binaryTree.buildTree(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        
        assertNotNull(result, "Expected non-null tree for valid input.");
        assertEquals(1, result.val, "Root value does not match expected.");
        
        assertNotNull(result.right, "Expected right child for root.");
        assertEquals(2, result.right.val, "Right child value does not match expected.");
        
        assertNotNull(result.right.right, "Expected right child for right child of root.");
        assertEquals(3, result.right.right.val, "Right child of right child does not match expected.");
        
        assertNotNull(result.right.right.right, "Expected right child for right child of right child.");
        assertEquals(4, result.right.right.right.val, "Rightmost child value does not match expected.");
        
        assertNull(result.left, "Expected no left child for right skewed tree.");
    }
}