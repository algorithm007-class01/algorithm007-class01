import java.util.*;

public class LeetCode_127_0147 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Deque<MyPair> queue = new ArrayDeque<>();
        queue.addLast(new MyPair(beginWord, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                MyPair p = queue.pollFirst();
                String t = p.key;
                int level = p.value;
                if (t.equals(endWord)) {
                    return level;
                }
                for (String s : wordList) {
                    int diff = 0;
                    for (int i = 0; i < t.length(); i++) {
                        if (t.charAt(i) != s.charAt(i)) {
                            diff++;
                            if (diff > 1) {
                                break;
                            }
                        }
                    }
                    if (diff == 1 && !visited.contains(s)) {
                        visited.add(s);
                        queue.addLast(new MyPair(s, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    class MyPair {
        String key;
        int value;

        public MyPair(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
