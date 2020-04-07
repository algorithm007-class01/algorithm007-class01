class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        wordList.add(beginWord);
        int start = wordList.size() - 1;
        Queue<String> queue1 = new LinkedList<>(List.of(beginWord));
        Queue<String> queue2 = new LinkedList<>(List.of(endWord));
        Set<String> visited1 = new HashSet<>(List.of(beginWord));
        Set<String> visited2 = new HashSet<>(List.of(endWord));
        Set<String> allWord = new HashSet<>(wordList);
        int count = 0;

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.size() > queue2.size()) {
                Queue<String> q = queue1;
                queue1 = queue2;
                queue2 = q;

                Set<String> v = visited1;
                visited1 = visited2;
                visited2 = v;
            }
            count++;
            int size = queue1.size();
            while (size-- > 0) {
                String s = queue1.poll();
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; ++i) {
                    char c0 = chars[i];
                    for (char c = 'a'; c < 'z'; ++c) {
                        chars[i] = c;
                        String temp = String.valueOf(chars);
                        if (!allWord.contains(temp)) {
                            continue;
                        }
                        if (visited1.contains(temp)) {
                            continue;
                        }
                        if (visited2.contains(temp)) {
                            return count + 1;
                        }
                        visited1.add(temp);
                        queue1.offer(temp);
                    }
                    chars[i] = c0;
                }
            }
        }
        return 0;
    }
}