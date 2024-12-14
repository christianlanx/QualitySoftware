package MedianSortedArrays.gpt4oMini.black;

import MedianSortedArrays.Median;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianTest {

    private final Median median = new Median();

    @Test
    public void testMedianWithOddTotalElements() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.0, result, 0.00001);
    }

    @Test
    public void testMedianWithEvenTotalElements() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.5, result, 0.00001);
    }

    @Test
    public void testMedianWithFirstArrayEmpty() {
        int[] nums1 = {};
        int[] nums2 = {1};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(1.0, result, 0.00001);
    }

    @Test
    public void testMedianWithSecondArrayEmpty() {
        int[] nums1 = {2};
        int[] nums2 = {};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.0, result, 0.00001);
    }

    @Test
    public void testMedianWithNegativeAndPositiveNumbers() {
        int[] nums1 = {1, 3};
        int[] nums2 = {-1, 2};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(1.0, result, 0.00001);
    }

    @Test
    public void testMedianWithSameNumbers() {
        int[] nums1 = {1, 1};
        int[] nums2 = {1, 1};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(1.0, result, 0.00001);
    }

    @Test
    public void testMedianWithLargeNumbers() {
        int[] nums1 = {100000};
        int[] nums2 = {100001, 100002};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(100001.0, result, 0.00001);
    }

    @Test
    public void testMedianWithLargeArrays() {
        int[] nums1 = new int[1000];
        int[] nums2 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums1[i] = i;
            nums2[i] = 1000 + i;
        }
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(999.5, result, 0.00001);
    }
}