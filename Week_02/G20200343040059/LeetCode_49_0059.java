/**
 * 49. 字母异位词分组
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
class Solution {
    /**
     * 解题思路:
     * 1.暴力求解:2个for循环进行逐一比较塞选
     * 2.使用hash表将满足条件的数据进行存储
     */
    public List<List<String>> groupAnagrams(String[] strs) {
            //  ["eat", "tea", "tan", "ate", "nat", "bat"]

            if (null == strs || strs.length == 0) {
                return null;
            }

            // 定义存储数据的集合
            Map<String, List<String>> result = new HashMap();

            for (String str : strs) {
                char[] array = str.toCharArray();
                Arrays.sort(array);

                String arrayStr = String.valueOf(array);
//            if (result.containsKey(arrayStr)) {
//                result.get(arrayStr).add(str);
//            } else {
//                List list = new ArrayList();
//                list.add(str);
//                result.put(arrayStr, list);
//            }
            // 查看题解后改进
            if(!result.containsKey(arrayStr)) result.put(arrayStr, new ArrayList());
            result.get(arrayStr).add(str);
            }
            return new ArrayList(result.values());
    }
}