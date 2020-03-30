

public List<List<Integer>> combine(int n, int k) {

    List<List<Integer>> res = new ArrayList();

    backtrack(n, k, 1, res,new ArrayList());
    return res;
}

public void backtrack(int n, int k, int start, List res, List list) {
    if(list.size == k) {
        res.add(new ArrayList(list));
        return;
    }

    for(int i = start; i <= n; i ++) {
        list.add(i);
        helper(n, k, i + 1, res, list);
        list.remove(list.size() - 1);
    }
}