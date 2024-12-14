package MedianSortedArrays.ai21Jamba15Large.black;

import static org.junit.jupiter.api.Assertions.assertEquals;

import MedianSortedArrays.Median;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MedianTest {

    private Median medianFinder = new Median();

    @Test
    void testWithEmptyArrays() {
        int[] nums1 = {};
        int[] nums2 = {};
        double expectedMedian = 0.0;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testWithSingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        double expectedMedian = 1.5;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testWithExample1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expectedMedian = 2.0;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testWithExample2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expectedMedian = 2.5;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 3, 2",
        "1, 2, 3, 4, 2.5",
        "0, 0, 0, 0, 0.0",
        "1, 2, 3, 4, 5, 3.0",
        "1, 3, 2, 4, 2.5",
        "2, 3, 1, 4, 2.5"
    })
    void testWithVariousInputs(int[] nums1, int[] nums2, double expectedMedian) {
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testWithLargeInput() {
        int[] nums1 = {1, 3, 5, 7, 9};
        int[] nums2 = {2, 4, 6, 8, 10};
        double expectedMedian = 5.5;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2));
    }
}