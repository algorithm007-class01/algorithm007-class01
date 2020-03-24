package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_49_0333 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (null==strs||strs.length==0) return null;
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        for ( int i=0;i<strs.length;i++ ) {
            char[] wordArr=strs[i].toCharArray();
            Arrays.sort(wordArr);
            String seqWord=new String(wordArr);
            if(!map.containsKey(seqWord)){
                List<String> wordList=new ArrayList<String>();
                map.put(seqWord,wordList);
                wordList.add(strs[i]);
                //list.add(wordList);
            }else{
                map.get(seqWord).add(strs[i]);
            }
        }

        return new ArrayList<>(map.values());
    }
}