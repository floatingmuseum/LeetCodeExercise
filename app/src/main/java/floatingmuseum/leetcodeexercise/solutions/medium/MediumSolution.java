package floatingmuseum.leetcodeexercise.solutions.medium;


import android.content.IntentFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import floatingmuseum.leetcodeexercise.entity.ListNode;

/**
 * Created by Floatingmuseum on 2018/5/22.
 */

public class MediumSolution {

    /**
     * PASSED
     * <p>
     * Longest Substring Without Repeating Characters
     * <p>
     * Given a string, find the length of the longest substring without repeating characters.
     * <p>
     * Examples:
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * Given "bbbbb", the answer is "b", with the length of 1.
     * Given "pwwkew", the answer is "wke", with the length of 3.
     * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    public int lengthOfLongestSubstring(String content) {
        String finalString = "";
        StringBuilder subString = new StringBuilder("");
        for (int i = 0; i < content.length(); i++) {
            String item = String.valueOf(content.charAt(i));

            if (subString.toString().equals(item)) {
                continue;
            }

            if (subString.length() > 1) {
                if (subString.toString().contains(item)) {
                    int firstIndex = subString.toString().indexOf(item);

                    if (content.length() - (firstIndex + 1) <= finalString.length()) {
                        return finalString.length();
                    }

                    if (firstIndex == 0) {
                        subString.deleteCharAt(0);
                    } else {
                        subString.delete(0, firstIndex + 1);
                    }
                }
            }

            subString.append(item);

            if (finalString.length() < subString.length()) {
                finalString = subString.toString();
            }
        }
        return finalString.length();
    }

    /**
     * WORKING
     * <p>
     * Add Two Numbers
     * <p>
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <p>
     * Example
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return null;
    }

    /**
     * PASSED 速度一般，根据最佳答案来看，应减少字符串操作，只需要知道最长回文的前后索引，最后做一下截取就可以了
     * <p>
     * Longest Palindromic Substring
     * <p>
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * <p>
     * Example 1:
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * <p>
     * Example 2:
     * Input: "cbbd"
     * Output: "bb"
     */
    public String longestPalindrome(String s) {
        StringBuilder checkBuilder = new StringBuilder(s);
        if (checkBuilder.reverse().toString().equals(s)) {//如果字符串本身就是回文
            return s;
        }

        String finalResult = "";

        for (int i = 0; i < s.length(); i++) {

            StringBuilder tempResult = new StringBuilder();
            Character indexChar = s.charAt(i);
            tempResult.append(indexChar);

            boolean isFoundCenter = false;
            int lastCenterIndex = -1;

            int beforeIndex = i - 1;
            int afterIndex = i + 1;

            while (beforeIndex >= 0 || afterIndex < s.length()) {
                Character beforeChar = null;
                Character afterChar = null;

                if (beforeIndex >= 0) {
                    beforeChar = s.charAt(beforeIndex);
                }

                if (afterIndex < s.length()) {
                    afterChar = s.charAt(afterIndex);
                }

                if (!isFoundCenter) {
                    while (afterChar != null && afterChar == indexChar) {
                        tempResult.append(afterChar);
                        lastCenterIndex = afterIndex;
                        afterIndex++;
                        if (afterIndex < s.length()) {
                            afterChar = s.charAt(afterIndex);
                        } else {
                            break;
                        }
                    }
                    isFoundCenter = true;
                }

                boolean hasExtended = false;

                if (afterIndex < s.length()) {
                    afterChar = s.charAt(afterIndex);
                } else {
                    afterChar = null;
                }

                if (beforeChar != null && afterChar != null && beforeChar == afterChar) {
                    tempResult.insert(0, beforeChar);
                    tempResult.append(afterChar);
                    hasExtended = true;
                }

                if (finalResult.length() < tempResult.length()) {
                    finalResult = tempResult.toString();
                }

                if (hasExtended) {
                    beforeIndex--;
                    afterIndex++;
                } else {
                    //bdaadccc
                    //01234567
                    if (lastCenterIndex != -1) {
                        i = lastCenterIndex;
                    }
                    break;
                }
            }
        }

        if (finalResult.length() == 0) {
            return String.valueOf(s.charAt(0));
        } else {
            return finalResult;
        }
    }

