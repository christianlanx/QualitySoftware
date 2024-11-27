package MedianSortedArrays.gpt4oMini.black;
import MedianSortedArrays.*;

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
    public void testExample1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testExample2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testSingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        double expected = 1.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testEmptyArray() {
        int[] nums1 = {};
        int[] nums2 = {1};
        double expected = 1.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testTwoEmptyArrays() {
        int[] nums1 = {};
        int[] nums2 = {};
        double expected = 0.0; // Assuming 0.0 or handle it as undefined
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testNegativeAndPositiveNumbers() {
        int[] nums1 = {-3, -1};
        int[] nums2 = {1, 2};
        double expected = -1.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testAllNegativeNumbers() {
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-4, -2};
        double expected = -3.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testLargeInputs() {
        int[] nums1 = new int[1000];
        int[] nums2 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums1[i] = i;
            nums2[i] = i + 1000;
        }
        double expected = 999.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testUnevenLengthArrays() {
        int[] nums1 = {1, 3, 8};
        int[] nums2 = {7, 9, 10, 11};
        double expected = 8.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }
}