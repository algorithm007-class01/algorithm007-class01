//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


package com.Simba.algorithm007class01.leetcode.editor.cn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        List<List<String>> list = new ArrayList<List<String>>();

        list = solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List ll : list) {
            System.out.println(ll);

        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            //map将keystr存入当作key，与keystr相同的当作value
            HashMap<String,List<String>> map=new HashMap<>();
            for(String str:strs){
                char[]array=str.toCharArray();
                Arrays.sort(array);
                String keystr=String.valueOf(array);
                if(!map.containsKey(keystr)) map.put(keystr,new ArrayList<String>());
                map.get(keystr).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}