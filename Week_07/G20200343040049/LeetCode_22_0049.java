class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        recurser(ans, "", 0, 0, n);
        return ans;
    }
    private void recurser(List<String> ans,  String str, int leftLengeh, int rightLength, int n) {
        if (leftLengeh == n && rightLength == n) {
            ans.add(str);
            return;
        }

        if (leftLengeh < n) {
            recurser(ans, str + "(", leftLengeh + 1, rightLength, n);
        }

        if (rightLength < leftLengeh) {
            recurser(ans, str + ")", leftLengeh, rightLength + 1, n);
        }
    }
}
