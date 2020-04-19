package DailyPractice;

import java.util.*;

public class LeetCode_126_0215 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        
        if (!wordList.contains(endWord)){
            return ans;
        }
        bfs(beginWord,endWord,wordList,ans);
        return ans;
    }

    private void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> ans) {
        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.offer(path);
        boolean isFound = false;
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()){
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int j=0;j<size;j++){
                List<String> p = queue.poll();
                String temp = p.get(p.size()-1);
                ArrayList<String> neighbors = getNeighbors(temp,dict);
                for (String neighbor :neighbors){
                    if (visited.contains(neighbor)){
                        continue;
                    }
                    if (neighbor.equals(endWord)){
                        isFound = true;
                        p.add(neighbor);
                        ans.add(new ArrayList<String>(p));
                        p.remove(p.size()-1);
                    }
                    p.add(neighbor);
                    queue.offer(new ArrayList<>(p));
                    p.remove(p.size()-1);
                    subVisited.add(neighbor);
                }
            }
            visited.addAll(subVisited);
            if (isFound){
                break;
            }
        }
    }

    private ArrayList<String> getNeighbors(String temp, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char chs[] = temp.toCharArray();
        for (char ch = 'a';ch<='z';ch++){
            for (int i=0;i<chs.length;i++){
                if (chs[i]==ch){
                    continue;
                }
                char old_ch = chs[i];
                chs[i]=ch;
                if (dict.contains(String.valueOf(chs))){
                    res.add(String.valueOf(chs));
                }
                chs[i]=old_ch;
            }
        }
        return res;
    }
}
