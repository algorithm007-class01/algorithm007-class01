package DailyPractice;

import java.util.*;

public class LeetCode_127_0215 {
    int minStepCount = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 0;
        while (queue.size()>0){
            int size = queue.size();
            ++count;
            for (int i=0;i<size;i++){
                String start = queue.poll();
                for (String s:wordList){
                    if (visited.contains(s)){
                        continue;
                    }
                    if (!canCovert(start,s)){
                       continue;
                    }
                    if (s.equals(endWord)){
                        return count+1;
                    }
                    visited.add(s);
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    private boolean canCovert(String start, String s) {
        if (start.length()!=s.length()){
            return false;
        }
        int count = 0;
        for (int i=0;i<start.length();i++){
            if (start.charAt(i)!=s.charAt(i)){
                ++count;
            }
            if (count >1){
                return false;
            }
        }
        return count==1;
    }


}
