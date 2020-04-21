package com.szp.leetcode.q201_250;

public class A221_maximal_square {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if (null == matrix || matrix.length == 0 || matrix[0].length == 0)
                return 0;
            int m = matrix.length, n = matrix[0].length;
            int[] dp = new int[n];
            int maxLen = 0;
            for (int i = 0; i < n; i++) {
                dp[i] = matrix[m - 1][i] == '1' ? 1 : 0;
                if (dp[i] > maxLen)
                    maxLen = dp[i];
            }
            for (int i = m - 2; i >= 0; i--) {
                int tmp = 0;
                for (int j = n - 1; j >= 0; j--) {
                    if (j == n - 1) {
                        tmp = dp[j];
                        dp[j] = matrix[i][j] == '1' ? 1 : 0;
                    }
                    //判断i,j与i+1,j+1能否构成正方形
                    else {
                        int len = tmp;
                        tmp = dp[j];
                        if (matrix[i][j] == '0') {
                            dp[j] = 0;
//                            System.out.print(dp[j] +",");
                            continue;
                        }
//                        System.out.print(dp[j] +",");
                        dp[j] = checkValidSquare(i,j,len,matrix)+1;
                    }
                    if (dp[j] > maxLen) {
                        maxLen = dp[j];
                        if (maxLen == m || maxLen == n)
                            return maxLen * maxLen;
                    }
                }
//                System.out.println();

            }

            return maxLen * maxLen;
        }

        private int checkValidSquare(int i, int j, int len, char[][] matrix) {
//            System.out.println(i);
//            System.out.println(j);
//            System.out.println(len);
            for (int k = 1; k <= len; k++) {
//                System.out.println(k);
                if (matrix[i + k][j] == '0' || matrix[i][j + k] == '0')
                    return k-1;
            }
            return len;

        }
    }

    public static void main(String[] args) {
        Solution solution = new A221_maximal_square().new Solution();
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(solution.maximalSquare(matrix));
        matrix = new char[][]{
                {'1', '1', '1', '1', '1'},
                {'1' ,'1' ,'1' ,'1' ,'1'},
                {'1', '1', '1', '1', '1'},
                {'1' ,'1' ,'1' ,'1' ,'1'}
        };
        System.out.println(solution.maximalSquare(matrix));
        matrix = new char[][]{
                {'1', '1', '1', '1', '1'},
                {'1' ,'1' ,'1' ,'1' ,'1'},
                {'1', '1', '1', '1', '1'},
                {'1' ,'1' ,'1' ,'1' ,'1'},
                {'1' ,'1' ,'0' ,'1' ,'1'}
        };
        System.out.println(solution.maximalSquare(matrix));
        matrix = new char[][]{
                {'1', '1', '1', '1', '1'},
                {'1' ,'1' ,'1' ,'1' ,'1'},
                {'1', '1', '0', '1', '1'},
                {'1' ,'1' ,'1' ,'1' ,'1'},
                {'1' ,'1' ,'1' ,'1' ,'1'}
        };
        System.out.println(solution.maximalSquare(matrix));
        matrix = new char[][]{
                {'0', '0', '0', '0', '0'},
                {'0' ,'0' ,'0' ,'0' ,'0'},
                {'0', '0', '0', '0', '1'},
                {'0' ,'0' ,'0' ,'0' ,'0'},
                {'0' ,'0' ,'0' ,'0' ,'0'}
        };
        System.out.println(solution.maximalSquare(matrix));
    }

    public class Solution2 {
        public int maximalSquare(char[][] matrix) {
            int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
            int[] dp = new int[cols + 1];
            int maxsqlen = 0, prev = 0;
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    int temp = dp[j];
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                        maxsqlen = Math.max(maxsqlen, dp[j]);
                    } else {
                        dp[j] = 0;
                    }
                    prev = temp;
                }
            }
            return maxsqlen * maxsqlen;
        }
    }
}
