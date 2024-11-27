package MedianSortedArrays.gpt4o.white;
import MedianSortedArrays.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedianTest {

    private final Median medianFinder = new Median();

    @Test
    void testFindMedianSortedArrays_EvenTotalLength() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        double expected = 2.5;
        assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2), "The median of [1, 3] and [2, 4] should be 2.5");
    }
    
    @Test
    void testFindMedianSortedArrays_OddTotalLength() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3};
        double expected = 2.0;
        assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2), "The median of [1, 2] and [3] should be 2.0");
    }

    @Test
    void testFindMedianSortedArrays_EmptyFirstArray() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3, 4};
        double expected = 2.5;
        assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2), "The median of [] and [1, 2, 3, 4] should be 2.5");
    }

    @Test
    void testFindMedianSortedArrays_EmptySecondArray() {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {};
        double expected = 2.5;
        assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2), "The median of [1, 2, 3, 4] and [] should be 2.5");
    }
    
    @Test
    void testFindMedianSortedArrays_EqualElements() {
        int[] nums1 = {2, 2};
        int[] nums2 = {2, 2};
        double expected = 2.0;
        assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2), "The median of [2, 2] and [2, 2] should be 2.0");
    }

    @Test
    void testFindMedianSortedArrays_SingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        double expected = 1.5;
        assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2), "The median of [1] and [2] should be 1.5");
    }
    
    @Test
    void testFindMedianSortedArrays_VaryingLengths() {
        int[] nums1 = {1, 5, 8, 10};
        int[] nums2 = {2, 3};
        double expected = 3.5;
        assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2), "The median of [1, 5, 8, 10] and [2, 3] should be 3.5");
    }
}