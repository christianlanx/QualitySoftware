package MedianSortedArrays.gpt35Turbo.white;
import MedianSortedArrays.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestMedian {

    @Test
    void testFindMedianSortedArrays() {
        Median median = new Median();
        
        int[] arr1 = {1, 3};
        int[] arr2 = {2};
        assertEquals(2.0, median.findMedianSortedArrays(arr1, arr2));
        
        int[] arr3 = {1, 2};
        int[] arr4 = {3, 4};
        assertEquals(2.5, median.findMedianSortedArrays(arr3, arr4));
    }
}