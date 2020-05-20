import java.util.HashMap;

/**
 * 387. 字符串中的第一个唯一字符
 * 
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 
 * 案例:
    s = "leetcode"
    返回 0.

    s = "loveleetcode",
    返回 2.

 * 复杂度分析
    时间复杂度： O(N), 只遍历了两遍字符串，同时散列表中查找操作是常数时间复杂度的。
    空间复杂度： O(N), 用到了散列表来存储字符串中每个元素出现的次数。
 */
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}