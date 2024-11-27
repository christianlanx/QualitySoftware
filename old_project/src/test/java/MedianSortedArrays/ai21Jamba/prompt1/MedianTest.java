package MedianSortedArrays.ai21Jamba.prompt1;
import MedianSortedArrays.Median;

import org.junit.Assert;
import org.junit.Test;

public class MedianTest {

    @Test
    public void testMedianOfTwoSortedArrays_Example1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.00000;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_Example2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.50000;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_EmptyArray() {
        int[] nums1 = {};
        int[] nums2 = {1};
        double expected = 1.00000;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_SingleElementArray() {
        int[] nums1 = {2};
        int[] nums2 = {};
        double expected = 2.00000;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_EqualSizeArrays() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        double expected = 2.50000;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_DifferentSizeArrays() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6, 7};
        double expected = 3.50000;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_LargeArrays() {
        int[] nums1 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int[] nums2 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        double expected = 11.00000;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_LargeUnevenArrays() {
        int[] nums1 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
        int[] nums2 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22};
        double expected = 12.00000;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_NegativeNumbers() {
        int[] nums1 = {-1, 3};
        int[] nums2 = {2, 4};
        double expected = 2.00000;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_NegativeAndPositiveNumbers() {
        int[] nums1 = {-5, -1, 3};
        int[] nums2 = {2, 4};
        double expected = 2.00000;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_DuplicateElements() {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        double expected = 1.50000;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(expected, actual, 0.00001);
    }
}