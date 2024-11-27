package MedianSortedArrays.gpt35Turbo.black;
import MedianSortedArrays.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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

}