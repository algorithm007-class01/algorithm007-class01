class Solution {
private:
    int nums[100] = {0};
public:
    int climbStairs(int n) {
        // int a=1,b=2,sum;
        // if(n <= 2) return n;
        // for(int i=3; i<=n; i++){
        //     sum = a + b;
        //     a = b;
        //     b = sum;
        // }
        // return sum;
        nums[0] = 1;
        nums[1] = 1;
        for(int i = 2; i <= n; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[n];
    }
};