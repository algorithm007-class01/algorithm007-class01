public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = (i-2>=0?dp[i-2]:0) + 2;
                } else if(i-dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = dp[i-1] + (i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0) + 2;
                }
                max = Math.max(dp[i],max);
            }
        }
        return max;
    }


    /**
     * 栈
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        int count = 0;
        if(s == null || s.length() <= 1){
            return count;
        }
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                } else {
                    count = Math.max(count, i-stack.peek());
                }
            }
        }
        return count;
    }
}