package MedianSortedArrays.gpto1Mini.black;

import MedianSortedArrays.Median;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedianTest {

    private static final double DELTA = 1e-5;

    @Test
    public void testExample1() {
        Median median = new Median();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, DELTA, "Median of [1,3] and [2] should be 2.0");
    }

    @Test
    public void testExample2() {
        Median median = new Median();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, DELTA, "Median of [1,2] and [3,4] should be 2.5");
    }

    @Test
    public void testFirstArrayEmpty() {
        Median median = new Median();
        int[] nums1 = {};
        int[] nums2 = {1};
        double expected = 1.0;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, DELTA, "Median when first array is empty should be 1.0");
    }

    @Test
    public void testSecondArrayEmpty() {
        Median median = new Median();
        int[] nums1 = {2};
        int[] nums2 = {};
        double expected = 2.0;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, DELTA, "Median when second array is empty should be 2.0");
    }

    @Test
    public void testDifferentSizesOddTotal() {
        Median median = new Median();
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4};
        double expected = 3.0;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, DELTA, "Median of [1,3,5] and [2,4] should be 3.0");
    }

    @Test
    public void testDifferentSizesEvenTotal() {
        Median median = new Median();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5};
        double expected = 3.0;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, DELTA, "Median of [1,2,3] and [4,5] should be 3.0");
    }

    @Test
    public void testWithNegativeNumbers() {
        Median median = new Median();
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-2, -4};
        double expected = -2.5;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, DELTA, "Median with negative numbers should be -2.5");
    }

    @Test
    public void testSingleElementEach() {
        Median median = new Median();
        int[] nums1 = {1};
        int[] nums2 = {2};
        double expected = 1.5;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, DELTA, "Median of [1] and [2] should be 1.5");
    }

    @Test
    public void testLargeArrays() {
        Median median = new Median();
        int[] nums1 = new int[1000];
        int[] nums2 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums1[i] = i;
            nums2[i] = i + 1000;
        }
        double expected = 999.5;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, DELTA, "Median of large arrays should be 999.5");
    }

    @Test
    public void testAllElementsSame() {
        Median median = new Median();
        int[] nums1 = {2, 2, 2};
        int[] nums2 = {2, 2, 2, 2};
        double expected = 2.0;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, DELTA, "Median when all elements are the same should be 2.0");
    }

    @Test
    public void testOneArrayMuchLarger() {
        Median median = new Median();
        int[] nums1 = {1};
        int[] nums2 = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        double expected = 5.5;
        double actual = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual, DELTA, "Median when one array is much larger should be 5.5");
    }
}