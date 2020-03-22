//方法1：利用排序加 Hash 实现字母异位词分组                                cpp
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;
        for (auto s : strs) {
            string t = s;
            sort(t.begin(), t.end());
            mp[t].push_back(s);
        }
        vector<vector<string>> res;
        for (auto p : mp) {
            res.push_back(p.second);
        }
        return res;
    }
};
//时间复杂度：O（NKlogK）空间复杂度：O（NK）


//方法2：哈希表，字母计数                                                cpp
class Solution {
public:
	vector<vector<string>> groupAnagrams(vector<string>& strs) {
		vector<vector<string>> res;
		unordered_map<string,int> mp;
		int n = 0;
		for (string &s : strs) {
			string t = s;
			sort(t.begin(), t.end());
			if (mp.count(t)) {
				res[mp[t]].push_back(s);
			}
			else {
				mp[t] = n++;
				res.push_back({ s });
			}
		 }
		return res;
	}
};
//时间复杂度：O(KN) 空间复杂度：O(KN)