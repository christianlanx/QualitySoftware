package MedianSortedArrays.ai21Jamba.prompt0;
import MedianSortedArrays.Median;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MedianTest {

    @Test
    public void testFindMedianSortedArrays() {
        Median median = new Median();

        // Test case 1: Both arrays are empty
        int[] nums1_1 = {};
        int[] nums2_1 = {};
        assertEquals(0.0, median.findMedianSortedArrays(nums1_1, nums2_1), 0.0);

        // Test case 2: One array is empty
        int[] nums1_2 = {1};
        int[] nums2_2 = {};
        assertEquals(1.0, median.findMedianSortedArrays(nums1_2, nums2_2), 0.0);

        // Test case 3: Both arrays have one element each
        int[] nums1_3 = {1};
        int[] nums2_3 = {2};
        assertEquals(1.5, median.findMedianSortedArrays(nums1_3, nums2_3), 0.0);

        // Test case 4: Arrays of different lengths
        int[] nums1_4 = {1, 3};
        int[] nums2_4 = {2};
        assertEquals(2.0, median.findMedianSortedArrays(nums1_4, nums2_4), 0.0);

        // Test case 5: Arrays of different lengths with repeated elements
        int[] nums1_5 = {1, 2};
        int[] nums2_5 = {2, 3};
        assertEquals(2.0, median.findMedianSortedArrays(nums1_5, nums2_5), 0.0);

        // Test case 6: Arrays of different lengths with odd total length
        int[] nums1_6 = {1, 3, 5};
        int[] nums2_6 = {2, 4};
        assertEquals(3.0, median.findMedianSortedArrays(nums1_6, nums2_6), 0.0);

        // Test case 7: Arrays of different lengths with even total length
        int[] nums1_7 = {1, 2, 3, 4};
        int[] nums2_7 = {5, 6, 7, 8};
        assertEquals(4.5, median.findMedianSortedArrays(nums1_7, nums2_7), 0.0);

        // Test case 8: Larger arrays
        int[] nums1_8 = {1, 3, 5, 7, 9};
        int[] nums2_8 = {2, 4, 6, 8, 10};
        assertEquals(5.5, median.findMedianSortedArrays(nums1_8, nums2_8), 0.0);

        // Test case 9: Arrays with negative numbers
        int[] nums1_9 = {-1, 3, 5};
        int[] nums2_9 = {2, 4};
        assertEquals(3.0, median.findMedianSortedArrays(nums1_9, nums2_9), 0.0);

        // Test case 10: Arrays with duplicate elements
        int[] nums1_10 = {1, 1, 2, 2, 2};
        int[] nums2_10 = {2, 2, 2, 3, 3};
        assertEquals(2.0, median.findMedianSortedArrays(nums1_10, nums2_10), 0.0);
    }
}