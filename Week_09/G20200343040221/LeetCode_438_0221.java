//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 438. 找到字符串中所有字母异位词
public class FindAllAnagramsInAString_438 {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final int letterCount = 26;

    public List<Integer> findAnagrams(String s, String p) {
        int plength = p.length();
        if (s.length() < plength) {
            return new ArrayList<>(0);
        }

        int[] pcounter = new int[letterCount];
        count(p, 0, plength, pcounter);

        int[] scounter = new int[letterCount];
        count(s, 0, plength, scounter);

        List<Integer> ans = new ArrayList<>();
        if (isAnagrams(scounter, pcounter)) {
            ans.add(0);
        }

        int end = s.length() - plength;
        for (int i = 1; i <= end; i++) {
            // 滑动窗口
            scounter[s.charAt(i - 1) - 'a'] -= 1;
            scounter[s.charAt(i + plength - 1) - 'a'] += 1;
            if (isAnagrams(scounter, pcounter)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean isAnagrams(int[] scounter, int[] pcounter) {
        for (int i = 0; i < letterCount; i++) {
            if (scounter[i] != pcounter[i]) {
                return false;
            }
        }
        return true;
    }

    private void count(String str, int start, int end, int[] counter) {
        for (int i = start; i < end; i++) {
            counter[str.charAt(i) - 'a'] += 1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
