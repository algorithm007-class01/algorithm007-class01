//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static List<String> RESULT ;
    
    public List<String> generateParenthesis(int n) {
        RESULT = new ArrayList<>();
        _generate(0, 0, n, "");
        return RESULT;
    }
    
    private void _generate(int left, int right, int max, String s) {
        //terminator
        if (left == max && right == max) {
            RESULT.add(s);
            return ;
        }
        //process
        
        //drill down
        if (left < max)
            _generate(left + 1, right, max, s + '(');
        if (right < left)
            _generate(left, right + 1, max, s + ')');
        //reverse status
    }
}
//leetcode submit region end(Prohibit modification and deletion)
