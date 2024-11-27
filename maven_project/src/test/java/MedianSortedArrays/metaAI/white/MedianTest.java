package MedianSortedArrays.metaAI.white;
import MedianSortedArrays.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedianTest {

    private Median median = new Median();

    @Test
    public void testFindMedianSortedArrays_Example1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testFindMedianSortedArrays_Example2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testFindMedianSortedArrays_SingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        double expected = 1.5;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testFindMedianSortedArrays_SameArrays() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3};
        double expected = 2.0;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testFindMedianSortedArrays_EmptyArray() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {};
        double expected = 2.0;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testFindMedianSortedArrays_OddLength() {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4};
        double expected = 3.0;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testFindMedianSortedArrays_EvenLength() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        double expected = 2.5;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, 0.001);
    }
}