class Solution {
    public int maxProduct(int[] nums) {
        // 定义状态
        // dp[i] 0..i的状态数据
        Tuple[] dp = new Tuple[nums.length];
        dp[0] = new Tuple(nums[0], nums[0]);
        int ans = dp[0].max;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = new Tuple(
                    Math.max(nums[i], Math.max(nums[i] * dp[i - 1].max, nums[i] * dp[i - 1].min)),
                    Math.min(nums[i], Math.min(nums[i] * dp[i - 1].max, nums[i] * dp[i - 1].min))
            );
            ans = Math.max(ans, dp[i].max);
        }
        return ans;
    }

    class Tuple {
        private int max;
        private int min;

        public Tuple(int max, int min) {
            this.max = max;
            this.min = min;
        }

        @Override
        public String toString() {
            return String.format("max: %s min: %s", max, min);
        }
    }
}