class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        generator(list,nums,new Stack<>(),-1);
        return list;
    }

    public void generator(List<List<Integer>> list,int[] nums,Stack<Integer> stack,int s){
        if (s==nums.length){
            list.add(new ArrayList<>(stack));
            return;
        }
        for (int i=0;i<nums.length;++i){
            if (i==s){
                continue;
            }
            stack.push(nums[i]);
            generator(list,nums,stack,i);
            stack.pop();
        }
    }
}