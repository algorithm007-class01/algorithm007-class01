/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if(map.containsKey(sortedString)){
                List<String> arr = map.get(sortedString);
                arr.add(str);
                map.put(sortedString,arr);
            }else{
                List<String> arr = new ArrayList();
                arr.add(str);
                map.put(sortedString,arr);
            }
        }
        return new ArrayList<>(map.values());
    }
}
// @lc code=end

