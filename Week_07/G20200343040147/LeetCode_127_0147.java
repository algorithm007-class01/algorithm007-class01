import java.util.*;

public class LeetCode_127_0147 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 0;
        if (!wordList.contains(endWord)) {
            return res;
        }
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast(beginWord);

        Deque<String> endDeque = new ArrayDeque<>();
        endDeque.addLast(endWord);
        Set<String> visited2 = new HashSet<>();
        visited2.add(endWord);

        while (!deque.isEmpty() && !endDeque.isEmpty()) {
            if (deque.size() > endDeque.size()) {
                Deque<String> tmp = deque;
                deque = endDeque;
                endDeque = tmp;
                Set<String> tmpSet = visited;
                visited = visited2;
                visited2 = tmpSet;
            }
            int size = deque.size();
            res++;
            for (int i = 0; i < size; i++) {
                String w = deque.pollFirst();
                for (String word : wordList) {
                    if (visited.contains(word)) {
                        continue;
                    }
                    int diff = 0;
                    for (int j = 0; j < w.length(); j++) {
                        if (w.charAt(j) != word.charAt(j)) {
                            diff++;
                        }
                        if (diff > 1) {
                            break;
                        }
                    }
                    if (diff == 1) {
                        if (endDeque.contains(word)) {
                            return res + 1;
                        }
                        deque.addLast(word);
                        visited.add(word);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "AACCGGTT";
        String endWord = "AACCGGTA";
        List<String> wordList = Arrays.asList("AACCGGTA");
        System.out.println(new LeetCode_127_0147().ladderLength(beginWord, endWord, new ArrayList<>(wordList)));
    }
}
