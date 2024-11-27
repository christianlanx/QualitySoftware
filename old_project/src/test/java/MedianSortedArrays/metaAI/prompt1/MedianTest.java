package MedianSortedArrays.metaAI.prompt1;
import MedianSortedArrays.Median;

import org.junit.Test;
import static org.junit.Assert.*;

public class MedianTest {

    Median median = new Median();

    @Test
    public void testExample1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testExample2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testEmptyArray1() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testEmptyArray2() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testSameArray() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testLargeArray() {
        int[] nums1 = new int[1000];
        int[] nums2 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums1[i] = i;
            nums2[i] = i;
        }
        double expected = 499.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
}