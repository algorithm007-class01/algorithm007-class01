class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 所有单词的长度相同，所以这里可以直接将len定义出来
        int len = beginWord.length();
        Map<String, List<String>> dict = new HashMap<>();
        // 字典数据转换
        wordList.forEach(w -> {
            for (int i = 0; i < w.length(); i++) {
                final StringBuilder word = new StringBuilder(w);
                word.setCharAt(i, '*');
                List<String> words = dict.getOrDefault(word.toString(), new ArrayList<>());
                words.add(w);
                dict.put(word.toString(), words);
            }
        });
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // 遍历树的每一层
            for (int i = 0; i < levelSize; i++) {
                String world = queue.poll();
                for (int j = 0; j < world.length(); j++) {
                    // 对取出来的单词，替换每一个字符，试着在字典里面看是否存在endWorld
                    StringBuilder builder = new StringBuilder(world);
                    builder.setCharAt(j, '*');
                    String key = builder.toString();
                    // 这里使用OrDefault可以省去后面的null的判断，非常的好
                    for (String k : dict.getOrDefault(key, new ArrayList<>())) {
                        // 写糊涂了，k.equals(world) 死活是错的，还没有发现问题，汗
                        if (k.equals(endWord) && !visited.contains(k)) {
                            return level + 1;
                        }
                        if (!visited.contains(k)) {
                            visited.add(k);
                            queue.add(k);
                        }
                    }
                }
            }
            ++level;
        }
        return 0;
    }
}