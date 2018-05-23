package floatingmuseum.leetcodeexercise.solutions.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Floatingmuseum on 2018/5/22.
 */

public class HardSolution {

    /**
     * PASSED
     * <p>
     * Median of Two Sorted Arrays
     * <p>
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     * <p>
     * Example 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * The median is 2.0
     * <p>
     * Example 2:
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * The median is (2 + 3)/2 = 2.5
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Index = 0;
        int nums2Index = 0;
        List<Integer> totalNum = new ArrayList<>();

        while (true) {
            if (nums1Index == nums1.length && nums2Index == nums2.length) {
                break;
            } else if (nums1Index == nums1.length) {
                for (int i = nums2Index; i < nums2.length; i++) {
                    totalNum.add(nums2[i]);
                }
                break;
            } else if (nums2Index == nums2.length) {
                for (int i = nums1Index; i < nums1.length; i++) {
                    totalNum.add(nums1[i]);
                }
                break;
            }

            int nums1Value = nums1[nums1Index];
            int nums2Value = nums2[nums2Index];

            if (nums1Value == nums2Value) {
                totalNum.add(nums1Value);
                totalNum.add(nums2Value);
                nums1Index++;
                nums2Index++;
            } else if (nums1Value < nums2Value) {
                totalNum.add(nums1Value);
                nums1Index++;
            } else {
                totalNum.add(nums2Value);
                nums2Index++;
            }
        }

        if (totalNum.size() == 1) {
            return totalNum.get(0);
        }

        if (totalNum.size() % 2 == 0) {
            return ((double) (totalNum.get(totalNum.size() / 2 - 1) + totalNum.get(totalNum.size() / 2))) / 2;
        } else {
            return (double) totalNum.get(totalNum.size() / 2);
        }
    }

    public double findMedianSortedArraysV2(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums3, 0, nums1.length);
        System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);

        Arrays.sort(nums3);

        if (nums3.length == 1) {
            return nums3[0];
        }

        if (nums3.length % 2 == 0) {
            return ((double) (nums3[nums3.length / 2 - 1] + nums3[nums3.length / 2])) / 2;
        } else {
            return (double) (nums3[nums3.length / 2] / 2);
        }
    }
}
