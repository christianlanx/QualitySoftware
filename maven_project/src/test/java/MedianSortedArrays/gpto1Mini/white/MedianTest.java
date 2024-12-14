package MedianSortedArrays.gpto1Mini.white;

import MedianSortedArrays.Median;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedianTest {

    @Test
    void testBothArraysEmpty() {
        Median median = new Median();
        int[] nums1 = {};
        int[] nums2 = {};
        assertThrows(IllegalArgumentException.class, () -> {
            median.findMedianSortedArrays(nums1, nums2);
        });
    }

    @Test
    void testFirstArrayEmpty() {
        Median median = new Median();
        int[] nums1 = {};
        int[] nums2 = {1};
        double expected = 1.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testSecondArrayEmpty() {
        Median median = new Median();
        int[] nums1 = {2, 3, 4};
        int[] nums2 = {};
        double expected = 3.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testBothArraysOddTotal() {
        Median median = new Median();
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        double expected = 3.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testBothArraysEvenTotal() {
        Median median = new Median();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testArraysWithDuplicates() {
        Median median = new Median();
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {2, 3, 4};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testArraysWithNegativeNumbers() {
        Median median = new Median();
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-2, -1, 0};
        double expected = -1.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testDifferentLengthArrays() {
        Median median = new Median();
        int[] nums1 = {1, 3, 8, 9, 15};
        int[] nums2 = {7, 11, 18, 19, 21, 25};
        double expected = 11.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testSingleElementArrays() {
        Median median = new Median();
        int[] nums1 = {1};
        int[] nums2 = {2};
        double expected = 1.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testLargeArrays() {
        Median median = new Median();
        int[] nums1 = new int[1000];
        int[] nums2 = new int[1000];
        for(int i = 0; i < 1000; i++) {
            nums1[i] = i;
            nums2[i] = i + 1000;
        }
        double expected = 999.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }
}