/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 *   输入：n = 3
 *   输出：[
 *          "((()))",
 *          "(()())",
 *          "(())()",
 *          "()(())",
 *          "()()()"
 *        ]
 *
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(2));
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0,0, n, "", ans);
        return ans;
    }

    /**
     * 括号，优化方式：剪枝
     * @param left
     * @param right
     * @param n
     * @param s
     * @param ans
     */
    private void generate(int left, int right, int n, String s,List<String> ans) {
        if(left == n && right == n){
            ans.add(s);
            return;
        }

        if(left < n) // 左括号未用完
            generate(left+1, right, n, s + "(", ans);

        if(left > right) // 左括号比有括号多
            generate(left, right+1, n, s + ")", ans);


    }
}