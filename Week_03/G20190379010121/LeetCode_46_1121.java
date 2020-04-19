class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        permute(res,nums,0,new ArrayList());
        return res;
    }
    public void permute(List<List<Integer>> res,int[] nums,int level,List<Integer> list){
        if(level > nums.length-1){
            res.add(new ArrayList(list));
            return;
        }
        for(int start = 0; start < nums.length; start ++){
            if(list.contains(nums[start])){
                continue;
            }
            list.add(nums[start]);
            permute(res,nums,level+1,list);
            list.remove(list.size()-1);
        }

    }
}