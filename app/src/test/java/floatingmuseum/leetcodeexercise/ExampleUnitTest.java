package floatingmuseum.leetcodeexercise;

import org.junit.Test;

import floatingmuseum.leetcodeexercise.solutions.easy.EasySolution;
import floatingmuseum.leetcodeexercise.solutions.medium.MediumSolution;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testSolution() throws Exception {
        MediumSolution mediumSolution = new MediumSolution();
        int length = mediumSolution.lengthOfLongestSubstring("pwwkew");
        System.out.println("lengthOfLongestSubstring:"+length);
    }
}