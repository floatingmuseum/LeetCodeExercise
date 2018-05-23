package floatingmuseum.leetcodeexercise.solutions.easy;

/**
 * Created by Floatingmuseum on 2018/5/22.
 */

public class EasySolution {

    /**
     * PASSED
     *
     * Two Sum
     *
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
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


}
