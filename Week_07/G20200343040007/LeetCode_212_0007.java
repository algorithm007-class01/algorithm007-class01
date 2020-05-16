//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result = new ArrayList<>();
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words)
            if (including(word, board))
                result.add(word);
        return result;
    }

    private boolean including(String s, char[][] board) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                if (board[i][j] == chars[0]) {
                    boolean[][] visited =new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    if (dfs(i, j, chars, 1, board, visited))
                        return true;
                }
        return false;
    }

    private boolean dfs(int row, int col, char[] chars, int level, char[][] board, boolean[][] visited) {
        if (level == chars.length) return true;
        boolean temp = false;
        for (int index = 0; index < 4; ++index) {
            int i = row + dx[index];
            int j = col + dy[index];
            if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && !visited[i][j] && board[i][j] == chars[level]) {
                visited[i][j] = true;
                temp = temp || dfs(i, j, chars, level + 1, board, visited);
                if (temp) return true;
                visited[i][j] = false;
            }
        }
        return temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
