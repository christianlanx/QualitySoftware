package MedianSortedArrays.gpt4o.black;

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
        double result = medianCalculator.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testExample2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        double result = medianCalculator.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testSingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {3};
        double expected = 2.0;
        double result = medianCalculator.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testEmptyAndNonEmptyArray() {
        int[] nums1 = {};
        int[] nums2 = {2, 3};
        double expected = 2.5;
        double result = medianCalculator.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testAllNegativeValues() {
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-4, -2};
        double expected = -3.0;
        double result = medianCalculator.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testVaryingSizeArrays() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8, 9, 10, 11};
        double expected = 6.0;
        double result = medianCalculator.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testLargeRangeValues() {
        int[] nums1 = {-1000000, 0};
        int[] nums2 = {1000000};
        double expected = 0.0;
        double result = medianCalculator.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }
}