package MedianSortedArrays.ai21Jamba15Mini.black;
import MedianSortedArrays.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedianTest {

    @Test
    void testMedian_Example1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    void testMedian_Example2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    void testMedian_EmptyNums1() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        double expected = 2.0;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    void testMedian_EmptyNums2() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {};
        double expected = 2.0;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    void testMedian_BothEmpty() {
        int[] nums1 = {};
        int[] nums2 = {};
        double expected = 0.0;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    void testMedian_LargeArrays() {
        int[] nums1 = {1, 3, 5, 7, 9};
        int[] nums2 = {2, 4, 6, 8, 10};
        double expected = 5.0;
        double actual = new Median().findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, 0.00001);
    }
}