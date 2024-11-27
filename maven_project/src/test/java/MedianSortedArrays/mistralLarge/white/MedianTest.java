package MedianSortedArrays.mistralLarge.white;
import MedianSortedArrays.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MedianTest {

    @Test
    public void testFindMedianSortedArrays_OddLength() {
        Median median = new Median();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals(2.0, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testFindMedianSortedArrays_EvenLength() {
        Median median = new Median();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        assertEquals(2.5, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testFindMedianSortedArrays_EmptyArray() {
        Median median = new Median();
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        assertEquals(2.0, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testFindMedianSortedArrays_SingleElementArray() {
        Median median = new Median();
        int[] nums1 = {1};
        int[] nums2 = {2};
        assertEquals(1.5, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testFindMedianSortedArrays_LargeArrays() {
        Median median = new Median();
        int[] nums1 = {1, 3, 5, 7, 9};
        int[] nums2 = {2, 4, 6, 8, 10};
        assertEquals(5.5, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testFindMedianSortedArrays_SameArrays() {
        Median median = new Median();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3};
        assertEquals(2.0, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testFindMedianSortedArrays_NegativeNumbers() {
        Median median = new Median();
        int[] nums1 = {-1, -3, -5};
        int[] nums2 = {-2, -4, -6};
        assertEquals(-3.5, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testFindMedianSortedArrays_MixedNumbers() {
        Median median = new Median();
        int[] nums1 = {-1, 0, 1};
        int[] nums2 = {2, 3, 4};
        assertEquals(1.0, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
}