class Solution {
    //bfs
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)){
            return 0;
        }
        char[] dict = new char[]{'A','C','G','T'};
        Set<String> visitedSet = new HashSet<>();
        Set<String> bankSet = new HashSet<>();
        for(String str: bank){
            bankSet.add(str);
        }
        Queue<String> q = new LinkedList<>();
        q.add(start);
        visitedSet.add(start);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size;i ++){
                String cur = q.poll();
                if(cur.equals(end)){
                    return level;
                }
                char[] chars = cur.toCharArray();
                for(int p = 0;p < chars.length;p ++){
                    char oldc = chars[p];
                    for(char d : dict){
                        chars[p] = d;
                        String next = new String(chars);
                        if(!visitedSet.contains(next) && bankSet.contains(next)){
                            visitedSet.add(next);
                            q.add(next);
                        }
                    }
                    chars[p] = oldc;
                }
            }
            level ++;
        }
        return -1;
    }
}