package binaryTree.chatGPT4o.prompt0;
import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;
import static org.junit.Assert.*;
import org.junit.Test;
public class binaryTreechatGPT4oTest {
    /* 
   @Test
    public void testBuildTreeEmptyArrays() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {};
        int[] inorder = {};
        BinaryTree.TreeNode expected = null;
        BinaryTree.TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(areTreesEqual(expected, actual));
    }

    @Test
    public void testBuildTreeSingleNode() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTree.TreeNode expected = new BinaryTree.TreeNode(1);
        BinaryTree.TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(areTreesEqual(expected, actual));
    }

    @Test
    public void testBuildTreeSimpleTree() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1, 2, 3};
        int[] inorder = {2, 1, 3};

        BinaryTree.TreeNode expected = new BinaryTree.TreeNode(1);
        expected.left = new BinaryTree.TreeNode(2);
        expected.right = new BinaryTree.TreeNode(3);

        BinaryTree.TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(areTreesEqual(expected, actual));
    }

    @Test
    public void testBuildTreeComplexTree() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        BinaryTree.TreeNode expected = new BinaryTree.TreeNode(3);
        expected.left = new BinaryTree.TreeNode(9);
        expected.right = new BinaryTree.TreeNode(20);
        expected.right.left = new BinaryTree.TreeNode(15);
        expected.right.right = new BinaryTree.TreeNode(7);

        BinaryTree.TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(areTreesEqual(expected, actual));
    }

    @Test
    public void testBuildTreeUnbalancedTree() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1, 2, 4, 5, 3};
        int[] inorder = {4, 2, 5, 1, 3};

        BinaryTree.TreeNode expected = new BinaryTree.TreeNode(1);
        expected.left = new BinaryTree.TreeNode(2);
        expected.left.left = new BinaryTree.TreeNode(4);
        expected.left.right = new BinaryTree.TreeNode(5);
        expected.right = new BinaryTree.TreeNode(3);

        BinaryTree.TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(areTreesEqual(expected, actual));
    }

    @Test
    public void testBuildTreeSkewedLeftTree() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {5, 4, 3, 2, 1};
        int[] inorder = {1, 2, 3, 4, 5};

        BinaryTree.TreeNode expected = new BinaryTree.TreeNode(5);
        expected.left = new BinaryTree.TreeNode(4);
        expected.left.left = new BinaryTree.TreeNode(3);
        expected.left.left.left = new BinaryTree.TreeNode(2);
        expected.left.left.left.left = new BinaryTree.TreeNode(1);

        BinaryTree.TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(areTreesEqual(expected, actual));
    }

    @Test
    public void testBuildTreeSkewedRightTree() {
        BinaryTree binaryTree = new BinaryTree();
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};

        BinaryTree.TreeNode expected = new BinaryTree.TreeNode(1);
        expected.right = new BinaryTree.TreeNode(2);
        expected.right.right = new BinaryTree.TreeNode(3);
        expected.right.right.right = new BinaryTree.TreeNode(4);
        expected.right.right.right.right = new BinaryTree.TreeNode(5);

        BinaryTree.TreeNode actual = binaryTree.buildTree(preorder, inorder);
        assertTrue(areTreesEqual(expected, actual));
    }*/

    /* 
     * Helper method to compare two binary trees for equality.
     * Trees are equal if they have the same structure and node values.
     *
     * @param t1 the first tree to compare
     * @param t2 the second tree to compare
     * @return true if the trees are equal, false otherwise
     */
    
    private boolean areTreesEqual(BinaryTree.TreeNode t1, BinaryTree.TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val &&
               areTreesEqual(t1.left, t2.left) &&
               areTreesEqual(t1.right, t2.right);
    }
    
}
