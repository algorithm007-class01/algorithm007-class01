/**
* Summary : climbing-stairs
* Parameters : 
*   n : stairs size
* Return : number of different methods
*/
class Solution {
public:
    int climbStairs(int n) {
        vector<int> memo(n+1, 0);
        return climbStairs(n, memo); 
		/*
		return climbStairs(0, n, memo);
		*/
    }
    int climbStairs(int n, vector<int>& memo) {
        if (n < 2) return 1;
        if (memo[n] > 0) return memo[n];

        memo[n] = climbStairs(n-1, memo) + climbStairs(n-2, memo);
        return memo[n];
    }
	/*
    int climbStairs(int level, int n, vector<int>& memo) {
        if (level > n) return 0;
        if (level == n) return 1;

        if (memo[level] > 0) return memo[level];
        memo[level] = climbStairs(level+1, n, memo) + climbStairs(level+2, n, memo);
        
        return memo[level];
    }	
	*/
};