import java.util.HashMap;

public class LeetCode_49_0069 {

    /**
     * 1.check 边界确认:都是小写字母；输出顺序不care
     * 2.可能解法：map计数器
     *        1)初始化map
     *        2)先对字符串数组中遍历，loop中分别对单个字符数组进行排序（Arrays.sort）
     *        3)然后判断当前str对应的key在map中是否存在;不存在，put key，value为初始化数组。
     *        4)map计数器key对应的value+1
     *        5)loop结束，将map的value转为数组并返回
     *        时间复杂度o(nlogn),空间复杂度O(n)
     * 3.coding
     * @param strs
     * @return
     */
    public List< List<String> > groupAnagrams(String[] strs) {
        if (null == strs) return null;
        if (strs.length == 0) return new ArrayList();
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            if (!map.containsKey(str)){
                map.put(str, new ArrayList());
            }
            map.get(str).add(s);
        }
        return new ArrayList(map.values());
    }
}
