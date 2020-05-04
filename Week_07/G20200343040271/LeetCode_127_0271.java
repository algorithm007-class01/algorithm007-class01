/**
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *   输入:
 *   beginWord = "hit",
 *   endWord = "cog",
 *   wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 *
 */
public class WordLadder {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        List<String> listb = Arrays.asList("a","b","c");
        System.out.println(new WordLadder().ladderLength_2("a","c",listb));
    }

    Map<String,List<String>> allWildcardMap = new HashMap<>();

    /**
     * 双向BFS
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength_2(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        preHandler(wordList);
        Queue<Pair<String,Integer>> start_queue = new LinkedList<>();
        Queue<Pair<String,Integer>> end_queue = new LinkedList<>();
        Map<String,Integer> start_visited = new HashMap<>();
        Map<String,Integer> end_visited = new HashMap<>();
        start_queue.offer(new Pair<>(beginWord,1));
        end_queue.offer(new Pair<>(endWord,1));
        start_visited.put(beginWord,1);
        end_visited.put(endWord, 1);

        while (!start_queue.isEmpty() && !end_queue.isEmpty()){
            int ans = visitElement(start_queue, start_visited, end_visited);
            if(ans > -1){
                return ans;
            }
            ans = visitElement(end_queue, end_visited, start_visited);
            if(ans > -1){
                return ans;
            }
        }
        return 0;
    }

    private int visitElement(Queue<Pair<String, Integer>> queue,
                             Map<String,Integer> start_visited,
                             Map<String,Integer> end_visited) {
        Pair<String,Integer> element = queue.poll();
        String word = element.getKey();
        Integer level = element.getValue();

        for (int i = 0; i < word.length(); i++) {
            String newword = word.substring(0,i) + "*" + word.substring(i+1);
            for (String s: allWildcardMap.getOrDefault(newword, new ArrayList<>())) {
                if(end_visited.containsKey(s)){
                    return level+ end_visited.get(s);
                }

                if(!start_visited.containsKey(s)){
                    start_visited.put(s, level +1);
                    queue.add(new Pair<>(s, level + 1));
                }
            }
        }
        return -1;
    }


    /**
     * 广度优先
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        preHandler(wordList);
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Pair<>(beginWord,1));
        visited.add(beginWord);
        while (!queue.isEmpty()){
            Pair<String,Integer> pair = queue.poll();
            String word = pair.getKey();
            Integer count = pair.getValue();
            for (int i = 0; i < word.length(); i++) {
                String wildCardWord = word.substring(0,i) + '*' + word.substring(i+1,word.length());
                List<String> transformations = allWildcardMap.getOrDefault(wildCardWord, new ArrayList<>());
                for (String tran : transformations) {
                    if(tran.equals(endWord)){
                        return ++count;
                    }
                    if(!visited.contains(tran)){
                        visited.add(tran);
                        queue.add(new Pair<>(tran,count+1));
                    }
                }

            }
        }
        return 0;
    }

    private void preHandler(List<String> wordList) {
        wordList.forEach(word->{
            for (int i = 0; i < word.length(); i++) {
                // h*t
                String wildCardWord = word.substring(0,i) + '*' + word.substring(i+1,word.length());
                List<String> transformations = allWildcardMap.getOrDefault(wildCardWord, new ArrayList<>());
                transformations.add(word);
                // h*t -> hot
                allWildcardMap.put(wildCardWord, transformations);
            }
        });
    }

}