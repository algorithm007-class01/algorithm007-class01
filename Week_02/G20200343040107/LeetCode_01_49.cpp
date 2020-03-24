#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std; 

class Solution {
public:
	vector<vector<string>> groupAnagrams(vector<string>& strs) {
		if (strs.empty()) {
			return vector<vector<string>>();
		}

		vector<vector<string>> ret_res;
		unordered_map<string, int> classify_res;
		int classify_count = 0;
		int len = strs.size();
		for (int i = 0; i < len; i++) {
			string tmp = strs[i];
			sort(tmp.begin(), tmp.end());
			if (classify_res.count(tmp) > 0) {
				ret_res[classify_res[tmp]].push_back(strs[i]);
			}
			else {
				ret_res.push_back(vector<string>(1, strs[i]));
				classify_res[tmp] = classify_count++;
			}
		}

		return ret_res;
	}
};


void test_case() {
	vector<string> str_list = { "eat", "tea", "tan", "ate", "nat", "bat" };
	vector<vector<string>> res;
	Solution sol; 
	res = sol.groupAnagrams(str_list);
	for (int i = 0; i < res.size(); i++) {
		for (int j = 0; j < res[i].size(); j++) {
			cout << res[i][j] << ",";
		}
		cout << endl; 
	}
}

int main(int argc, char* argv[]) {
	test_case(); 
	return 0; 
}