package l01.n22;//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
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


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> s = new ArrayList<>();
        generateParenthesis(s, 0, 0, "", n);
        return s;
    }

    public void generateParenthesis(List<String> res, int left, int right, String parent, int n) {
        if (left == n && right == n) {
            res.add(parent);
            return;
        }
        if (left < n) {
            generateParenthesis(res, left + 1, right, parent+"(", n);
        }
        if (right < left) {
            generateParenthesis(res, left, right + 1, parent+")", n);
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
