
public List<List<Integer>> permuteUnique(int[] nums) {

    List<List<Integer>> res = new ArrayList();

    Arrays.sort(nums);
    boolean[] used = new boolean[nums.length];

    backtrack(nums, res, list, used);
}

public void backtrack(int[] nums, List res, List list, boolean[] used) {
    if(list.size() == num.length) {
        res.add(new ArrayList(list));
        return;
    }

    for(int i = 0; i < nums.length; i ++) {
        if(used[i]) {
            continue;
        }
        if( i > 0 && nums[i] == nums[i = 1] && !used[i - 1 ]) {
            continue;
        }

        used[i] = true;
        list.add(nums[i]);
        backtrack(nums, res, list, used);

        used[i] = false;
        list.remove(list.size() - 1);
    }
}