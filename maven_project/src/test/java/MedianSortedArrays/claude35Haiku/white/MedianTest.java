package MedianSortedArrays.claude35Haiku.white;
import MedianSortedArrays.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class MedianTest {
    private Median median;

    @BeforeEach
    void setUp() {
        median = new Median();
    }

    @Test
    void testEvenLengthArrays() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        assertEquals(2.5, median.findMedianSortedArrays(nums1, nums2), 0.0001);
    }

    @Test
    void testOddLengthArrays() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4, 5};
        assertEquals(3.0, median.findMedianSortedArrays(nums1, nums2), 0.0001);
    }

    @Test
    void testEmptyFirstArray() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3, 4, 5};
        assertEquals(3.0, median.findMedianSortedArrays(nums1, nums2), 0.0001);
    }

    @Test
    void testEmptySecondArray() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {};
        assertEquals(3.0, median.findMedianSortedArrays(nums1, nums2), 0.0001);
    }

    @Test
    void testBothEmptyArrays() {
        int[] nums1 = {};
        int[] nums2 = {};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> 
            median.findMedianSortedArrays(nums1, nums2)
        );
    }

    @Test
    void testSingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        assertEquals(1.5, median.findMedianSortedArrays(nums1, nums2), 0.0001);
    }

    @Test
    void testLargeArrays() {
        int[] nums1 = {1, 3, 5, 7, 9};
        int[] nums2 = {2, 4, 6, 8, 10};
        assertEquals(5.5, median.findMedianSortedArrays(nums1, nums2), 0.0001);
    }

    @Test
    void testUnsortedInput() {
        int[] nums1 = {3, 1, 4};
        int[] nums2 = {2, 6, 5};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> 
            median.findMedianSortedArrays(nums1, nums2)
        );
    }

    @Test
    void testNegativeNumbers() {
        int[] nums1 = {-3, -1, 0};
        int[] nums2 = {-2, 1, 2};
        assertEquals(-0.5, median.findMedianSortedArrays(nums1, nums2), 0.0001);
    }

    @Test
    void testDifferentLengthArrays() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4, 5, 6};
        assertEquals(3.5, median.findMedianSortedArrays(nums1, nums2), 0.0001);
    }
}