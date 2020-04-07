class Solution {
    // BFS 
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // wordList 类型转换一下，加速查询
        final HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();
        if (!dict.contains(endWord)) {
            return ans;
        }
        final Queue<List<String>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Collections.singletonList(beginWord)));
        boolean succeed = false;
        // 记录已经访问过的节点
        final Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty() && !succeed) {
            //不用记录层级了，每一层有多少个元素还是需要记录的
            int size = queue.size();
            final HashSet<String> currLevelVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                // path 每一层的路径
                final List<String> path = queue.poll();
                // 拿出路径上最后一个单词出来
                final String currentWord = path.get(path.size() - 1);

                // 寻找当前路径下的可能的下一个单词
                // 循环当前单词的没有个字符，并用26个字符进行替换比较
                for (int j = 0; j < currentWord.length(); j++) {
                    final char[] currChars = currentWord.toCharArray();
                    char curr = currChars[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (currChars[j] == ch) {
                            // 与自己撞上了，不考虑
                            continue;
                        } else {
                            currChars[j] = ch;
                            final String newWord = new String(currChars);
                            if (newWord.equals(endWord)) {
                                // 太开心了，找到了
                                final List<String> newPath = new ArrayList<>(path);
                                newPath.add(newWord);
                                ans.add(newPath);
                                succeed = true;
                            } else if (dict.contains(newWord) && !visited.contains(newWord)) {
                                // 同一层是允许同一个单词背多次使用的,所以不能直接用visited.add(newWord);
                                // visited.add(newWord);
                                currLevelVisited.add(newWord);
                                final List<String> waitPath = new ArrayList<>(path);
                                waitPath.add(newWord);
                                queue.add(waitPath);
                            }
                        }
                    }
                    currChars[j] = curr;
                }
            }
            visited.addAll(currLevelVisited);
        }
        return ans;
    }
}