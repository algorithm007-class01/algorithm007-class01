#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
	int numDecodings(string s) {
		if (s.size() == 0) {
			return 0;
		}

		if (s[0] == '0') {
			return 0;
		}

		vector<int> dp(s.size() + 1, 1);
		int len = s.size();
		for (int i = 1; i < len; i++) {
			if (s[i] == '0') {
				if (s[i - 1] == '1' || s[i - 1] == '2') {
					dp[i + 1] = dp[i - 1];
				}
				else {
					return 0;
				}
			}
			else if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] <= '6')) {
				dp[i + 1] = dp[i] + dp[i - 1];
			}
			else {
				dp[i + 1] = dp[i];
			}
		}

		return dp[len];
	}
};

void test_case() {
	Solution sol;
    string str_1("12");
    cout << sol.numDecodings(str_1) << endl;
    string str_2("2226");
    cout << sol.numDecodings(str_2) << endl;
}

int main(int argc, char* argv[]) {
	test_case();
	return 0;
}