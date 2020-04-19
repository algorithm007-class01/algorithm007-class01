class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int self = triangle.get(i).get(j);
                int res = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + self;
                triangle.get(i).set(j, res);
            }
        }
        return triangle.get(0).get(0);
    }
}