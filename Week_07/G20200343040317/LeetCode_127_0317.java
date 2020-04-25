class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0 || !wordList.contains(endWord)) {
            return 0;
        }
        final Set<String> dict = new HashSet<>(wordList);
        Set<String> frond = new HashSet<>();
        Set<String> end = new HashSet<>();
        frond.add(beginWord);
        end.add(endWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int len = 1;
        while (!frond.isEmpty() && !end.isEmpty()) {
            // 从小的开始
            if (frond.size() > end.size()) {
                Set<String> tmp = frond;
                frond = end;
                end = tmp;
            }
            Set<String> next = new HashSet<>();
            for (String word : frond) {
                char[] words = word.toCharArray();
                for (int i = 0; i < words.length; i++) {
                    char old = words[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        words[i] = ch;
                        String newWord = String.valueOf(words);
                        if (end.contains(newWord)) {
                            return len + 1;
                        }
                        if (!visited.contains(newWord) && dict.contains(newWord)) {
                            visited.add(newWord);
                            next.add(newWord);
                        }
                    }
                    words[i] = old;
                }
            }
            // 进行下一轮
            len++;
            frond = next;
        }
        return 0;
    }
}