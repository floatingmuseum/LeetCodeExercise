package floatingmuseum.leetcodeexercise;

import org.junit.Test;

import floatingmuseum.leetcodeexercise.solutions.hard.HardSolution;

/**
 * Created by Floatingmuseum on 2018/5/25.
 */

public class HardSolutionTest {
    private HardSolution solution = new HardSolution();

    private void print(String content){
        System.out.println(content);
    }

    @Test
    public void testFindMedianSortedArrays(){
        double result1 = solution.findMedianSortedArrays(new int[]{1,3},new int[]{2});//expect 2.0
        print(result1+"");
        double result2 = solution.findMedianSortedArrays(new int[]{1,2},new int[]{3,4});//expect 2.5
        print(result2+"");
    }
}
