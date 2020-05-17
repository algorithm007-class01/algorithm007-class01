//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
// 注意事项：您可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int firstUniqChar(String s) {
        // 分两种情况
        // 字符串长度不超过26时
        if (s.length() <= 26) {
            // 存储各字符出现次数
            int[] num = new int[26];
            // 转化为字符数组
            char[] sc = s.toCharArray();
            int len = sc.length;
            for (int i = 0; i < len; i++) {
                // 统计字母出现频次
                num[sc[i]-'a']++;
            }
            // 第二次遍历，返回第一个出现频次为1的下标
            for (int i = 0; i < len; i++) {
                if (num[sc[i]-'a'] == 1) {
                    return i;
                }
            }
            // 无解
            return -1;
        }
        // 字符串长度超过26时
        int idx = -1;
        // 对26个字母进行遍历
        for (char ch = 'a'; ch <= 'z'; ch++) {
            // 返回指定字符在字符串中第一次出现处的索引
            // 如果此字符串中没有这样的字符，则返回-1。
            int beginIndex = s.indexOf(ch);
            if (beginIndex != -1 && beginIndex == s.lastIndexOf(ch)) {
                idx = (idx == -1 || idx > beginIndex) ? beginIndex : idx;
            }
        }
        return idx;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
