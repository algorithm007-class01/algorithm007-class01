#include <iostream>
#include <vector>

using namespace std;

/**
 * 题目：买卖股票的最佳时机II
 * solution: 使用贪心算法，只要连续2天股价上升，就可以当天买第二天卖，获取收益
 *          时间复杂度为O(n),空间复杂度为O(1)
 * test cases:空数组，正常数据[7,1,5,3,6,4]，返回false的数据[7,6,4,3,1]
*/

class Solution {
   public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0) return 0;
        int benifit = 0;
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) benifit += prices[i + 1] - prices[i];
        }
        return benifit;
    }
};
int main() {
    Solution solution = Solution();
    vector<int> t1;
    vector<int> t2{7, 1, 5, 3, 6, 4};
    vector<int> t3{7, 6, 4, 3, 1};
    cout << "res1:" << solution.maxProfit(t1) << endl;
    cout << "res2:" << solution.maxProfit(t2) << endl;
    cout << "res3:" << solution.maxProfit(t3) << endl;
}
