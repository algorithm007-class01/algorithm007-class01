class Solution {
  /**
   *
   *
   * 思路：广度优先搜索
   * 1.遍历字典表，为字典中的每一个单词制作通配单词，记入HashMap
   * 2.逐层遍历单词，每个单词找所有通配单词对应的字典真实单词
   * 3.如果找到相邻单词，判断是否为目标单词，如果不是，则加入队列进行下一层处理（防止环，要记录visted过的元素）
   *
   * 时间复杂度：O(M * N)
   *    其中 M 是单词的长度 N 是单词表中单词的总数。
   *    找到所有的变换需要对每个单词做 M 次操作。
   *    同时，最坏情况下广度优先搜索也要访问所有的 N 个单词。
   *
   * 空间复杂度：O(M * N)
   *    要在 all_combo_dict 字典中记录每个单词的 M 个通用状态。
   *    访问数组的大小是 N。广搜队列最坏情况下需要存储 N 个单词。
   *
   **/

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    if (beginWord.equals(endWord) || !wordList.contains(endWord)) {
      return 0;
    }

    // 所有单词长度一致
    int wordLength = beginWord.length();

    // 单词列表中每个单词，逐个位置，更换一个字母之后的所有通用单词组合
    HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();
    wordList.forEach(
        word -> {
          for (int i = 0; i < wordLength; i++) {
            // key：替换了一个字母的通配单词
            // value：原先的单词
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, wordLength);// 逐个位置替换为通配字符*
            ArrayList<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<String>());
            transformations.add(word);
            allComboDict.put(newWord, transformations);// 放入HashMap
          }
        });

    // 为了BFS-广度优先遍历而定义的queue
    Queue<Pair<String, Integer>> queue = new LinkedList<Pair<String, Integer>>();
    queue.add(new Pair(beginWord, 1));// 为什么从1开始？测试用例 "hit","hot",["hot"]，结果为2步。。。

    // 定义一个已经遍历过的单词列表，防止重复处理（防止环）
    HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
    visited.put(beginWord, true);

    while (!queue.isEmpty()) {
      Pair<String, Integer> currentNode = queue.remove();
      String currentWord = currentNode.getKey();// 当前单词
      int currentLevel = currentNode.getValue();// 当前层级
      for (int i = 0; i < wordLength; i++) {// 第1层for：开始处理当前单词

        // 表示当前单词的中间词
        String newWord = currentWord.substring(0, i) + '*' + currentWord.substring(i + 1, wordLength);

        // 遍历所有匹配当前中间词的真实单词
        for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {// 第2层for：找到当前单词的所有相邻词
          // 如果我们找到的词和目标词一致，则得到答案。
          if (adjacentWord.equals(endWord)) {
            return currentLevel + 1;
          }
          // Otherwise, add it to the BFS Queue. Also mark it visited
          // 如果不相符，作为下一层的元素，加入到queue（要保证之前没有被遍历过，防止环的出现，元素不断相互重复加入queue，造成死循环，比如lot加hot，hot加lot）
          if (!visited.containsKey(adjacentWord)) {
            visited.put(adjacentWord, true);
            queue.add(new Pair(adjacentWord, currentLevel + 1));
          }
        }// end of for 第2层
      }// end of for 第1层
    }// end of while

    return 0;
  }
}