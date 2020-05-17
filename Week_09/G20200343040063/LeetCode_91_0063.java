class Solution {

    // 动态规划解法
    public int numDecodings(String s) {
        // 定义状态
        int len = s.length();
        int a = 1; // y
        int res = 0;
        if(s.charAt(len-1) != '0'){
            res = 1;
        }
        for(int i = len - 2 ; i>=0 ; i--  ){
            if (s.charAt(i) == '0') {
                a = res;
                res = 0;
                continue;
            }
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if( ten + one <= 26 ){
                res += a;
                a = res - a;
            }else{
                a = res;
            }
        }
        return res;
    }

    // 递归解法  
    Map<Integer,Integer> m ;
    public int numDecodings(String s) {
        m = new HashMap<Integer,Integer>();
        return helper(s,0);
    }

    private int helper(String s,int start){
        if(start == s.length()){
            return 1;
        }
        if(s.charAt(start) == '0'){
            return 0;
        }
        // 从缓存中获取
        Integer v = m.get(start);
        if( v != null){
            return v;
        }

        int ret1 = helper(s,start+1);
        int ret2 = 0;
        if(start < s.length() -1 ){
            int ten = (s.charAt(start) - '0')* 10;
            int one = s.charAt(start+1) - '0';
            if(ten + one <= 26 ){ 
                ret2 = helper(s,start+2);
             }
        }
        int ret = ret1+ret2;
        m.put(start,ret);
        return ret;
    }
}