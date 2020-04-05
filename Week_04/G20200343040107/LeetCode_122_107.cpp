#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0) {
            return 0;
        }

        int max_profit = 0;
        int len = prices.size();
        for(int i = 1; i < len; ++i) {
            if(prices[i] > prices[i-1]) {
                max_profit += prices[i] - prices[i-1];
            }
        }

        return max_profit;
    }
};

void test_case() {
    Solution sol;
    vector<int> test_1;
    cout << "test_1: max profit " << sol.maxProfit(test_1) << endl;
    vector<int> test_2 = {7,1,5,3,6,4};
    cout << "test_1: max profit " << sol.maxProfit(test_2) << endl;
    vector<int> test_3 = {1,2,3,4,5};
    cout << "test_1: max profit " << sol.maxProfit(test_3) << endl;
}

int main(int argc, char* argv[]) {
    test_case();
    return 0;
}
