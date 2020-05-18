/**
 *  单词接龙
 */
public class LeetCode127 {

//    // BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 队列
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        boolean[] index = new boolean[wordList.size()];
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String start = queue.poll();
                for (int j = 0 ; j < wordList.size();j++) {
                    String word = wordList.get(j);
                    if(index[j]){
                        continue;
                    }
                    if(!canConvert(start,word)){
                        continue;
                    }
                    System.out.println("word - > "+ word);
                    if(word.equals(endWord)){
                        return count+1;
                    }
                    queue.add(word);
                    index[j] = true;
                }
            }
        }
        return 0;
    }

    private boolean canConvert(String start, String word) {
        if(start.length() != word.length()){
            return false;
        }
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if(start.charAt(i) != word.charAt(i)){
                if(++count > 1) return false;
            }
        }
        return count == 1;
    }

}