package MedianSortedArrays.gpto1Mini.black;
import MedianSortedArrays.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MedianTest {

    private final Median median = new Median();

    @Test
    void testExample1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5, "Median of [1,3] and [2] should be 2.0");
    }

    @Test
    void testExample2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5, "Median of [1,2] and [3,4] should be 2.5");
    }

    @Test
    void testOneEmptyArray1() {
        int[] nums1 = {};
        int[] nums2 = {1};
        double expected = 1.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5, "Median of [] and [1] should be 1.0");
    }

    @Test
    void testOneEmptyArray2() {
        int[] nums1 = {2};
        int[] nums2 = {};
        double expected = 2.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5, "Median of [2] and [] should be 2.0");
    }

    @Test
    void testBothEmptyArrays() {
        int[] nums1 = {};
        int[] nums2 = {};
        // Depending on implementation, this might throw an exception.
        // Here we assume it returns 0.0
        double expected = 0.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5, "Median of [] and [] should be 0.0");
    }

    @Test
    void testSingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        double expected = 1.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5, "Median of [1] and [2] should be 1.5");
    }

    @Test
    void testDifferentSizes1() {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6, 8, 10};
        double expected = 5.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5, "Median should be 5.0");
    }

    @Test
    void testDifferentSizes2() {
        int[] nums1 = {0, 0};
        int[] nums2 = {0, 0};
        double expected = 0.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5, "Median should be 0.0");
    }

    @Test
    void testNegativeNumbers() {
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-2, -4};
        // Combined sorted array: [-5, -4, -3, -2, -1]
        double expected = -3.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5, "Median should be -3.0");
    }

    @Test
    void testDuplicates() {
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {2, 2, 3};
        // Combined sorted array: [1,2,2,2,2,3]
        double expected = 2.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5, "Median should be 2.0");
    }

    @Test
    void testLargeArrays() {
        int[] nums1 = new int[1000];
        int[] nums2 = new int[1000];
        for(int i = 0; i < 1000; i++) {
            nums1[i] = i;
            nums2[i] = i + 1000;
        }
        // Combined array has 2000 elements, median is (999 + 1000)/2 = 999.5
        double expected = 999.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5, "Median should be 999.5");
    }
}