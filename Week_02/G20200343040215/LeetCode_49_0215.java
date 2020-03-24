package DailyPractice;

import java.util.*;

public class LeetCode_49_0215 {

    public ArrayList groupAnagrams(String[] strs) {
        //统计每个字符串的ASCII码总值 -----ASCII码值有可能呢两个字符的值相加等于一个字符 直接排序字符
        //Map映射容器，相同的入相同的组
        if(strs.length==0) {
            return new ArrayList();
        }
        int [] count = new int[26];
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            Arrays.fill(count,0);

            for(char c: s.toCharArray()) {
                count [c - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<26;i++){
                sb.append('#');
                sb.append(count[i]);
            }

            String key = sb.toString();
            if(!map.containsKey(key)) {
                map.put(key,new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());

    }
}
