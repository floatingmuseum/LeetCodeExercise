package floatingmuseum.leetcodeexercise;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import floatingmuseum.leetcodeexercise.solutions.medium.MediumSolution;

/**
 * Created by Floatingmuseum on 2018/5/25.
 */

public class MediumSolutionTest {

    private MediumSolution solution = new MediumSolution();

    private void print(String content) {
        System.out.println(content);
    }

    @Test
    public void testLengthOfLongestSubstring() {
        int result1 = solution.lengthOfLongestSubstring("abcabcbb");//expect abc
        print(result1 + "");
        int result2 = solution.lengthOfLongestSubstring("bbbbb");//expect b
        print(result2 + "");
        int result3 = solution.lengthOfLongestSubstring("pwwkew");//expect wke
        print(result3 + "");
    }

    @Test
    public void testLongestPalindrome() {
        String result1 = solution.longestPalindrome("a");//expect bab
        print(result1);
        String result2 = solution.longestPalindrome("abcde");//expect bb
        print(result2);
        String result3 = solution.longestPalindrome("babad");//expect bab
        print(result3);
        String result4 = solution.longestPalindrome("abbd");//expect bb
        print(result4);

        long start1 = System.currentTimeMillis();
        String result5 = solution.longestPalindrome("zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir");//expect bb
        print(result5 + "...time:" + (System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        String result6 = solution.longestPalindromeV2("zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir");//expect bb
        print(result6 + "...time:" + (System.currentTimeMillis() - start2));

        long start0 = System.currentTimeMillis();
        String result0 = solution.longestPalindromeV3("zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir");//expect bb
//        String result0 = solution.longestPalindromeV3("adam");//expect gykrkyg
        print(result0 + "...time:" + (System.currentTimeMillis() - start0));

        long start3 = System.currentTimeMillis();
        String result7 = solution.longestPalindromeV4("babad");//expect bab
        print(result7 + "...time:" + (System.currentTimeMillis() - start3));

        long start4 = System.currentTimeMillis();
        String result8 = solution.longestPalindromeV4("aaaa");//expect aaaa
        print(result8 + "...time:" + (System.currentTimeMillis() - start4));

        long start5 = System.currentTimeMillis();
        String result9 = solution.longestPalindromeV4("adam");//expect ada
        print(result9 + "...time:" + (System.currentTimeMillis() - start5));

        long start6 = System.currentTimeMillis();
        String result10 = solution.longestPalindromeV4("ccd");//expect ada
        print(result10 + "...time:" + (System.currentTimeMillis() - start6));

        long start7 = System.currentTimeMillis();
        String result11 = solution.longestPalindromeV4("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");//expect dddd。。。
        print(result11 + "...time:" + (System.currentTimeMillis() - start7));

        long start8 = System.currentTimeMillis();
        String result12 = solution.longestPalindromeV4("321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123");//expect ada
        print(result12 + "...time:" + (System.currentTimeMillis() - start8));
        int length = ("321012321001232100123210012321001232100123210012321001232100123210012321001232100123" +
                "210012321001232100123210012321001232100123210012321001232100123210012321001232100123" +
                "210012321001232100123210012321001232100123210012321001232100123210012321001232100123210" +
                "0123210012321001232100123210012321001232100123210012321001232100123210012321001232100123" +
                "21001232100123210012321001232100123210012321001232100123210012321001232100123210012321001" +
                "23210012321001232100123210012321001232100123210012321001232100123210012321001232100123210" +
                "01232100123210012321001232100123210012321001232100123210012321001232100123210012321001232" +
                "1001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232" +
                "1001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232" +
                "10012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321" +
                "0012321001232100123210012321001232100123210012321001232100123210012321001232100123210123").length();
        print(length+"");

        print(("321012321001232100123210012321001232100123210012321001232100123210012321001232100123" +
                "210012321001232100123210012321001232100123210012321001232100123210012321001232100123" +
                "210012321001232100123210012321001232100123210012321001232100123210012321001232100123210" +
                "0123210012321001232100123210012321001232100123210012321001232100123210012321001232100123" +
                "21001232100123210012321001232100123210012321001232100123210012321001232100123210012321001" +
                "23210012321001232100123210012321001232100123210012321001232100123210012321001232100123210" +
                "01232100123210012321001232100123210012321001232100123210012321001232100123210012321001232" +
                "1001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232" +
                "1001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232" +
                "10012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321" +
                "0012321001232100123210012321001232100123210012321001232100123210012321001232100123210123").charAt(length/2)+"");

        print(("321012321001232100123210012321001232100123210012321001232100123210012321001232100123" +
                "210012321001232100123210012321001232100123210012321001232100123210012321001232100123" +
                "210012321001232100123210012321001232100123210012321001232100123210012321001232100123210" +
                "0123210012321001232100123210012321001232100123210012321001232100123210012321001232100123" +
                "21001232100123210012321001232100123210012321001232100123210012321001232100123210012321001" +
                "23210012321001232100123210012321001232100123210012321001232100123210012321001232100123210" +
                "01232100123210012321001232100123210012321001232100123210012321001232100123210012321001232" +
                "1001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232" +
                "1001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232" +
                "10012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321" +
                "0012321001232100123210012321001232100123210012321001232100123210012321001232100123210123").charAt(length/2-1)+"");
    }
}
