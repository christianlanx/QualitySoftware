package MedianSortedArrays.metaAI.prompt0;
import MedianSortedArrays.Median;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MedianTest {

    Median median = new Median();

    // Test even-length arrays
    @Test
    public void testEvenLength() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        assertEquals(2.5, median.findMedianSortedArrays(nums1, nums2), 0.001);

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        assertEquals(2.5, median.findMedianSortedArrays(nums3, nums4), 0.001);
    }

    // Test odd-length arrays
    @Test
    public void testOddLength() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals(2, median.findMedianSortedArrays(nums1, nums2), 0.001);

        int[] nums3 = {1};
        int[] nums4 = {2, 3};
        assertEquals(2, median.findMedianSortedArrays(nums3, nums4), 0.001);
    }

    // Test edge cases
    @Test
    public void testEdgeCases() {
        int[] nums1 = {};
        int[] nums2 = {1};
        assertEquals(1, median.findMedianSortedArrays(nums1, nums2), 0.001);

        int[] nums3 = {1};
        int[] nums4 = {};
        assertEquals(1, median.findMedianSortedArrays(nums3, nums4), 0.001);

        int[] nums5 = {1, 2};
        int[] nums6 = {};
        assertEquals(1.5, median.findMedianSortedArrays(nums5, nums6), 0.001);
    }

    // Test duplicate elements
    @Test
    public void testDuplicates() {
        int[] nums1 = {1, 1};
        int[] nums2 = {1, 1};
        assertEquals(1, median.findMedianSortedArrays(nums1, nums2), 0.001);

        int[] nums3 = {1, 2};
        int[] nums4 = {2, 2};
        assertEquals(2, median.findMedianSortedArrays(nums3, nums4), 0.001);
    }

    // Test large arrays
    @Test
    public void testLargeArrays() {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};
        assertEquals(4.5, median.findMedianSortedArrays(nums1, nums2), 0.001);

        int[] nums3 = {1, 2, 3, 4};
        int[] nums4 = {5, 6, 7, 8};
        assertEquals(4.5, median.findMedianSortedArrays(nums3, nums4), 0.001);
    }
}