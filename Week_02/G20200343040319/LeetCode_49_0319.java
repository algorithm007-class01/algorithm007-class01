class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();

        for (String str: strs){
            int[] count = new int[26];
            Arrays.fill(count,0);
            //采用了一组String来定义哈希表的key
            //采用了leetcode上的答案
            StringBuilder sb = new StringBuilder();
            for (char c: str.toCharArray()){
                count[c-'a']++;
            }
            for (int i=0;i<26;++i){
                sb.append(count[i]);
                sb.append("#");
            }
            String a = sb.toString();

            if (map.containsKey(a)){
                List<String> s = map.get(a);
                s.add(str);
                map.put(a,s);
            }
            else{
                List<String> s = new ArrayList<>();
                s.add(str);
                map.put(a,s);
            }
        }

        for (List<String> l: map.values()){
            list.add(l);
        }
        return list;
    }
}