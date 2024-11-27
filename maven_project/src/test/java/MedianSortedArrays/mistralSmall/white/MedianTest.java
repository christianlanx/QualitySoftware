package MedianSortedArrays.mistralSmall.white;
import MedianSortedArrays.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianTest {

    @Test
    public void testMedianSortedArrays() {
        Median median = new Median();

        // Test case 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals(2.0, median.findMedianSortedArrays(nums1, nums2));

        // Test case 2
        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        assertEquals(2.5, median.findMedianSortedArrays(nums1, nums2));

        // Test case 3
        nums1 = new int[]{0, 0};
        nums2 = new int[]{0, 0};
        assertEquals(0.0, median.findMedianSortedArrays(nums1, nums2));

        // Test case 4
        nums1 = new int[]{1};
        nums2 = new int[]{2, 3};
        assertEquals(2.0, median.findMedianSortedArrays(nums1, nums2));

        // Test case 5
        nums1 = new int[]{1, 2, 3};
        nums2 = new int[]{4, 5};
        assertEquals(3.0, median.findMedianSortedArrays(nums1, nums2));

        // Test case 6
        nums1 = new int[]{1, 3, 5};
        nums2 = new int[]{2, 4, 6};
        assertEquals(3.5, median.findMedianSortedArrays(nums1, nums2));

        // Test case 7
        nums1 = new int[]{};
        nums2 = new int[]{1};
        assertEquals(1.0, median.findMedianSortedArrays(nums1, nums2));

        // Test case 8
        nums1 = new int[]{1, 3};
        nums2 = new int[]{2};
        assertEquals(2.0, median.findMedianSortedArrays(nums1, nums2));
    }
}