class Solution {
    public List<String> generateParenthesis(int n) {
        final List<String> ans = new ArrayList<>();
        // 入参校验
        if (n == 0) {
            return ans;
        }
        parenthesis("", 0, 0, n, ans);
        return ans;
    }

    private void parenthesis(String s, int left, int right, int n, List<String> ans) {
        // 终结条件
        // 左括号个数到达3个
        // 左括号个数与右括号个数相等
        if (left == n && left == right) {
            ans.add(s);
            return;
        }
        if (left < n) {
            parenthesis(s + "(", left + 1, right, n, ans);
        }
        if (right < left) {
            parenthesis(s + ")", left, right + 1, n, ans);
        }
    }
}