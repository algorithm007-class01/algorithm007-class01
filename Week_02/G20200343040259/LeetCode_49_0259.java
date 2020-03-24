import java.util.*;

public class l49groupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = new Solution().groupAnagrams(strs);
        System.out.println(result);
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map map = new HashMap<String, List<String>>();
            for(int i=0; i< strs.length; i++){
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String find = String.valueOf(chars);

                if(map.containsKey(find)){
                    List<String> list = (List<String>)map.get(find);
                    list.add(strs[i]);
                    map.put(find, list);
                } else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(find);
                    map.put(find, list);
                }
            }
            return new ArrayList<>(map.values());

        }
    }
}
