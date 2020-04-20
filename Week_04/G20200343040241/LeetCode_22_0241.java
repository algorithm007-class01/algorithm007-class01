import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author wangcheng
 */
public class LeetCode_22_0241 {



    /**
     * 动态规划 时间复杂度
     *
     * @param n
     * @return
     */
    private ArrayList<String> target;
    public List<String> generateParenthesis(int n) {
        target = new ArrayList<String>();
        _generate(0, 0, n, "");
        return target;
    }

    private void _generate(int left, int right, int max, String s) {
        //terminator
        if (left == max && right == max) {
            target.add(s);
            return;
        }
        //process

        //drill down
        if (left < max)
            _generate(left + 1, right, max, s + "(");
        if (left > right)
            _generate(left, right + 1, max, s + ")");

        //reverse states
    }


    public static void main(String[] args) {
        LeetCode_22_0241 leetCode = new LeetCode_22_0241();
        System.out.println(leetCode.generateParenthesis(3));
    }
}
