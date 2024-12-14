package MedianSortedArrays.gpto1Mini.black;

import MedianSortedArrays.Median;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MedianTest {

    private final Median median = new Median();

    @Test
    void testExample1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 2.0");
    }

    @Test
    void testExample2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 2.5");
    }

    @Test
    void testBothEmpty() {
        int[] nums1 = {};
        int[] nums2 = {};
        assertThrows(IllegalArgumentException.class, () -> {
            median.findMedianSortedArrays(nums1, nums2);
        }, "Should throw IllegalArgumentException when both arrays are empty");
    }

    @Test
    void testOneEmptyFirst() {
        int[] nums1 = {};
        int[] nums2 = {1};
        double expected = 1.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 1.0");
    }

    @Test
    void testOneEmptySecond() {
        int[] nums1 = {2};
        int[] nums2 = {};
        double expected = 2.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 2.0");
    }

    @Test
    void testDifferentLengths() {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6};
        double expected = 4.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 4.0");
    }

    @Test
    void testNegativeNumbers() {
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-2, -4};
        double expected = -2.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be -2.5");
    }

    @Test
    void testSingleElementEach() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        double expected = 1.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 1.5");
    }

    @Test
    void testLargeArrays() {
        int[] nums1 = new int[1000];
        int[] nums2 = new int[1000];
        for(int i = 0; i < 1000; i++) {
            nums1[i] = i;
            nums2[i] = i + 1000;
        }
        double expected = 999.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 999.5");
    }
}