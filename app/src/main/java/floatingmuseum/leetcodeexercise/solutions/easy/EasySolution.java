package floatingmuseum.leetcodeexercise.solutions.easy;

import android.content.SyncStatusObserver;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Floatingmuseum on 2018/5/22.
 */

public class EasySolution {

    /**
     * PASSED
     * <p>
     * Two Sum
     * <p>
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            throw new IllegalArgumentException("nums too short.");
        }

        for (int x = 0; x < nums.length; x++) {
            int y = x + 1;
            while (true) {
                if ((nums[x] + nums[y]) == target) {
                    return new int[]{x, y};
                }
                if (++y == nums.length) {
                    break;
                }
            }
            if ((x + 1) == nums.length) {
                break;
            }
        }
        throw new IllegalArgumentException("no solution.");
    }

    /**
     * PASSED
     * <p>
     * Reverse Integer
     * <p>
     * Given a 32-bit signed integer, reverse digits of an integer.
     * <p>
     * Example 1:
     * Input: 123
     * Output: 321
     * <p>
     * Example 2:
     * Input: -123
     * Output: -321
     * <p>
     * Example 3:
     * Input: 120
     * Output: 21
     * <p>
     * Note:
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
     * [Math.pow(-2,31),  Math.pow(2,31)-1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
     */
    public int reverseInteger(int x) {
        if (x % 10 == x) {
            return x;
        }

        int finalValue = 0;
        int tempValue = 0;
        while (x % 10 != x) {
            int num = x % 10;
            finalValue = (finalValue + num) * 10;
            if (finalValue / 10 - num != tempValue) {
                //out of range
                return 0;
            }
            tempValue = finalValue;
            x /= 10;
        }

        finalValue += x;

        return finalValue;
    }

    /**
     * PASSED
     *
     * <p>
     * Example 1:
     * <p>
     * Input: 121
     * Output: true
     * Example 2:
     * <p>
     * Input: -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     * Example 3:
     * <p>
     * Input: 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     * Follow up:
     * <p>
     * Could you solve it without converting the integer to a string?
     */
    public boolean palindromeNumber(int x) {
        boolean isPalindrome = false;

        if (x == 0 || (x > 0 && x < 10)) {
            isPalindrome = true;
        } else if (x >= 10) {
            List<Integer> data = new ArrayList<>();
            do {
                //获得个位数
                int z = x % 10;
                data.add(z);
                x = x / 10;
            } while (x > 0);
            int compareSize = data.size() / 2;
            for (int i = 0; i < compareSize; i++) {
                if (data.get(i).equals(data.get(data.size() - (i + 1)))) {
                    isPalindrome = true;
                } else {
                    isPalindrome = false;
                    break;
                }
            }
        }

        return isPalindrome;
    }

    /**
     * PASSED
     */
    public boolean palindromeNumberV2(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
