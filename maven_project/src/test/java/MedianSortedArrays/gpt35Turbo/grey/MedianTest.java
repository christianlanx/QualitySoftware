package MedianSortedArrays.gpt35Turbo.grey;

import MedianSortedArrays.Median;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianTest {

    private static Median median;

    @BeforeAll
    public static void setUp() {
        median = new Median();
    }

    @Test
    public void testMedian1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result);
    }

    @Test
    public void testMedian2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result);
    }

    @Test
    public void testMedianEmptyArray() {
        int[] nums1 = {};
        int[] nums2 = {2};
        double expected = 2.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result);
    }
}