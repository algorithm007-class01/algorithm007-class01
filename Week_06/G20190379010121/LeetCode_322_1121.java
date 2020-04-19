class Solution {

    //贪心 dfs
    private int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        this.min = Integer.MAX_VALUE;
        Arrays.sort(coins);
        find(coins,amount,coins.length-1,0);
        return this.min == Integer.MAX_VALUE ? -1 : this.min;
    }
    private void find(int[] coins, int amount,int level,int count){
        if(amount == 0){
            this.min = Math.min(this.min,count);
            return ;
        }
        if(amount < 0 || level < 0){
            return;
        }
        for(int step = amount /  coins[level]; step >= 0 && step + count < this.min;step --){
            find(coins,amount- step * coins[level],level-1,count + step );
        }

    }

    // dp 自顶向下
    public int coinChange(int[] coins, int amount) {
        if(amount < 1){
            return 0;
        }
        int [] rem = new int[amount];
        return coinChange(coins,amount,rem);
    }
    private int coinChange(int[] coins, int amount,int [] rem){
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        int ans = rem[amount-1];
        if(ans != 0){
            return ans;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < coins.length; i ++){
            int res = coinChange(coins,amount-coins[i],rem);
            if(res >= 0  && res < min){
                min = res + 1;
            }
        }
        rem[amount-1] = min == Integer.MAX_VALUE ? -1 : min;
        return rem[amount-1];
    }

    //dp 自底向上
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}