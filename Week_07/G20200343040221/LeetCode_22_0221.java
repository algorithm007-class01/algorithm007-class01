//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

//    public static void main(String[] args) {
//        Solution solution = new GenerateParentheses_22().new Solution();
//        System.out.println(solution);
//    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // DFS
    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<>();
        dfs("(", 1, 0, n, r);
        return r;
    }
    private void dfs(String prefix, int leftCount, int rightCount, int count, List<String> list) {
        if (leftCount > count || rightCount > count || rightCount > leftCount) {
            return;
        }
        if (leftCount == count && rightCount == count) {
            list.add(prefix);
            return;
        }

        dfs(prefix + "(", leftCount + 1, rightCount, count, list);
        dfs(prefix + ")", leftCount, rightCount + 1, count, list);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
  