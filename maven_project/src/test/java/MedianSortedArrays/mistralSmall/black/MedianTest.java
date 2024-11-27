package MedianSortedArrays.mistralSmall.black;
import MedianSortedArrays.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedianTest {

    @Test
    public void testMedian_SingleElementInSecondArray() {
        Median median = new Median();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals(2.0, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedian_EvenNumberOfElements() {
        Median median = new Median();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        assertEquals(2.5, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedian_OddNumberOfElements() {
        Median median = new Median();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals(2.0, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedian_EmptyArrays() {
        Median median = new Median();
        int[] nums1 = {};
        int[] nums2 = {};
        assertThrows(IllegalArgumentException.class, () -> {
            median.findMedianSortedArrays(nums1, nums2);
        });
    }

    @Test
    public void testMedian_AllElementsInFirstArray() {
        Median median = new Median();
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {};
        assertEquals(3.0, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedian_AllElementsInSecondArray() {
        Median median = new Median();
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3, 4, 5};
        assertEquals(3.0, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedian_LargeArrays() {
        Median median = new Median();
        int[] nums1 = {1, 3, 5, 7, 9};
        int[] nums2 = {2, 4, 6, 8, 10};
        assertEquals(5.0, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedian_NegativeNumbers() {
        Median median = new Median();
        int[] nums1 = {-1, -3};
        int[] nums2 = {-2};
        assertEquals(-2.0, median.findMedianSortedArrays(nums1, nums2));
    }
}