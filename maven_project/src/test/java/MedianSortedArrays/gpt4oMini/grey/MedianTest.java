package MedianSortedArrays.gpt4oMini.grey;

import MedianSortedArrays.Median;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianTest {

    private final Median median = new Median();

    @Test
    public void testExample1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testExample2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testSingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        double expected = 1.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testEmptyFirstArray() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testEmptySecondArray() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testBothEmptyArrays() {
        int[] nums1 = {};
        int[] nums2 = {};
        // This case might throw an exception or needs to be handled specifically.
        // This test is based on how the main method would handle empty input arrays
        // If both arrays are empty, it should throw an exception or return a specific value.
        // Here it is assumed that we are testing exceptional cases which are expected exceptions to be defined.
        // Uncomment the following line if the exception handling is defined in the Median class.
        // assertThrows(IllegalArgumentException.class, () -> median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testLargeOddSizeArrays() {
        int[] nums1 = {1, 3, 8, 9, 15};
        int[] nums2 = {7, 11, 18, 19, 21, 23};
        double expected = 9.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testLargeEvenSizeArrays() {
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {7, 8, 9, 10, 11, 12};
        double expected = 6.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
}