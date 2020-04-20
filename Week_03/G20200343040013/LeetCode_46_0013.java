
public List<List<Integer>> permute(int[] nums) {

    List<List<Integer>> res = new ArrayList();

    backtrack(nums, res, new ArrayList());
    return res;
}

private void backtrack(int[] nums, List res, List list) {
    if(list.size() == nums.length) {
        res.add(new ArrayList(list));
        return;
    }

    for(int i = 0; i < nums.length; i++) {
        if (list.contains(nums[i])) {
            continue;
        }
        list.add(nums[i]);
        backtrack(nums, res, list);
        list.remove(list.size() - 1);
    }
}