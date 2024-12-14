package binaryTree.ai21Jamba15Large.black;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import binaryTree.BinaryTree;
import binaryTree.BinaryTree.TreeNode;

public class BinaryTreeTest {
    
    @Test
    void testBuildTreeExample1() {
        // given
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        
        // when
        TreeNode root = BinaryTree.buildTree(preorder, inorder);
        
        // then
        assertEquals(3, root.val);
        assertEquals(9, root.left.val);
        assertEquals(20, root.right.val);
        assertEquals(15, root.right.left.val);
        assertEquals(7, root.right.right.val);
    }
    
    @Test
    void testBuildTreeExample2() {
        // given
        int[] preorder = {-1};
        int[] inorder = {-1};
        
        // when
        TreeNode root = BinaryTree.buildTree(preorder, inorder);
        
        // then
        assertEquals(-1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }
    
    @ParameterizedTest
    @MethodSource("testCases")
    void testBuildTree(int[] preorder, int[] inorder, TreeNode expectedTree) {
        // given
        
        // when
        TreeNode actualTree = BinaryTree.buildTree(preorder, inorder);
        
        // then
        assertEquals(expectedTree, actualTree);
    }
    
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(
                new int[] {3, 9, 20, 15, 7},
                new int[] {9, 3, 15, 20, 7},
                createTree(3, 9, 20, null, null, 15, 7)
            ),
            Arguments.of(
                new int[] {-1},
                new int[] {-1},
                createTree(-1)
            )
        );
    }
    
    private static TreeNode createTree(Integer... values) {
        if (values == null || values.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.remove();
            if (values[i] != null) {
                node.left = new TreeNode(values[i]);
                queue.add(node.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                node.right = new TreeNode(values[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}