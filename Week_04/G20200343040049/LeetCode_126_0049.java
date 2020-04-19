class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> allWords = new HashSet<>(wordList);
        if (!allWords.contains(endWord)) return new ArrayList<>();

        Set<String> begin = new HashSet<>(List.of(beginWord));
        Set<String> end = new HashSet<>(List.of(endWord));

        Map<String, List<String>> neighborsMap = new HashMap<>();
        if (!doubleBfs(begin, end, neighborsMap, true, allWords)) return new ArrayList<>();

        List<List<String>> res = new ArrayList<>();
        dfs(neighborsMap, res, beginWord, endWord, new LinkedList<>());

        return res;
    }

    private boolean doubleBfs(Set<String> begin, Set<String> end, Map<String, List<String>> neighborsMap,
                              boolean isFromHeadToEnd, Set<String> allWords) {
        if (begin.size() == 0) return false;

        allWords.removeAll(begin);

        boolean isMeetInCurLevel = false;

        Set<String> nextLevel = new HashSet<>();
        for (String s : begin) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; ++i) {
                char c0 = chars[i];
                for (char c = 'a'; c <= 'z'; ++c) {
                    chars[i] = c;
                    String temp = String.valueOf(chars);
                    // allWords不含：已被添加进Map中
                    // allWords含：1. 未被发现过的点，2. 已被另一端加进nextLevel的点
                    if (!allWords.contains(temp)) {
                        continue;
                    }

                    nextLevel.add(temp);

                    if (end.contains(temp)) {
                        isMeetInCurLevel = true;
                    }

                    String key = isFromHeadToEnd ? s : temp;
                    String value = isFromHeadToEnd ? temp : s;
                    if (!neighborsMap.containsKey(key)) neighborsMap.put(key, new ArrayList<String>());
                    neighborsMap.get(key).add(value);
                }
                chars[i] = c0;
            }
        }
        if (isMeetInCurLevel) {
            return true;
        }

        if (nextLevel.size() > end.size()) {
            return doubleBfs(end, nextLevel, neighborsMap, !isFromHeadToEnd, allWords);
        } else {
            return doubleBfs(nextLevel, end, neighborsMap, isFromHeadToEnd, allWords);
        }
    }
    private void dfs(Map<String, List<String>> neighborsMap, List<List<String>> res, String begin, String end, Deque<String> path) {
        // if (res.size() > 0 && path.size() == 0) return;

        path.addLast(begin);

        if (begin.equals(end)) {
            res.add(new ArrayList<>(path));
        } else if (neighborsMap.containsKey(begin)) {
            for (String s : neighborsMap.get(begin)) {
                dfs(neighborsMap, res, s, end, path);
            }
        }
        path.removeLast();
    }
}