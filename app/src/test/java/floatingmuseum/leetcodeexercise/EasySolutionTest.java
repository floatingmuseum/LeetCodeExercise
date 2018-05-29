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
    public void testReverseInteger(){
        print("result1:"+solution.reverseInteger(123));
        print("result1:"+solution.reverseInteger(-123));
        print("result1:"+solution.reverseInteger(120));
    }
}
