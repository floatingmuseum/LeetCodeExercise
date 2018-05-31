package floatingmuseum.leetcodeexercise

import floatingmuseum.leetcodeexercise.entity.ProblemItm
import floatingmuseum.leetcodeexercise.desc.EasyDesc
import floatingmuseum.leetcodeexercise.desc.HardDesc
import floatingmuseum.leetcodeexercise.desc.MediumDesc

/**
 * Created by Floatingmuseum on 2018/5/31.
 */
object DataSource {

    const val DATA_TYPE_KEY = "dataType"
    const val DATA_TYPE_EASY = 0
    const val DATA_TYPE_MEDIUM = 1
    const val DATA_TYPE_HARD = 2

    private var easyData: MutableList<ProblemItm> = mutableListOf()
    private var mediumData: MutableList<ProblemItm> = mutableListOf()
    private var hardData: MutableList<ProblemItm> = mutableListOf()

    init {
        fillEasyData()
        fillMediumData()
        fillHardData()
    }

    private fun fillHardData() {
        hardData.apply {
            add(ProblemItm(0, "Median of Two Sorted Arrays", HardDesc.MedianOfTwoSortedArrays, "https://leetcode.com/problems/median-of-two-sorted-arrays/description/", true))
        }
    }

    private fun fillMediumData() {
        mediumData.apply {
            add(ProblemItm(0, "Longest Substring Without Repeating Characters", MediumDesc.LongestSubstringWithoutRepeatingCharacters, "https://leetcode.com/problems/longest-substring-without-repeating-characters/description/", true))
        }
    }

    private fun fillEasyData() {
        easyData.apply {
            add(ProblemItm(0, "Two Sum", EasyDesc.TwoSum, "https://leetcode.com/problems/two-sum/description/", true))
            add(ProblemItm(1, "Reverse Integer", EasyDesc.ReverseInteger, "https://leetcode.com/problems/reverse-integer/description/", true))
            add(ProblemItm(2, "Palindrome Number", EasyDesc.PalindromeNumber, "https://leetcode.com/problems/palindrome-number/description/", false))
        }
    }

    fun getData(type: Int): MutableList<ProblemItm> {
        return when (type) {
            DATA_TYPE_EASY -> easyData
            DATA_TYPE_MEDIUM -> mediumData
            DATA_TYPE_HARD -> hardData
            else -> mutableListOf()
        }
    }
}