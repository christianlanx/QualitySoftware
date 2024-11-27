package MedianSortedArrays.claude35Sonnet.white;
import MedianSortedArrays.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MedianTest {
    private final Median median = new Median();

    @Test
    void testEvenLengthArrays() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        assertEquals(2.5, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testOddLengthArrays() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals(2.0, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testEmptyFirstArray() {
        int[] nums1 = {};
        int[] nums2 = {1};
        assertEquals(1.0, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testEmptySecondArray() {
        int[] nums1 = {2};
        int[] nums2 = {};
        assertEquals(2.0, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testLargerArrays() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8, 9, 10};
        assertEquals(5.5, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testOverlappingArrays() {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};
        assertEquals(4.5, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testSingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        assertEquals(1.5, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testArraysWithDuplicates() {
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {3, 3, 4};
        assertEquals(2.5, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testArraysWithNegativeNumbers() {
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {2, 4, 6};
        assertEquals(0.5, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testUnequalSizeArrays() {
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {7, 8};
        assertEquals(4.5, median.findMedianSortedArrays(nums1, nums2));
    }
}