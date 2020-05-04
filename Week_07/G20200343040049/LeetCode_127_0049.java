class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;

        Queue<String> queue1 = new LinkedList<>(List.of(beginWord));
        Queue<String> queue2 = new LinkedList<>(List.of(endWord));
        Set<String> visited1 = new HashSet<>(List.of(beginWord));
        Set<String> visited2 = new HashSet<>(List.of(endWord));

        Set<String> dict = new HashSet<>(wordList);
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
            int size = queue1.size();
            count++;
            while (size-- > 0) {
                String s = queue1.poll();
//                for (String str : wordList) {
//                    if (visited1.contains(str))
//                        continue;
//                    if (!canMatched(s, str))
//                        continue;
//                    if (visited2.contains(str))
//                        return count + 1;
//                    visited1.add(str);
//                    queue1.add(str);
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; ++i) {
                    char c0 = chars[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[i] = c;
                        String temp = String.valueOf(chars);
                        if (visited1.contains(temp)) continue;
                        // 此处visited2的判断一定要在dict前
                        if (visited2.contains(temp)) return count + 1;
                        if (!dict.contains(temp)) continue;

                        dict.remove(temp);
                        queue1.add(temp);
                        visited1.add(temp);
                    }
                    chars[i] = c0;
                }
            }
        }
        return 0;
    }
    private boolean canMatched(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++count > 1) return false;
            }
        }
        return count == 1;
    }
}
