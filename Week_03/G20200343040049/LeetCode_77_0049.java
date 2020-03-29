class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0) return  new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        generate(ans, new ArrayList<Integer>(), n, k, 1);
        return ans;
    }

    private void generate(List<List<Integer>> ans, ArrayList<Integer> list, int n, int k, int start) {
        if (k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; ++i) {
            list.add(i);
            generate(ans, list, n, k - 1, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
