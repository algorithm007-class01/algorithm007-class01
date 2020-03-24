// time O(NKlogK) N: 字符串数组的长度，K: 最长字符串的长度
// space O(NK)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap<>();

        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String temp = String.valueOf(ch);
            if (!map.containsKey(temp)) map.put(temp, new ArrayList());
            map.get(temp).add(str);
        }
        return new ArrayList(map.values());
    }
}