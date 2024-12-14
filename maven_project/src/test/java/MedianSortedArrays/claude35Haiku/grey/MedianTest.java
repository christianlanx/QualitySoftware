package MedianSortedArrays.claude35Haiku.grey;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MedianTest {
    private Median median;

    @BeforeEach
    void setUp() {
        median = new Median();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testFindMedianSortedArrays(int[] nums1, int[] nums2, double expectedMedian) {
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expectedMedian, result, 0.00001);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            // Basic test cases from problem description
            arguments(new int[]{1, 3}, new int[]{2}, 2.00000),
            arguments(new int[]{1, 2}, new int[]{3, 4}, 2.50000),

            // Edge cases
            arguments(new int[]{}, new int[]{1}, 1.00000),
            arguments(new int[]{2}, new int[]{}, 2.00000),

            // Larger arrays
            arguments(new int[]{1, 3, 5}, new int[]{2, 4, 6}, 3.50000),

            // Arrays with negative numbers
            arguments(new int[]{-5, -3, -1}, new int[]{-2, 0, 2}, -1.50000),

            // Arrays of different lengths
            arguments(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8}, 4.50000),

            // Large range of numbers
            arguments(new int[]{-100000, 0, 100000}, new int[]{-50000, 50000}, 0.00000)
        );
    }

    @Test
    void testSingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        assertEquals(1.50000, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    void testLargeArrays() {
        int[] nums1 = new int[1000];
        int[] nums2 = new int[1000];
        
        // Populate arrays with sequential numbers
        for (int i = 0; i < 1000; i++) {
            nums1[i] = i;
            nums2[i] = i + 1000;
        }
        
        assertEquals(999.50000, median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
}