package floatingmuseum.leetcodeexercise;

import org.junit.Test;


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
        String result6 = solution.longestPalindrome("zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir");//expect bb
        print(result6 + "...time:" + (System.currentTimeMillis() - start2));

        long start0 = System.currentTimeMillis();
        String result0 = solution.longestPalindrome("zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir");//expect bb
//        String result0 = solution.longestPalindrome("adam");//expect gykrkyg
        print(result0 + "...time:" + (System.currentTimeMillis() - start0));

        long start3 = System.currentTimeMillis();
        String result7 = solution.longestPalindrome("babad");//expect bab
        print(result7 + "...time:" + (System.currentTimeMillis() - start3));

        long start4 = System.currentTimeMillis();
        String result8 = solution.longestPalindrome("aaaa");//expect aaaa
        print(result8 + "...time:" + (System.currentTimeMillis() - start4));

        long start5 = System.currentTimeMillis();
        String result9 = solution.longestPalindrome("adam");//expect ada
        print(result9 + "...time:" + (System.currentTimeMillis() - start5));

        long start6 = System.currentTimeMillis();
        String result10 = solution.longestPalindrome("ccd");//expect cc
        print(result10 + "...time:" + (System.currentTimeMillis() - start6));

        long start7 = System.currentTimeMillis();
        String result11 = solution.longestPalindrome("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");//expect dddd。。。
        print( "time:" + (System.currentTimeMillis() - start7)+"..."+result11);

        long start8 = System.currentTimeMillis();
        String result12 = solution.longestPalindrome("321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123");//expect ada
        print("time:" + (System.currentTimeMillis() - start8)+"..."+result12);

        long start9 = System.currentTimeMillis();
//        String result13 = solution.longestPalindrome("iptmykvjanwiihepqhzupneckpzomgvzmyoybzfynybpfybngttozprjbupciuinpzryritfmyxyppxigitnemanreexcpwscvcwddnfjswgprabdggbgcillisyoskdodzlpbltefiz");//expect ada
        String result13 = solution.longestPalindrome("rabdggbgcillisyoskdodzlpbltefiz");
        print(result13 + "...time:" + (System.currentTimeMillis() - start9));//expected illi

        long start10 = System.currentTimeMillis();
        String result14 = solution.longestPalindrome("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");//expect ada
        print(result14.length()+ "..."+result14 +"...time:" + (System.currentTimeMillis() - start10));

        long start11 = System.currentTimeMillis();
        String result15 = solution.longestPalindrome("ffffffggggg");
        print(result15.length()+ "..."+result15 +"...time:" + (System.currentTimeMillis() - start11));//expected ffffff

        long start12 = System.currentTimeMillis();
        String result16 = solution.longestPalindrome("fffffgggggg");
        print(result16.length()+ "..."+result16 +"...time:" + (System.currentTimeMillis() - start12));//expected gggggg

        long start13 = System.currentTimeMillis();
        String result17 = solution.longestPalindrome("bananas");
        print(result17.length()+ "..."+result17 +"...time:" + (System.currentTimeMillis() - start13));//expected anana
    }
}
