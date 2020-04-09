class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res,1,n,k,new ArrayList<Integer>());
        return res;
    }
    private void combine(List<List<Integer>> res,int level,int n,int k,List<Integer> list){
        if(level > n){
            if(list.size()== k){
                res.add(new ArrayList(list));
            }
            return ;
        }
        if(list.size()== k){
            res.add(new ArrayList(list));
            return ;
        }
        combine(res,level + 1,n,k,list);

        list.add(level);
        combine(res,level + 1,n,k,list);

        list.remove(list.size()-1);
    }
}