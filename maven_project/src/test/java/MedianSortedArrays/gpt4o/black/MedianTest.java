package MedianSortedArrays.gpt4o.black;
import MedianSortedArrays.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MedianTest {
    
    private final Median medianFinder = new Median();
    
    @Test
    public void testFindMedianSortedArrays_case1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
    
    @Test
    public void testFindMedianSortedArrays_case2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
    
    @Test
    public void testFindMedianSortedArrays_bothEmpty() {
        int[] nums1 = {};
        int[] nums2 = {};
        Exception exception = null;
        try {
            medianFinder.findMedianSortedArrays(nums1, nums2);
        } catch (Exception e) {
            exception = e;
        }
        assertEquals(IllegalArgumentException.class, exception.getClass());
    }
    
    @Test
    public void testFindMedianSortedArrays_firstEmpty() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3, 4, 5};
        double expected = 3.0;
        assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
    
    @Test
    public void testFindMedianSortedArrays_secondEmpty() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {};
        double expected = 3.0;
        assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
    
    @Test
    public void testFindMedianSortedArrays_largeNumbers() {
        int[] nums1 = {1000000};
        int[] nums2 = {-1000000};
        double expected = 0.0;
        assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
    
    @Test
    public void testFindMedianSortedArrays_negativeNumbers() {
        int[] nums1 = {-3, -2, -1};
        int[] nums2 = {-7, -5};
        double expected = -3.0;
        assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testFindMedianSortedArrays_identicalElements() {
        int[] nums1 = {2, 2, 2};
        int[] nums2 = {2, 2, 2};
        double expected = 2.0;
        assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
    
    @Test
    public void testFindMedianSortedArrays_singleElementEach() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        double expected = 1.5;
        assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
    
    @Test
    public void testFindMedianSortedArrays_oneArrayLongerThanOther() {
        int[] nums1 = {1, 3, 5, 7, 9};
        int[] nums2 = {2, 4, 6};
        double expected = 4.5;
        assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
}