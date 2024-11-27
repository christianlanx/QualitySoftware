package MedianSortedArrays.claude35Sonnet.black;
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
    void testFindMedianWithOddTotalLength() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals(2.0, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFindMedianWithEvenTotalLength() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        assertEquals(2.5, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFindMedianWithEmptyFirstArray() {
        int[] nums1 = {};
        int[] nums2 = {1};
        assertEquals(1.0, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFindMedianWithEmptySecondArray() {
        int[] nums1 = {1};
        int[] nums2 = {};
        assertEquals(1.0, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFindMedianWithNegativeNumbers() {
        int[] nums1 = {-5, -3};
        int[] nums2 = {-2, -1};
        assertEquals(-2.5, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFindMedianWithDuplicateNumbers() {
        int[] nums1 = {1, 1, 3};
        int[] nums2 = {1, 2, 3};
        assertEquals(1.5, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFindMedianWithLargeNumbers() {
        int[] nums1 = {100000};
        int[] nums2 = {100001};
        assertEquals(100000.5, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFindMedianWithSingleElementArrays() {
        int[] nums1 = {2};
        int[] nums2 = {1};
        assertEquals(1.5, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFindMedianWithDifferentSizeArrays() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8};
        assertEquals(4.5, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFindMedianWithMaxSizeArrays() {
        int[] nums1 = new int[1000];
        int[] nums2 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums1[i] = i * 2;
            nums2[i] = i * 2 + 1;
        }
        assertEquals(999.5, median.findMedianSortedArrays(nums1, nums2));
    }
}