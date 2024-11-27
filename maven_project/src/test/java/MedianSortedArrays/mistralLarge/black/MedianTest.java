package MedianSortedArrays.mistralLarge.black;
import MedianSortedArrays.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedianTest {

    @Test
    public void testExample1() {
        Median median = new Median();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.00000;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testExample2() {
        Median median = new Median();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.50000;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testEmptyArray1() {
        Median median = new Median();
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        double expected = 2.00000;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testEmptyArray2() {
        Median median = new Median();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {};
        double expected = 2.00000;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testBothEmptyArrays() {
        Median median = new Median();
        int[] nums1 = {};
        int[] nums2 = {};
        assertThrows(IllegalArgumentException.class, () -> {
            median.findMedianSortedArrays(nums1, nums2);
        });
    }

    @Test
    public void testSingleElementArrays() {
        Median median = new Median();
        int[] nums1 = {1};
        int[] nums2 = {2};
        double expected = 1.50000;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testLargeArrays() {
        Median median = new Median();
        int[] nums1 = new int[1000];
        int[] nums2 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums1[i] = i + 1;
            nums2[i] = i + 1001;
        }
        double expected = 1500.50000;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testNegativeValues() {
        Median median = new Median();
        int[] nums1 = {-1, -3};
        int[] nums2 = {-2};
        double expected = -2.00000;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testMixedValues() {
        Median median = new Median();
        int[] nums1 = {-1, 0, 3};
        int[] nums2 = {1, 2};
        double expected = 1.00000;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }
}