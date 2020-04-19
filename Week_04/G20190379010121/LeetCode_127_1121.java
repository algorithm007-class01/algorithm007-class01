
class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<Character> charDict = new HashSet();
        for(String str : wordList){
            char[] chars = str.toCharArray();
            for(char c : chars){
                charDict.add(c);
            }
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int len = 1;
        while(!q.isEmpty()){
            int size =  q.size();
            for(int i = 0;i < size;i ++){
                String cur = q.poll();
                if(cur.equals(endWord)){
                    return len;
                }
                char[] chars = cur.toCharArray();
                for(int j = 0;j < chars.length;j ++){
                    char oldc = chars[j];
                    for(char c : charDict){
                        chars[j] = c;
                        String next = new String(chars);
                        if(!visited.contains(next) && dict.contains(next)){
                            visited.add(next);
                            q.add(next);
                        }
                    }
                    chars[j] = oldc;
                }
            }
            len ++;
        }
        return 0;
    }

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Map<String,Set<String>> dict = new HashMap<>();
//        for(String str : wordList){
//            char[] chars = str.toCharArray();
//            for(int i = 0;i < chars.length;i ++){
//                char oldc = chars[i];
//                chars[i] = '*';
//                String newStr = new String(chars);
//                Set set = dict.getOrDefault(newStr,new HashSet());
//                chars[i] = oldc;
//                set.add(new String(chars));
//                dict.put(newStr,set);
//            }
//        }
//
//        Queue<String> q = new LinkedList<>();
//        q.add(beginWord);
//        Set<String> visited = new HashSet<>();
//        visited.add(beginWord);
//        int level = 1;
//        while(!q.isEmpty()){
//            int size = q.size();
//            for(int i = 0;i < size;i ++){
//                String cur = q.poll();
//                if(cur.equals(endWord)){
//                    return level;
//                }
//                char[] chars = cur.toCharArray();
//                for(int c = 0; c < chars.length; c++){
//                    char oldc = chars[c];
//                    chars[c] = '*';
//                    String newStr = new String(chars);
//                    chars[c] = oldc;
//                    String oldStr = new String(chars);
//                    if(!visited.contains(newStr) && dict.containsKey(newStr)){
//                        visited.add(newStr);
//                        for(String str : dict.getOrDefault(newStr,new HashSet<String>())){
//                            q.add(str);
//                        }
//                    }
//                }
//            }
//            level ++;
//        }
//        return 0;
//    }




}