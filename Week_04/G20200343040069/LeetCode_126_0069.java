class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)) return res;
        Set<String> dict = new HashSet<String>(wordList);
        Map<String, List<String>> map = new HashMap<>();
        Set<String> startSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        startSet.add(beginWord);
        endSet.add(endWord);

        bfs(startSet, endSet, dict, map, false);

        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(list, endWord, beginWord, map);
        return res;
    }


    private void dfs(List<String> list, String endWord, String word, Map<String, List<String>> map){
        if(word.equals(endWord)){
            res.add(new ArrayList<>(list));
            return;
        }

        if(map.get(word) == null) return;
        for(String next : map.get(word)){
            list.add(next);
            dfs(list, endWord, next, map);
            list.remove(list.size() -1);
        }
    }

    private void bfs(Set<String> startSet, Set<String> endSet, Set<String> dict, Map<String, List<String>> map, boolean reverse){
        if(startSet.size() == 0) return;

        if(endSet.size() < startSet.size()){
            bfs(endSet, startSet, dict, map, !reverse);
            return;
        }
        Set<String> tmp = new HashSet<>();
        dict.removeAll(startSet);

        boolean finish = false;
        for(String s:startSet){
            char[] chr = s.toCharArray();
            for(int i=0;i<chr.length;i++){
                char old = chr[i];

                for(char c='a'; c<='z';c++){
                    chr[i] = c;
                    String word = new String(chr);

                    if(dict.contains(word)){
                        if(endSet.contains(word)) {
                            finish = true;
                        }else{
                            tmp.add(word);
                        }

                        String key = reverse ? word : s;
                        String val = reverse ? s : word;
                        if(map.get(key) == null) map.put(key, new ArrayList<>());
                        map.get(key).add(val);
                    }
                }
                chr[i] = old;
            }
        }

        if(!finish) bfs(tmp, endSet, dict, map, reverse);
    }
}