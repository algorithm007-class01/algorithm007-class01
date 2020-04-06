#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        if(bills.empty()) {
            return true;
        }

        int len = bills.size();
        int five_num = 0;
        int ten_num = 0;
        for(int i = 0; i < len; ++i) {
            if(bills[i] == 5) {
                ++five_num;
            }
            else if(bills[i] == 10) {
                if(five_num == 0) {
                    return false;
                }
                ++ten_num;
                --five_num;
            }
            else {
                if(five_num > 0 && ten_num >0) {
                    --five_num;
                    --ten_num;
                }
                else if (five_num >= 3) {
                    five_num -= 3;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }
};

void test_case() {
	Solution sol;
	vector<int> test_1;
	cout << sol.lemonadeChange(test_1) << endl;
	vector<int> test_2 = {5,5,5,10,20};
	cout << sol.lemonadeChange(test_2) << endl;
	vector<int> test_3 = {5,5,10,10,20};
	cout << sol.lemonadeChange(test_3) << endl;
}

int main(int argc, char* argv) {
	test_case();
	return 0;
}