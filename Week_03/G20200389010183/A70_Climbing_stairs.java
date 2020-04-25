package com.szp.leetcode.q51_100;

public class A70_Climbing_stairs {
    class Solution {
        public int climbStairs(int n) {
            if(n == 1 || n ==2)
                return n;
            int n1 = 1,n2 = 2,result = 3;
            for(int i = 3; i <= n; i++){
                result = n1 + n2;
                n1 = n2;
                n2 =result;
            }
            return result;
        }
    }
}
