// time O(m + n) m:字符串s的长度，n：字符串n的长度
// space O(m + n) toCharArray会生成字符数组
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        int[] word = new int[26];
        // 把s中的字母出现次数添加进数组
        for (char c : s.toCharArray()) {
            ++word[c - 'a'];
        }
        // 判断t中是否有比s中多的字母，是则false，否则继续
        for (char ch : t.toCharArray()) {
            --word[ch - 'a'];
            if (word[ch - 'a'] < 0)
                return false;
        }
        // 判断s中是否还有剩余字符，是则false，否则继续
        for (int i = 0; i < word.length; ++i)
            if(word[i] != 0)
                return false;
        return true;
    }
}