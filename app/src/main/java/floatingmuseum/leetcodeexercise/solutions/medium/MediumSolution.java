package floatingmuseum.leetcodeexercise.solutions.medium;

import android.view.TextureView;

import java.lang.annotation.ElementType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;

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
     * TRYING
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
        String finalResult = "";

        Map<Integer, StringBuilder> tempResultMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);

            Iterator<Map.Entry<Integer, StringBuilder>> it = tempResultMap.entrySet().iterator();

//            long start = System.currentTimeMillis();
            while (it.hasNext()) {
                StringBuilder tempResult = it.next().getValue();
                tempResult.append(item);
//                System.out.println("it..." + i + "...start..." + tempResult);

//                boolean isReverse = false;
                StringBuilder tempBuilder = new StringBuilder(tempResult);

                if (tempResult.toString().equals(tempBuilder.reverse().toString()) && tempResult.length() > finalResult.length()) {
                    finalResult = tempResult.toString();
//                    isReverse = true;
                }

                if (i >= s.length() / 2) {
                    /**
                     * 1.如果遍历过半，开始检查map内各元素还有没有可能实现回文
                     * 2.可实现的情况下，检查其假设实现的情况下，长度是否可能超越现有finalResult的长度
                     */
                    //ABBCDEFG
                    int lastHopeLength = s.length() - i;
                    if ((tempResult.length() + lastHopeLength) < finalResult.length()) {
                        it.remove();
//                        System.out.println("it...remove..." + i);
                    }

//                    if (isReverse) {
//
//                    }
                }
            }
//            System.out.println("it..." + i + "...time:" + (System.currentTimeMillis() - start) + "..." + tempResultMap.get(i));

//            if (i == s.length() / 2) {//如果遍历过半，开始检查map内
//
//            }

            StringBuilder sb = new StringBuilder();
            sb.append(item);
            tempResultMap.put(i, sb);

        }

        if (finalResult.length() == 0) {
            return String.valueOf(s.charAt(0));
        } else {
            return finalResult;
        }
    }

    public String longestPalindromeV2(String s) {
        String finalResult = "";

        for (int i = 0; i < s.length(); i++) {
            StringBuilder tempResult = new StringBuilder();
            tempResult.append(s.charAt(i));
            long start = System.currentTimeMillis();
            for (int y = i + 1; y < s.length(); y++) {
                tempResult.append(s.charAt(y));
                StringBuilder tempReverse = new StringBuilder(tempResult);
                if (tempResult.toString().equals(tempReverse.reverse().toString()) && tempResult.length() > finalResult.length()) {
                    finalResult = tempResult.toString();
                }

                //abcdefgfedcba
                //abc
                if (i >= s.length() / 2) {
                    int lastHopeLength = s.length() - i;
                    if ((tempResult.length() + lastHopeLength) <= finalResult.length()) {
//                        System.out.println("index:" + i + "执行break");
                        break;
                    }
                }
            }
//            System.out.println("完成index:" + i + "的检查...time:" + (System.currentTimeMillis() - start) + "..." + finalResult);
        }

        if (finalResult.length() == 0) {
            return String.valueOf(s.charAt(0));
        } else {
            return finalResult;
        }
    }

    public String longestPalindromeV3(String s) {
        String finalResult = "";

        if (s.length() == 1 || s.length() == 2 && s.charAt(0) == s.charAt(1)) {
            return s;
        }

        boolean isSingular = s.length() % 2 != 0;

        for (int i = 1; i < s.length(); i++) {
            StringBuilder tempResult = new StringBuilder();
            tempResult.append(s.charAt(i));

//            int beforeIndex;
//            int afterIndex;
//            if (isSingular) {
//                beforeIndex = i - 1;
//                afterIndex = i + 1;
//            } else {
//                beforeIndex = i - 1;
//                afterIndex = i + 1;
//                if (afterIndex < s.length() && s.charAt(i) == s.charAt(afterIndex) && finalResult.length() < 2) {
//                    finalResult = tempResult.append(s.charAt(afterIndex)).toString();
//                }
//                afterIndex++;
//            }

            int beforeIndex = i - 1;
            int afterIndex = i + 1;

            while (beforeIndex >= 0 && afterIndex < s.length()) {
                char beforeChar = s.charAt(beforeIndex);
                char afterChar = s.charAt(afterIndex);

                boolean isHaveChance = false;

                if (beforeChar == afterChar) {
                    tempResult.insert(0, beforeChar);
                    tempResult.append(beforeChar);
                    beforeIndex--;
                    afterIndex++;
                    isHaveChance = true;
                } else if ((beforeIndex + 1) == i && (s.charAt(i) == beforeChar || s.charAt(i) == afterChar)) {
                    tempResult.append(s.charAt(i));
                }

                if (finalResult.length() < tempResult.length()) {
                    finalResult = tempResult.toString();
                }

                if (!isHaveChance) {
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

    public String longestPalindromeV4(String s) {
        StringBuilder checkBuilder = new StringBuilder(s);
        if (checkBuilder.reverse().toString().equals(s)){//如果字符串本身就是回文
            return s;
        }

        String finalResult = "";

        for (int i = 0; i < s.length(); i++) {

            if (finalResult.length() > s.length() / 2) {
                return finalResult;
            }

            StringBuilder tempResult = new StringBuilder();
            tempResult.append(s.charAt(i));

            int beforeIndex = i - 1;
            int afterIndex = i + 1;

            while (beforeIndex >= 0 || afterIndex < s.length()) {
                char beforeChar = 0;
                char afterChar = 0;

                if (beforeIndex >= 0) {
                    beforeChar = s.charAt(beforeIndex);
                }

                if (afterIndex < s.length()) {
                    afterChar = s.charAt(afterIndex);
                }

                if (beforeChar != 0 && afterChar != 0 && beforeChar == afterChar) {
                    tempResult.insert(0, beforeChar);
                    tempResult.append(afterChar);
                    beforeIndex--;
                } else if (afterChar != 0) {
                    tempResult.append(afterChar);
                    StringBuilder reverse = new StringBuilder(tempResult);
//                    System.out.println("!tempResult.toString().equals(reverse.toString())..." + !tempResult.toString().equals(reverse.toString()));
                    if (!tempResult.toString().equals(reverse.reverse().toString())) {
                        break;
                    }
                } else {
                    break;
                }
                afterIndex++;


                if (finalResult.length() < tempResult.length()) {
                    finalResult = tempResult.toString();
                }
            }
        }

        if (finalResult.length() == 0) {
            return String.valueOf(s.charAt(0));
        } else {
            return finalResult;
        }
    }
}
