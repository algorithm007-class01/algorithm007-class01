class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            String sortStr = String.valueOf(cs);
            List<String> list;
            if(!map.containsKey(sortStr)){
                list = new LinkedList<String>();
            } else {
                list = map.get(sortStr);
            }
            list.add(strs[i]);
            map.put(sortStr, list);
        }
        List<List<String>> res = new LinkedList<List<String>>();
        for(String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}
