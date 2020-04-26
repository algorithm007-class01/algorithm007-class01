class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        final Integer[][] memo = new Integer[triangle.size()][triangle.size()];
        return helper(0, 0, triangle, memo);
    }

    private int helper(int level, int col, List<List<Integer>> triangle, Integer[][] memo) {
        if (memo[level][col] !=null) {
            return memo[level][col];
        }
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(col);
        }
        int left = helper(level + 1, col, triangle, memo);
        int right = helper(level + 1, col + 1, triangle, memo);
        return memo[level][col] = Math.min(left, right) + triangle.get(level).get(col);
    }
}