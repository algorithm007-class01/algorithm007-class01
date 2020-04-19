class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size()== 0){
            return 0;
        }
        Map<Integer,Map<Integer,Integer>> visited = new HashMap<>();
        for(int level = 0;level < triangle.size()+1;level ++){
            visited.put(level,new HashMap<Integer,Integer>());
        }
        return getmin(triangle,0,0,visited);
    }
    private int getmin(List<List<Integer>> triangle,int level,int i,Map<Integer,Map<Integer,Integer>> visited){
        if(level >= triangle.size() || i >= triangle.get(level).size() ){
            return 0;
        }

        Integer leftVal = visited.get(level+1).get(i);
        if(leftVal == null){
            leftVal= getmin(triangle,level + 1,i,visited);
            visited.get(level + 1).put(i,leftVal);
        }
        Integer rightVal = visited.get(level +1).get(i + 1);
        if(rightVal == null){
            rightVal = getmin(triangle,level + 1,i + 1,visited);
            visited.get(level + 1).put(i + 1,rightVal);
        }
        return Math.min(leftVal,rightVal) + triangle.get(level).get(i);
    }

    //dp 自顶向下
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int size = triangle.size();
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for(int level = 1;level < size;level++){
            List<Integer> row = triangle.get(level);
            for(int i = 0; i < row.size();i ++){
                int left = get(dp,level-1,i-1,triangle.get(level-1).size());
                int right = get(dp,level-1,i,triangle.get(level-1).size());
                dp[level][i] = Math.min(left,right) + row.get(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i< size;i ++){
            min = Math.min(min,dp[size-1][i]);
        }
        return min;
    }
    private int get(int[][] dp,int level,int i,int len){
        if(i < 0 || i >= len){
            return Integer.MAX_VALUE;
        }
        return dp[level][i];
    }

    //dp 自底向上
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int size = triangle.size();
        int [][] dp = new int[size][size];
        for(int i = 0;i < size;i ++){
            dp[size-1][i] = triangle.get(size-1).get(i);
        }
        for(int level = size -2; level >= 0;level --){
            List<Integer> row = triangle.get(level);
            for(int i = 0;i < row.size(); i ++){
                dp[level][i] = Math.min(dp[level+1][i],dp[level+1][i +1]) + triangle.get(level).get(i);
            }
        }
        return dp[0][0];
    }
}