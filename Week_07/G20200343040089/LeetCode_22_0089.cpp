//	Use pruning to generate parentheses
class Solution {
public:
    vector<string> result;
    vector<string> generateParenthesis(int n) {
        if (n == 0) return result;
        generateParenthesis(0, 0, n, "");
        return result;
    }
    void generateParenthesis(int left, int right, int n, string str) {
        if (left  == n && right == n) {
            result.push_back(str);
            return ;
        }
		// 左括号个数小于n时都可以加左括号
        if (left < n) {
            generateParenthesis(left + 1, right, n, str + "(");
        }
		// 右括号个数大于左括号个数时才可以加右括号
        if (right < left) {
            generateParenthesis(left, right + 1, n, str + ")");
        }
    }
};