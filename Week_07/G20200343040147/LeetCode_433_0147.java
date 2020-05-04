import java.util.*;

public class LeetCode_433_0147 {
    public int minMutation(String start, String end, String[] bank) {
        int res = -1;

        Arrays.sort(bank);
        if (Arrays.binarySearch(bank, end) == -1) {
            return res;
        }
        Set<String> visited = new HashSet<>();
        visited.add(start);
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast(start);

        Deque<String> endDeque = new ArrayDeque<>();
        endDeque.addLast(end);
        Set<String> visited2 = new HashSet<>();
        visited2.add(end);

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
                for (String word : bank) {
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
        return -1;
    }

    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(new LeetCode_433_0147().minMutation(start, end, bank));
    }
}
