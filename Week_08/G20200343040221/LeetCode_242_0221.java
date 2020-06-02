//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表

package leetcode.editor.cn;

// 242. 有效的字母异位词
public class ValidAnagram_242 {

    //public static void main(String[] args) {
    //    Solution solution = new ValidAnagram_242().new Solution();
    //    System.out.println(solution);
    //}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 计数算法
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if (len != t.length()) {
            return false;
        }
        int charCount = 26;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        int[] scounter = new int[charCount];
        int[] tcounter = new int[charCount];
        for (int i = 0; i < len; i++) {
            scounter[schars[i] - 'a'] += 1;
            tcounter[tchars[i] - 'a'] += 1;
        }

        for (int i = 0; i < charCount; i++) {
            if (scounter[i] != tcounter[i]) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
