package leetCode.week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_49_0065 {
	public List<List<String>> groupAnagrams(String[] strs) {
		
		if (strs.length == 0) 
			return new ArrayList<>();
		
		Map<String,List<String>> result = new HashMap<>();
		
		for (String str : strs) {
			
			char[] s = str.toCharArray();
			Arrays.sort(s);
			String key = String.valueOf(s);
			
			if (!result.containsKey(key))
				result.put(key, new ArrayList<String>());
			
			result.get(key).add(str);
		}
		
		return new ArrayList<>(result.values());
    }
}
