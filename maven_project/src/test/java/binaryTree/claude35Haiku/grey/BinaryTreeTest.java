package binaryTree.claude35Haiku.grey;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    void testBuildTree_basicScenario() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(root);
        assertEquals(3, root.val);
        
        // Left subtree
        assertNotNull(root.left);
        assertEquals(9, root.left.val);
        assertNull(root.left.left);
        assertNull(root.left.right);
        
        // Right subtree
        assertNotNull(root.right);
        assertEquals(20, root.right.val);
        
        assertNotNull(root.right.left);
        assertEquals(15, root.right.left.val);
        
        assertNotNull(root.right.right);
        assertEquals(7, root.right.right.val);
    }

    @Test
    void testBuildTree_singleNode() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(root);
        assertEquals(-1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    void testBuildTree_emptyTree() {
        int[] preorder = {};
        int[] inorder = {};
        
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNull(root);
    }

    @Test
    void testBuildTree_fullBinaryTree() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(root);
        assertEquals(1, root.val);
        
        // Verify left subtree structure
        assertNotNull(root.left);
        assertEquals(2, root.left.val);
        
        assertNotNull(root.left.left);
        assertEquals(4, root.left.left.val);
        
        assertNotNull(root.left.right);
        assertEquals(5, root.left.right.val);
        
        // Verify right subtree structure
        assertNotNull(root.right);
        assertEquals(3, root.right.val);
        
        assertNotNull(root.right.left);
        assertEquals(6, root.right.left.val);
        
        assertNotNull(root.right.right);
        assertEquals(7, root.right.right.val);
    }

    @Test
    void testBuildTree_negativeValues() {
        int[] preorder = {-10, -20, -30, -40, 0, 5};
        int[] inorder = {-30, -20, -40, -10, 0, 5};
        
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        assertNotNull(root);
        assertEquals(-10, root.val);
        
        assertNotNull(root.left);
        assertEquals(-20, root.left.val);
        
        assertNotNull(root.right);
        assertEquals(0, root.right.val);
    }

    // Helper method to perform level-order traversal for additional verification
    private List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove(0);
            result.add(node.val);
            
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        
        return result;
    }
}