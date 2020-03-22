/*
49. 字母异位词分组
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
示例:
    输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
    输出:
        [
            ["ate","eat","tea"],
            ["nat","tan"],
            ["bat"]
        ]
说明：
    所有输入均为小写字母。
    不考虑答案输出的顺序。
*/
/*

方法思路：
1、先排序，再hash
2、计数法
*/

public class GroupAnagrams {
    public static void main(String[] args) {
        new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    /**
     * 计数法,核心：一个字符串中，如果字符出现个数相同，那么一定可以组成相同的字符串
     * 遍历数组，计算每个字符串中每个字符出现的次数，
     * 1、(巧妙设计)新建一个长度为26的数组存放每个字符出现的次数，利用-a定位数组中依次表示a\b\c……
     * 2、将字符转为字符数组，依次求解出现次数，
     * 3、将出现次数依次拼接，形成一个唯一的hash key，放入hash表中，碰撞，则相同
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] arr = new int[26];
        Map<String, List<String>> result = new HashMap<>();
        for (String s : strs) {
            Arrays.fill(arr, 0);
            char[] chars = s.toCharArray();
            for (char c: chars) {
                arr[c-'a']++; //记录字符串中每个字符出现的次数
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#").append(arr[i]); // #区分当一个字符出现次数超过两位数情况
            }
            String key = sb.toString();
            if(!result.containsKey(key))
                result.put(key, new ArrayList<>());

            result.get(key).add(s);
        }
        return new ArrayList<>(result.values());
    }

    /**
     * 先排序，再hash
     * 时间复杂度：O(k*nlogn)，空间复杂度：O(n*k) k为最长字符串长度，n数组长度
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        if(strs == null || strs.length <= 0){
            throw new IllegalArgumentException("param is invalid");
        }

        Map<String, List<String>> result = new HashMap<>();
        for (String s : strs) {
            char[]  chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!result.containsKey(key))
                result.put(key, new ArrayList<>());
            result.get(key).add(s);
        }
        System.out.println(result.values());
        return new ArrayList<>(result.values());

    }
}