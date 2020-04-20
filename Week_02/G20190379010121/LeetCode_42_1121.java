class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int res = 0;
        for(int i = 1;i < len-1;i ++){
            int max_left = 0;
            int max_right = 0;
            for(int j = i ;j >= 0;j --){
                max_left = Math.max(max_left,height[j]);
            }
            for(int j = i;j < len;j ++){
                max_right = Math.max(max_right,height[j]);
            }
            res += Math.min(max_right,max_left)- height[i];
        }
        return res;
    }
}