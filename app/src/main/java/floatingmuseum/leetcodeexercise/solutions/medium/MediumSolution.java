package floatingmuseum.leetcodeexercise.solutions.medium;


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
     * PASSED 速度一般，根据最佳答案来看，应减少字符串操作，只需要知道最长回文的前后索引，最后做一些截取就可以了
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
}
