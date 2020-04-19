

public int ladderLength(String beginWord, String endWord, String[] wordList) {

    int L = beginWord.length;

    Map<String, List<String>> listMap = new HashMap();

    wordList.forEach(word -> {
        for(int i = 0; i < L; i++) {
            String newWord = word.substring(0, i) + "*" + word.substring(i+1,L);
            List<String> list = listMap.getOrDefault(newWord, new ArrayList());
            list.add(word);
            listMap.put(newWord, list);
        }
    });

    Queue<Pair<Srting, Integer>> queue = new LinkedList();

    quque.offer(new Pair<beginWord, 1>);

    Map<String, Boolean> visited = new HashMap<>();
    visited.put(beginWord, true);

    while(!queue.isEmpty()) {
        Pair<String, Integer> pair = queue.poll();
        String Key = pair.getKey();
        Integer level = pair.getValue();

        for(int i = 0; i < L; i ++) {
            String newWord = key.substring(0, i) + "*" + key.substring(i + 1, L);

            for(String adjacentWord : listMap.getOrDefault(newWord, new ArrayList())) {
                if(adjacentWord.equals(endWord)) {
                    return level + 1;
                }

                if(!visited.containsKey(beginWord)){

                    visited.put(beginWord, true);
                    queue.offer(new Pair(adjacent, level + 1));
                }
            }
        }
    }
    return 0;
}