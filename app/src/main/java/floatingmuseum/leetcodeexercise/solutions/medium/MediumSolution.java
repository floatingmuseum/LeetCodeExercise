package floatingmuseum.leetcodeexercise.solutions.medium;

/**
 * Created by Floatingmuseum on 2018/5/22.
 */

public class MediumSolution {

    /**
     * PASSED
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
}
