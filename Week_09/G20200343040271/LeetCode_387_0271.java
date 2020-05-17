
/*
387. 字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:
s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
*/

class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> dict = new HashMap<>();
        Character c = null;
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            dict.put(c,(dict.getOrDefault(c,0) +1));
        }
        for(int i = 0; i < s.length(); i++){
            if(dict.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}