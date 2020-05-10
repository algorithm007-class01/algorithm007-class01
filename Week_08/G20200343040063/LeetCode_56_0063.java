class Solution {

    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals,  (a,b) ->  a[0] - b[0] );
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for(int i = 0; i < intervals.length ; i++) {
            // 1. 不合并
            if(index == -1 || intervals[i][0] > res[index][1]){
                res[++index] = intervals[i];
                continue;
            }
            // 2. 合并
            res[index][1] = Math.max(intervals[i][1],res[index][1]);
        }
        return Arrays.copyOf(res,index+1);
    }
    
}
