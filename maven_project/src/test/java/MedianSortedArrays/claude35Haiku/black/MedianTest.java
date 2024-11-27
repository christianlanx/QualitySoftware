package MedianSortedArrays.claude35Haiku.black;
import MedianSortedArrays.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MedianTest {
    private Median median;

    @BeforeEach
    void setUp() {
        median = new Median();
    }

    @Test
    void testEqualLengthArrays() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals(2.0, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    void testDifferentLengthArrays() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        assertEquals(2.5, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    void testEmptyFirstArray() {
        int[] nums1 = {};
        int[] nums2 = {1};
        assertEquals(1.0, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    void testEmptySecondArray() {
        int[] nums1 = {2};
        int[] nums2 = {};
        assertEquals(2.0, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    void testBothEmptyArrays() {
        int[] nums1 = {};
        int[] nums2 = {};
        assertThrows(IllegalArgumentException.class, 
            () -> median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testLargeNumbers() {
        int[] nums1 = {-1000000, 1000000};
        int[] nums2 = {-500000, 500000};
        assertEquals(0.0, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    void testOddTotalLength() {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        assertEquals(3.5, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    void testEvenTotalLength() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4, 5, 6};
        assertEquals(3.5, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    void testSingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        assertEquals(1.5, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    void testNegativeNumbers() {
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-4, -2, 0};
        assertEquals(-2.5, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
}