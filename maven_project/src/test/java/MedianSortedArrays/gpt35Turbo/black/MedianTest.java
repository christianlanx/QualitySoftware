package MedianSortedArrays.gpt35Turbo.black;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import MedianSortedArrays.Median;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianTest {

    @Nested
    class findMedianSortedArraysTests {

        Median median;

        @BeforeEach
        void setUp() {
            median = new Median();
        }

        @Test
        void testExample1() {
            int[] nums1 = {1, 3};
            int[] nums2 = {2};
            assertEquals(2.00000, median.findMedianSortedArrays(nums1, nums2));
        }

        @Test
        void testExample2() {
            int[] nums1 = {1, 2};
            int[] nums2 = {3, 4};
            assertEquals(2.50000, median.findMedianSortedArrays(nums1, nums2));
        }

        @Test
        void testEmptyArrays() {
            int[] nums1 = {};
            int[] nums2 = {};
            assertEquals(0.0, median.findMedianSortedArrays(nums1, nums2));
        }

    }
}