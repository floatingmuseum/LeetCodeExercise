package floatingmuseum.leetcodeexercise;

import org.junit.Test;

import floatingmuseum.leetcodeexercise.solutions.easy.EasySolution;

/**
 * Created by Floatingmuseum on 2018/5/25.
 */

public class EasySolutionTest {

    private EasySolution solution = new EasySolution();

    private void print(String content) {
        System.out.println(content);
    }

    @Test
    public void testTwoSum() {
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);//expect [0,1]
        for (int i : result) {
            print(result[i] + "");
        }
    }

    @Test
    public void testReverseInteger() {
        print("result1:" + solution.reverseInteger(123));//expect 123
        print("result1:" + solution.reverseInteger(-123));//expect -321
        print("result1:" + solution.reverseInteger(120));//expect 21
        print("result1:" + solution.reverseInteger(1534236469));//expect 0
    }

    @Test
    public void testPalindromeNumber() {
//        print("test...123::" + solution.palindromeNumberV2(123));//expect false
//        print("test...-121:" + solution.palindromeNumberV2(-121));//expect false
//        print("test...0:" + solution.palindromeNumberV2(0));//expect true
//        print("test...121:" + solution.palindromeNumberV2(121));//expect true
//        print("test...9:" + solution.palindromeNumberV2(9));//expect false
        print("test...9:" + solution.palindromeNumberV2(10));//expect false
    }
}
