package MedianSortedArrays.gpt4oMini.white;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MedianTest {
    private Median median;

    @BeforeEach
    public void setUp() {
        median = new Median();
    }

    @Test
    public void testFindMedianSortedArrays_Example1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testFindMedianSortedArrays_Example2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testFindMedianSortedArrays_EmptyFirstArray() {
        int[] nums1 = {};
        int[] nums2 = {1};
        double expected = 1.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testFindMedianSortedArrays_EmptySecondArray() {
        int[] nums1 = {2};
        int[] nums2 = {};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testFindMedianSortedArrays_SingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        double expected = 1.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testFindMedianSortedArrays_SingleElementOdd() {
        int[] nums1 = {1};
        int[] nums2 = {2, 3, 4};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testFindMedianSortedArrays_LargeNumbers() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8, 9, 10, 11};
        double expected = 6.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testFindMedianSortedArrays_BothEmpty() {
        int[] nums1 = {};
        int[] nums2 = {};
        double expected = 0.0;  // Since the function returns a double, you may decide to assert a specific behavior.
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testFindMedianSortedArrays_EvenTotalLengthWithSameNumbers() {
        int[] nums1 = {1, 2};
        int[] nums2 = {1, 2};
        double expected = 1.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }
}