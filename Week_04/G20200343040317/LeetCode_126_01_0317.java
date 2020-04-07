class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 思路：
        // 1 使用双向bfs构建树
        // 2 使用dfs在树中查询结果

        // 对入参wordList 转换为set 类型，加快查询速度
        final Set<String> dict = new HashSet<>(wordList);
        final List<List<String>> ans = new ArrayList<>();
        // 入参校验
        if (!dict.contains(endWord)) {
            return ans;
        }

        // forward，backward 记录当前层的节点
        final Set<String> forward = new HashSet<>();
        forward.add(beginWord);

        final Set<String> backward = new HashSet<>();
        backward.add(endWord);

        // 定义存储节点关系的map
        final Map<String, List<String>> tree = new HashMap<>();
        // 双向bfs 这里涉及一个方向问题，因为影响tree 数据写入，从上向下搜索的时候是 key（current word） -->value（child word）,
        // 从下往上的时候刚好相反 key（child word） -->value（current word）
        // 向下搜索的时候我们把方向记为true
        boolean direction = true;
        bfs(forward, backward, direction, dict, tree);
        dfs(beginWord, endWord, new ArrayList<>(), tree, ans);
        return ans;
    }

    private void dfs(String beginWord, String endWord, List<String> path, Map<String, List<String>> tree, List<List<String>> ans) {
        // 终结条件
        if (beginWord.equals(endWord)) {
            List<String> p = new ArrayList<>(path);
            p.add(beginWord);
            ans.add(p);
            return;
        }

        // 子问题
        for (String child : tree.getOrDefault(beginWord, new ArrayList<>())) {
            path.add(beginWord);
            dfs(child, endWord, path, tree, ans);
            path.remove(path.size() - 1);
        }

    }

    private void bfs(Set<String> forward, Set<String> backward, boolean direction, Set<String> dict, Map<String, List<String>> tree) {
        // 标记本层是否已经找到了
        boolean succeed = false;
        // 终止条件
        if (forward.size() == 0) {
            return;
        }

        // 先构建当前层节点少的那一层
        if (forward.size() > backward.size()) {
            bfs(backward, forward, !direction, dict, tree);
            // 这个return 必须添加，函数后面的还会继续执行一次，导致深度变大
            return;
        }
        // 已经用过的数据我们 需要remove掉
        dict.removeAll(forward);
        // 真正参与计算的是bfs中第一个参数，第二个是备用的，所以同时remove
        // dict.removeAll(backward);
        // 记录下一层需要访问的单词
        final Set<String> nextLevelWords = new HashSet<>();
        for (String w : forward) {
            char[] chars = w.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char tmpChar = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == chars[i]) {
                        // 遇到自己了，忽略掉
                        continue;
                    }
                    chars[i] = ch;
                    String word = new String(chars);
                    if (dict.contains(word)) {
                        // 记录下一层需要处理的word
                        nextLevelWords.add(word);

                        String key = direction ? w : word;
                        final String value = direction ? word : w;
                        // 记录当前单词的孩子节点信息
                        if (!tree.containsKey(key)) {
                            tree.put(key, new ArrayList<>());
                        }
                        tree.get(key).add(value);

                        if (backward.contains(word)) {
                            // 在这一层找到了，打个标记不用在往下一层继续了
                            succeed = true;
                        }
                    }
                }
                chars[i] = tmpChar;
            }

        }
        // 当前层已经处理完成了，要不要继续处理下一层了？
        // 通过succeed 标识来判断
        // succeed == false 继续处理
        if (!succeed) {
            bfs(nextLevelWords, backward, direction, dict, tree);
        }
    }
}