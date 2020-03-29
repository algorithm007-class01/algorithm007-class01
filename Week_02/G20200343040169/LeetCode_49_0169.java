/**
 * 字符串排序法
 * 时间复杂度：O(n*k*lognk)
 * 空间复杂度：O(n*k)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)
            return new ArrayList();
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        for(String s: strs){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String ss = String.valueOf(cs);
            if(!map.containsKey(ss)){
                map.put(ss,new ArrayList());
            }
            map.get(ss).add(s);
        }
        return new ArrayList(map.values());
    }
}

/**
 * 字符串计数法
 * 时间复杂度：O(n*k)
 * 空间复杂度：O(n*k)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        int[] cvs = new int[26];
        for(String s: strs){
            Arrays.fill(cvs, 0);
            for(char c: s.toCharArray()){
                cvs[c - 'a'] ++;
            }
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < cvs.length; i++){
                sb.append("*");
                sb.append(cvs[i]);
            }
            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}