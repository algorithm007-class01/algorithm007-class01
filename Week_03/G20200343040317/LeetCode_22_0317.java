class Solution {
    final ArrayList<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return result;
    }

    private void generate(int left, int right, int n, String s) {
        if (left == n && left == right) {
            result.add(s);
            return;
        }
        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if (right < left) {
            generate(left, right + 1, n, s + ")");
        }
    }
}