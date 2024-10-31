package MedianSortedArrays.chatGPT4o.prompt0;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import MedianSortedArrays.Median;

public class MedianSortedArrays {

    private Median medianFinder;

    @Before
    public void setUp() {
        medianFinder = new Median();
    }

    @Test
    public void testOddTotalLength() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testEvenTotalLength() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.5, result, 0.0001);
    }

    @Test
    public void testSingleElementEach() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(1.5, result, 0.0001);
    }

    @Test
    public void testEmptyAndSingleElement() {
        int[] nums1 = {};
        int[] nums2 = {1};
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(1.0, result, 0.0001);
    }

    @Test
    public void testEmptyArrays() {
        int[] nums1 = {};
        int[] nums2 = {};
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertTrue(Double.isNaN(result)); // Adjust this based on expected behavior if handling empty input arrays
    }

    @Test
    public void testIdenticalArrays() {
        int[] nums1 = {1, 1, 1};
        int[] nums2 = {1, 1, 1};
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(1.0, result, 0.0001);
    }

    @Test
    public void testNegativeNumbers() {
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-2, 0, 2};
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(-1.5, result, 0.0001);
    }

    @Test
    public void testDifferentSizes() {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6};
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(4.0, result, 0.0001);
    }

    @Test
    public void testSingleArray() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {};
        double result = medianFinder.findMedianSortedArrays(nums1, nums2);
        assertEquals(3.0, result, 0.0001);
    }
}

