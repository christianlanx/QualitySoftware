package MedianSortedArrays.gpt35Turbo.white;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MedianSortedArrays.Median;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianTest {

    private Median median;

    @BeforeEach
    void setUp() {
        median = new Median();
    }

    @Test
    void testFindMedianSortedArrays_oddLengthArrays() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFindMedianSortedArrays_evenLengthArrays() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFindMedianSortedArrays_emptyArray() {
        int[] nums1 = {};
        int[] nums2 = {1};
        double expected = 1.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }
}