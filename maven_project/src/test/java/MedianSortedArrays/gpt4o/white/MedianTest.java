package MedianSortedArrays.gpt4o.white;
import MedianSortedArrays.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MedianTest {

    @Test
    void testFindMedianSortedArrays() {
        Median median = new Median();

        // Test case 1: Basic test with even total elements
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), "Test case 1 failed");

        // Test case 2: Basic test with odd total elements
        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        expected = 2.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), "Test case 2 failed");

        // Test case 3: One array is empty
        nums1 = new int[]{};
        nums2 = new int[]{1};
        expected = 1.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), "Test case 3 failed");

        // Test case 4: Both arrays are empty
        nums1 = new int[]{};
        nums2 = new int[]{};
        assertThrows(IllegalArgumentException.class, () -> {
            median.findMedianSortedArrays(nums1, nums2);
        }, "Test case 4 failed");

        // Test case 5: Arrays with equal length and elements
        nums1 = new int[]{1, 2};
        nums2 = new int[]{1, 2};
        expected = 1.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), "Test case 5 failed");

        // Test case 6: Simple case with different lengths
        nums1 = new int[]{1, 2, 3};
        nums2 = new int[]{4, 5};
        expected = 3.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), "Test case 6 failed");

        // Test case 7: Another mixed size arrays
        nums1 = new int[]{1, 3, 5};
        nums2 = new int[]{2, 4, 6};
        expected = 3.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), "Test case 7 failed");
    }
}