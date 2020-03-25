class Solution {
private:
	// sort替代函数, 考虑到样例都是小写字母。
	//  1 count记录字符出现次数.
	//  2 按照字母从大到小，并且出现频次重新组装字符串.
	//  3 比如anagrams, 变成aaagmnrs. 
	string strSort(string s){
		in8t count[26] = {0};
		for(char t:s){
			count[t - 'a']++;
		}
		string result;
		for(int i = 0; i < 26;i++){
			result += string(count[i], i + 'a');
		}
		return result;

	}	
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
	
	unordered_map<string, vector<string>> helper;
	vector<vector<string>> result;
	for(auto& s: strs){
		string t = s;
		// 方法一
		sort(t.begin(), t.end());
		helper[t].push_back(s);
		// 方法二
		//helper[strSort(s)].push_back(s);
	}
	result.reserve(helper.size());
	for(auto& ss: helper){
		result.push_back(std::move(ss.second));
	}
    }
};
