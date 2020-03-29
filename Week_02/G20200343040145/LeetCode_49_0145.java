import java.util.*;
/**
 *  给定一个字符串数组，将字母异位词组合在一起。
 *  字母异位词指字母相同，但排列不同的字符串。
 * */
public class LeetCode_49_0145 {

}
class Solution{
    public List<List<String>> groupAnagrams(String[] strs) {
        // key为排序后的单词，value为单词集合 -这些单词排序后都和key一致
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String str : strs) {
            // 字符串转字符数组，方便排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sSort = String.valueOf(charArray);
            List<String> listStr = groupMap.get(sSort);
            // 判空，如果为空，将value初始化
            if (listStr == null) {
                listStr = new ArrayList<>();
                groupMap.put(sSort, listStr);
            }
            listStr.add(str);
        }
        return new ArrayList<>(groupMap.values());
    }
}