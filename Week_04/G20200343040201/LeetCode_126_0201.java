package myself;

import javafx.util.Pair;

import java.util.*;

public class LeetCode_126_0201 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

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

        List<List<String>> resList = new ArrayList<>();
        Queue<Pair<String, List<String>>> queue = new LinkedList<>();
        List<String> beginList = new ArrayList<>();
        beginList.add(beginWord);
        queue.offer(new Pair<>(beginWord, beginList));
        Set<String> visitedNode = new HashSet<>();
        boolean isFoundRes = false;
        while (!queue.isEmpty() && !isFoundRes) {
            int levelSize = queue.size();
            while (levelSize-- > 0) {
                Pair<String, List<String>> node = queue.poll();
                if (endWord.equals(node.getKey())) {
                    isFoundRes = true;
                    resList.add(node.getValue());
                }
                for (int i = 0; i < node.getKey().length(); i++) {
                    char[] cArr = node.getKey().toCharArray();
                    cArr[i] = '*';
                    for (String nextNode : wordPool.getOrDefault(new String(cArr), new ArrayList<>())) {
                        if (!visitedNode.contains(nextNode)) {
                            List<String> newList = new ArrayList<>(node.getValue());
                            newList.add(nextNode);
                            queue.offer(new Pair<>(nextNode, newList));
                            visitedNode.add(node.getKey());
                        }
                    }
                }
                visitedNode.add(node.getKey());
            }
        }
        return resList;
    }

    public static void main(String[] args) {
//        Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(new LeetCode_126_0201().findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

}
