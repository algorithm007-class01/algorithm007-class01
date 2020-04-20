#include <iostream>
#include <vector>

using namespace std;

/**
 * 题目：返回组合的结果（二维数组）
 * solution1: 使用回溯算法
 *          时间复杂度为C(n,k),空间复杂度为C(n,k)
 * solution2: 直接遍历求解法
 *          时间复杂度为C(n,k),空间复杂度为C(n,k)
*/
class Solution {
   public:
   /**
     * 使用辅助函数进行递归
    */
    vector<vector<int>> res;
    vector<vector<int>> combine(int n, int k) {
        if (n < k) return res;
        vector<int> arr(k, 0);
        helper(n, k, 0, 0, arr);
        return res;
    }
    void helper(int n, int k, int n_pos, int k_pos, vector<int>& arr) {
        if (n - n_pos < k - k_pos) return;
        if (k_pos == k) {
            res.push_back(arr);
            return;
        }
        // 数字从1开始
        arr[k_pos] = n_pos + 1;              
        helper(n, k, n_pos + 1, k_pos + 1, arr); 
        helper(n, k, n_pos + 1, k_pos, arr); 
    }

    // 使用辅助数组记录法，循环处理
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> a;
        vector<int> b(k, 0);
        int i = 0;
        while (i >= 0) {
            b[i]++;
            if (b[i] > n)
                i--;
            else if (i == k - 1)
                a.push_back(b);
            else {
                i++;
                b[i] = b[i - 1];
            }
        }
        return a;
    }
};