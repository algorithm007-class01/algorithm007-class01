//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索

  
  package com.Simba.algorithm007class01.leetcode.editor.cn.leetcode.editor.cn;

import android.os.Build.VERSION_CODES;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder{
      @RequiresApi(api = VERSION_CODES.N)
      public static void main(String[] args) {
           Solution solution = new WordLadder().new Solution();
           List<String> list=new ArrayList<>();
           list.add("hot");
           list.add("dot");
           list.add("dog");
           list.add("lot");
           list.add("log");
           list.add("cog");
         int a=  solution.ladderLength("hit","cog",list);
          System.out.printf(" "+a);

      }
//    算法与之前描述的标准广搜方法相类似。
//
//    唯一的不同是我们从两个节点同时开始搜索，同时搜索的结束条件也有所变化。
//
//    我们现在有两个访问数组，分别记录从对应的起点是否已经访问了该节点。
//
//    如果我们发现一个节点被两个搜索同时访问，就结束搜索过程。因为我们找到了双向搜索的交点。过程如同从中间相遇而不是沿着搜索路径一直走。
//
//    双向搜索的结束条件是找到一个单词被两边搜索都访问过了。
//
//    最短变换序列的长度就是中间节点在两边的层次之和。因此，我们可以在访问数组中记录节点的层次。

      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int ladderLength(String start, String end, List<String> dicts) {
              Set<String> set1 = new HashSet<String>();
              Set<String> set2 = new HashSet<String>();

              set1.add(start);
              set2.add(end);
              HashSet<String> dict=new HashSet<>(dicts);
              if(!dict.contains(end)){
                  return 0;
              }

              return helper(dict, set1, set2, 2);
          }




          int helper(Set<String> dict, Set<String> set1, Set<String> set2, int level) {
              if (set1.isEmpty()) return 0;

              if (set1.size() > set2.size()) return helper(dict, set2, set1, level);

              // remove words from both ends
              for (String word : set1) { dict.remove(word); };
              for (String word : set2) { dict.remove(word); };

              // the set for next level
              Set<String> set = new HashSet<String>();

              // for each string in the current level
              for (String str : set1) {
                  for (int i = 0; i < str.length(); i++) {
                      char[] chars = str.toCharArray();

                      // change letter at every position
                      for (char ch = 'a'; ch <= 'z'; ch++) {
                          chars[i] = ch;
                          String word = new String(chars);

                          // found the word in other end(set)
                          if (set2.contains(word)) {
                              return level + 1;
                          }

                          // if not, add to the next level
                          if (dict.contains(word)) {
                              set.add(word);
                          }
                      }
                  }
              }

              return helper(dict, set2, set, level + 1);
          }
      }

//leetcode submit region end(Prohibit modification and deletion)

  }