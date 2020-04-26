package app;


public class LeetCode_32_0333 {
    public int longestValidParentheses(String s) {
        if(null==s||s.length()<=1) return 0;
        return solutionMineDp(s);
    }
    /**
    ** dp
    ** int preDp=i-dp[i-1];
    ** preDp: 前一个有效括号长度状态 用于(()) 这样的))嵌套问题 (())) 如果无效则0
    ** preDp需要减去1 就是前一个有效位置下标preDpPos
    ** dp[i]=dp[i-1]+2;//长度加2，表示左右两个括号匹配好了
    ** preDpPos-1:有效左括号位置
    ** (preDpPos>0?dp[preDpPos-1]:0) preDpPos即上一个有效括号的位置，无效则0 preDpPos-1就是')'位置 解决))这样嵌套问题的
    **/
    private int solutionMineDp(String s){
        int maxans = 0;
        int dp[] = new int[s.length()];
        char[] arr=s.toCharArray();
        for(int i=1;i<arr.length;i++){
            if(arr[i]==')'){//当匹配为右括号时，尝试向前匹配左括号
                int preDp=i-dp[i-1];//
                int preDpPos=preDp-1;//
                if(preDpPos>=0&&arr[preDpPos]=='('){ 

                    dp[i]=(dp[i-1]+2) + (preDpPos>0?dp[preDpPos-1]:0);   
                    maxans = Math.max(maxans, dp[i]);               
                }
                
            }

        }
        return maxans;
    }
}