    /**
     * PASSED
     * <p>
     * ZigZag Conversion
     * <p>
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * <p>
     * And then read line by line: "PAHNAPLSIIGYIR"
     * <p>
     * Example 1:
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * <p>
     * Example 2:
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * <p>5 3 1
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * <p>7 5 3 1
     * p   p    p
     * p  pp   p
     * p p p  p
     * pp  pp
     * p   p
     * <p>9 7 5 3 1
     * p    p    p
     * p   pp   p
     * p  p p  p
     * p p  p p
     * pp   pp
     * p    p
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder result = new StringBuilder();

        int key = numRows - 3 + numRows;

        for (int i = 0; i < numRows; i++) {

            int appendIndex = i;
            int stepKeyOne = -1;
            int stepKeyTwo = -1;

            if (i > 0 && i < numRows - 1) {
                stepKeyOne = key - i * 2;
                stepKeyTwo = key - stepKeyOne - 1;
            }

            boolean useOne = true;

            while (appendIndex < s.length()) {
                if (i == 0 || (i == numRows - 1)) {
                    result.append(s.charAt(appendIndex));
                    appendIndex += (key + 1);
                } else {
                    result.append(s.charAt(appendIndex));
                    if (useOne) {
                        appendIndex += stepKeyOne + 1;
                    } else {
                        appendIndex += stepKeyTwo + 1;
                    }
                    useOne = !useOne;
                }
            }
        }
        return result.toString();
    }

    /**
     * PASSED 效率很低
     * <p>
     * String to Integer (atoi)
     * <p>
     * Implement atoi which converts a string to an integer.
     * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
     * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as
     * possible, and interprets them as a numerical value.
     * <p>
     * The string can contain additional characters after those that form the integral number, which are ignored and have no effect
     * on the behavior of this function.
     * <p>
     * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because
     * either str is empty or it contains only whitespace characters, no conversion is performed.
     * <p>
     * If no valid conversion could be performed, a zero value is returned.
     * <p>
     * Note:
     * Only the space character ' ' is considered as whitespace character.
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
     * [INT_MIN,  INT_MAX]. If the numerical value is out of the range of representable values, INT_MAX or INT_MIN is
     * returned.
     * <p>
     * Example 1:
     * Input: "42"
     * Output: 42
     * <p>
     * Example 2:
     * Input: "   -42"
     * Output: -42
     * Explanation: The first non-whitespace character is '-', which is the minus sign.
     * Then take as many numerical digits as possible, which gets 42.
     * <p>
     * Example 3:
     * Input: "4193 with words"
     * Output: 4193
     * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
     * <p>
     * Example 4:
     * Input: "words and 987"
     * Output: 0
     * Explanation: The first non-whitespace character is 'w', which is not a numerical
     * digit or a +/- sign. Therefore no valid conversion could be performed.
     * <p>
     * Example 5:
     * Input: "-91283472332"
     * Output: -2147483648
     * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
     * Thefore INT_MIN (−231) is returned.
     */
    public int myAtoi(String str) {
        if (str == null || "".equals(str) || "-".equals(str) || "+".equals(str)) {
            return 0;
        }

//        String newStr = str.replace(" ", "");
        String newStr = str.trim();
        if (newStr.length() == 0) {
            return 0;
        }

        if (newStr.length() > 2) {
            if (newStr.startsWith("+") || newStr.startsWith("-")) {
//                System.out.println(newStr.charAt(1));
                boolean lessThanZero = newStr.charAt(1) < '0';
                boolean bigThanNine = newStr.charAt(1) > '9';
                if (lessThanZero || bigThanNine) {
                    return 0;
                }
            }
        }
        Set<Character> field = new HashSet<>();
        field.add('-');
        field.add('+');
        field.add('0');
        field.add('1');
        field.add('2');
        field.add('3');
        field.add('4');
        field.add('5');
        field.add('6');
        field.add('7');
        field.add('8');
        field.add('9');

        if (!field.contains(newStr.charAt(0))) {
            return 0;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < newStr.length(); i++) {
            char c = newStr.charAt(i);

            if (field.contains(c)) {
                result.append(c);
                if (i == 0) {
                    field.remove('-');
                    field.remove('+');
                }
            } else {
                break;
            }
        }

        try {
            return Integer.valueOf(result.toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            if (result.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    public int myAtoiV2(String str) {
        if (str == null) {
            return 0;
        }

        String newStr = str.trim();

        if (newStr.length() == 0) {
            return 0;
        }

        if (!newStr.startsWith("+") && !newStr.startsWith("-") && (newStr.charAt(0) < '0' || newStr.charAt(0) > '9')) {
            return 0;
        }

        boolean hasNegative = false;
        boolean findStartIndex = false;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < newStr.length(); i++) {
            char c = newStr.charAt(i);


            if (!findStartIndex && c != '+' && c != '-' && c > '0' && c <= '9') {
                startIndex = i;
                findStartIndex = true;
            }

            if (i == 0) {
                if (c == '-') {
                    hasNegative = true;
                }
            } else {
                if (c < '0' || c > '9') {
                    break;
                }
            }
            endIndex++;
        }

        String tempResult = newStr.substring(startIndex, endIndex);
        if (!findStartIndex) {
            return 0;
        } else {
            boolean outRangeTooMuch = tempResult.length() > 11;
            if (outRangeTooMuch) {
                if (hasNegative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }

            if (hasNegative) {
                tempResult = "-" + tempResult;
            }

            long longResult = Long.valueOf(tempResult);
            if (longResult < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (longResult > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) longResult;
            }
        }
    }

    /**
     * PASSED SLOW
     * <p>
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate
     * (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and
     * (i, 0). Find two lines, which together with x-axis forms a container, such that the container
     * contains the most water.
     * <p>
     * Note: You may not slant the container and n is at least 2.
     * <p>
     * Input: [1,8,6,2,5,4,8,3,7]
     * Output: 49
     */
    public int maxArea(int[] height) {
        int max = 0;

        if (height.length == 2) {
            max = height[0] > height[1] ? height[1] : height[0];
        } else {
            Map<Integer, Integer> data = new HashMap<>();
            for (int i = 0; i < height.length; i++) {
                int iValue = height[i];
                if (i != 0) {
                    for (Integer index : data.keySet()) {
                        int value = data.get(index);
                        int usableValue = value > iValue ? iValue : value;
                        int area = usableValue * (i - index);
                        if (area > max) {
                            max = area;
                        }
                    }
                }
                data.put(i, iValue);
            }
        }

        return max;
    }

    /**
     * PASSED
     */
    public int maxAreaV2(int[] height) {
        //1 2 3 4
        //1 2 3 4 5
        int max = 0;

        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while (leftIndex < rightIndex) {
            int leftValue = height[leftIndex];
            int rightValue = height[rightIndex];
            int lowValue = leftValue > rightValue ? rightValue : leftValue;
            int area = lowValue * (rightIndex - leftIndex);
            if (area > max) {
                max = area;
            }

            if (leftValue > rightValue) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        return max;
    }
}
