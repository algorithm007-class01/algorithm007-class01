//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 案例: 
//
// 
//s = "leetcode"
//返回 0.
//
//s = "loveleetcode",
//返回 2.
// 
//
// 
//
// 注意事项：您可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        int result = s.length();
        for (char c = 'a'; c <= 'z'; ++c) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c))
                result = Math.min(result, s.indexOf(c));
        }
        return result == s.length() ? -1 : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
