package myself;

import java.util.*;

public class LeetCode_127_0201 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<String>> wordPool = new HashMap<>();
        for (String item : wordList) {
            for (int i = 0; i < item.length(); i++) {
                char[] cArr = item.toCharArray();
                cArr[i] = '*';
                String key = new String(cArr);
                if (wordPool.containsKey(key)) {
                    wordPool.get(key).add(item);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(item);
                    wordPool.put(key, list);
                }
            }
        }

        int resLen = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visitedNode = new HashSet<>();
        while (!queue.isEmpty()) {
            resLen++;
            int levelSize = queue.size();
            while (levelSize-- > 0) {
                String node = queue.poll();
                if (endWord.equals(node)) {
                    return resLen;
                }
                for (int i = 0; i < node.length(); i++) {
                    char[] cArr = node.toCharArray();
                    cArr[i] = '*';
                    for (String nextNode : wordPool.getOrDefault(new String(cArr), new ArrayList<>())) {
                        if (!visitedNode.contains(nextNode)) {
                            queue.offer(nextNode);
                            visitedNode.add(node);
                        }
                    }
                }
                visitedNode.add(node);
            }

        }
        return resLen;
    }

    public static void main(String[] args) {
//        Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(new LeetCode_127_0201().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

}
