package MedianSortedArrays.gpt4o.grey;

import MedianSortedArrays.Median;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianTest {

    private final Median medianCalculator = new Median();

    @Test
    public void testExample1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        assertEquals(expected, medianCalculator.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testExample2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        assertEquals(expected, medianCalculator.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testSingleElementArrays() {
        int[] nums1 = {3};
        int[] nums2 = {5};
        double expected = 4.0;
        assertEquals(expected, medianCalculator.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testDifferentSizedArrays() {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {5, 6, 7, 8, 9};
        double expected = 5.0;
        assertEquals(expected, medianCalculator.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testNegativeValues() {
        int[] nums1 = {-3, -1};
        int[] nums2 = {-2};
        double expected = -2.0;
        assertEquals(expected, medianCalculator.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testEmptyAndNonEmptyArray1() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3, 4, 5};
        double expected = 3.0;
        assertEquals(expected, medianCalculator.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testEmptyAndNonEmptyArray2() {
        int[] nums1 = {1};
        int[] nums2 = {};
        double expected = 1.0;
        assertEquals(expected, medianCalculator.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testLongArrays() {
        int[] nums1 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int[] nums2 = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
        double expected = 9.5;
        assertEquals(expected, medianCalculator.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testEdgeCaseLargeValues() {
        int[] nums1 = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
        int[] nums2 = {Integer.MIN_VALUE + 1, Integer.MAX_VALUE - 1};
        double expected = 0.0;
        assertEquals(expected, medianCalculator.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
}