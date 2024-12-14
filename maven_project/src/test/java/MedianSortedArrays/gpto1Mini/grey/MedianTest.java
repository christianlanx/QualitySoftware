package MedianSortedArrays.gpto1Mini.grey;

import MedianSortedArrays.Median;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MedianTest {

    private final Median medianFinder = new Median();

    @Test
    void testExample1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 2.0");
    }

    @Test
    void testExample2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 2.5");
    }

    @Test
    void testEmptyFirstArray() {
        int[] nums1 = {};
        int[] nums2 = {1};
        double expected = 1.0;
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 1.0");
    }

    @Test
    void testEmptySecondArray() {
        int[] nums1 = {2};
        int[] nums2 = {};
        double expected = 2.0;
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 2.0");
    }

    @Test
    void testBothArraysEmpty() {
        int[] nums1 = {};
        int[] nums2 = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            medianFinder.findMedianSortedArrays(nums1, nums2);
        });
        String expectedMessage = "At least one array must be non-empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage), "Exception message should indicate that both arrays are empty");
    }

    @Test
    void testSingleElementEach() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        double expected = 1.5;
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 1.5");
    }

    @Test
    void testDifferentLengths() {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6};
        double expected = 4.0;
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 4.0");
    }

    @Test
    void testNegativeNumbers() {
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-2, -4, -6};
        double expected = -3.0;
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be -3.0");
    }

    @Test
    void testLargeNumbers() {
        int[] nums1 = {1000000};
        int[] nums2 = {1000001};
        double expected = 1000000.5;
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 1000000.5");
    }

    @Test
    void testDuplicateElements() {
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {2, 2, 3};
        double expected = 2.0;
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 2.0");
    }

    @Test
    void testAllElementsSame() {
        int[] nums1 = {2, 2, 2};
        int[] nums2 = {2, 2, 2};
        double expected = 2.0;
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 2.0");
    }

    @Test
    void testOneArrayMuchLarger() {
        int[] nums1 = {1};
        int[] nums2 = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        double expected = 5.5;
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001, "Median should be 5.5");
    }
}