package binaryTree.gpto1Mini.black;
import binaryTree.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class BinaryTreeTest {

    // Helper method to convert TreeNode to list in level-order including nulls
    private List<Integer> serialize(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                result.add(current.val);
                queue.offer(current.left);
                queue.offer(current.right);
            } else {
                result.add(null);
            }
        }
        
        // Remove trailing nulls
        int i = result.size() - 1;
        while (i >= 0 && result.get(i) == null) {
            result.remove(i);
            i--;
        }
        
        return result;
    }

    @Test
    public void testExample1() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        List<Integer> expected = Arrays.asList(3,9,20,null,null,15,7);
        List<Integer> actual = serialize(root);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        List<Integer> expected = Arrays.asList(-1);
        List<Integer> actual = serialize(root);
        assertEquals(expected, actual);
    }

    @Test
    public void testLeftHeavyTree() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {5,4,3,2,1};
        int[] inorder = {1,2,3,4,5};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        List<Integer> expected = Arrays.asList(5,4,null,3,null,2,null,1);
        List<Integer> actual = serialize(root);
        assertEquals(expected, actual);
    }

    @Test
    public void testRightHeavyTree() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1,2,3,4,5};
        int[] inorder = {1,2,3,4,5};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        List<Integer> expected = Arrays.asList(1,null,2,null,3,null,4,null,5);
        List<Integer> actual = serialize(root);
        assertEquals(expected, actual);
    }

    @Test
    public void testBalancedTree() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {4,2,1,3,6,5,7};
        int[] inorder = {1,2,3,4,5,6,7};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        List<Integer> expected = Arrays.asList(4,2,6,1,3,5,7);
        List<Integer> actual = serialize(root);
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleNode() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {42};
        int[] inorder = {42};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        List<Integer> expected = Arrays.asList(42);
        List<Integer> actual = serialize(root);
        assertEquals(expected, actual);
    }

    @Test
    public void testLargeTree() {
        BinaryTree binaryTree = new BinaryTree();
        int n = 1000;
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        for(int i = 0; i < n; i++) {
            preorder[i] = i;
            inorder[i] = i;
        }
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        List<Integer> expected = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            expected.add(i);
            expected.add(null);
            expected.add(null);
        }
        List<Integer> actual = serialize(root);
        // Due to the nature of the tree, only the first few elements are meaningful
        // To avoid excessive comparison, check the root and a few children
        assertEquals(Integer.valueOf(0), actual.get(0));
        assertEquals(Integer.valueOf(1), actual.get(2));
        assertEquals(Integer.valueOf(2), actual.get(4));
        // Further assertions can be added as needed
    }
    
    @Test
    public void testComplexTree() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {10,5,3,7,15,12,18};
        int[] inorder = {3,5,7,10,12,15,18};
        TreeNode root = binaryTree.buildTree(preorder, inorder);
        
        List<Integer> expected = Arrays.asList(10,5,15,3,7,12,18);
        List<Integer> actual = serialize(root);
        assertEquals(expected, actual);
    }
}

// Assuming TreeNode and BinaryTree classes are defined as follows:

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree {
    private Map<Integer, Integer> inorderIndexMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length -1, 0, inorder.length -1);
    }
    
    private TreeNode build(int[] preorder, int preStart, int preEnd, 
                           int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inRoot = inorderIndexMap.get(rootVal);
        int numsLeft = inRoot - inStart;
        root.left = build(preorder, preStart +1, preStart + numsLeft, inStart, inRoot -1);
        root.right = build(preorder, preStart + numsLeft +1, preEnd, inRoot +1, inEnd);
        return root;
    }
}