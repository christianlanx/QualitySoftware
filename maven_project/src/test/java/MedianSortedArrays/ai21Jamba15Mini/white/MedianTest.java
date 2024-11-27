package MedianSortedArrays.ai21Jamba15Mini.white;
import MedianSortedArrays.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedianTest {

    @Test
    void testFindMedianSortedArrays_EmptyArrays() {
        int[] nums1 = {};
        int[] nums2 = {};
        assertEquals(0.0, new Median().findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFindMedianSortedArrays_SingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        assertEquals(1.5, new Median().findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFindMedianSortedArrays_EvenLengthArrays() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        assertEquals(2.5, new Median().findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFindMedianSortedArrays_OddLengthArrays() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5};
        assertEquals(3.0, new Median().findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testFindMedianSortedArrays_LargeArrays() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8, 9, 10};
        assertEquals(5.5, new Median().findMedianSortedArrays(nums1, nums2));
    }
}