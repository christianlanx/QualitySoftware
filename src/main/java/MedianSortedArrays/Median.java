import java.lang.Math;
import java.lang.Integer;
//Leetcode Hard: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] bigger = nums1;
        int[] smaller = nums2;
        if (nums1.length < nums2.length) {
            bigger = nums2;
            smaller = nums1;
        }
        int half = (nums1.length + nums2.length) / 2;
        int left = 0;
        int right = smaller.length - 1;

        while (true) {
            double before = (double) left + (double) right;
            before /= 2;
            int i = (int) Math.floor(before);
            int j = half - i - 2;
            int smallBound = (i >= 0) ? smaller[i] : Integer.MIN_VALUE;
            int smallNext = (i + 1 < smaller.length) ? smaller[i + 1] : Integer.MAX_VALUE;
            int largeBound = (j >= 0) ? bigger[j] : Integer.MIN_VALUE;
            int largeNext = (j + 1 < bigger.length) ? bigger[j + 1] : Integer.MAX_VALUE;

            if (smallBound <= largeNext && largeBound <= smallNext) {
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return Math.min(largeNext, smallNext);
                } else {
                    return ((double) ((double) Math.min(largeNext, smallNext) + (double) Math.max(smallBound, largeBound)) / 2);
                }
            } else if (smallBound > largeNext) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
    }
}
