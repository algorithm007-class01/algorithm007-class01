class Solution {
    private static char[] GEN_SEQ = {'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        if (bank.length == 0) {
            return -1;
        }
        final Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) {
            return -1;
        }
        final Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(start);
        endSet.add(end);
        int step = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            Set<String> next = new HashSet<>();
            for (String word : beginSet) {
                char[] words = word.toCharArray();
                for (int i = 0; i < words.length; i++) {
                    char old = words[i];
                    for (char ch : GEN_SEQ) {
                        words[i] = ch;
                        String tmp = String.valueOf(words);
                        if (endSet.contains(tmp)) {
                            return step + 1;
                        }
                        if (!visited.contains(tmp) && bankSet.contains(tmp)) {
                            next.add(tmp);
                            visited.add(tmp);
                        }
                    }
                    words[i] = old;
                }
            }
            step++;
            if (next.size() > endSet.size()) {
                beginSet = endSet;
                endSet = next;
            } else {
                beginSet = next;
            }
        }
        return -1;
    }

}