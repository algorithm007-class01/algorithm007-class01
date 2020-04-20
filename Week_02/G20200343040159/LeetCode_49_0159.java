/**
* 49. 字母异位词分组<p>
*https://leetcode-cn.com/problems/group-anagrams/
*@author tim@timloong.win
*/
class Solution {
   public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String ss = new String(chars);
            ArrayList<String> list = null;
            if (map.containsKey(ss)) {
                list = map.get(ss);
            } else {
                list = new ArrayList<>();
            }
            list.add(s);

            map.put(ss, list);
        }

        return new ArrayList<>(map.values());
    }
}
