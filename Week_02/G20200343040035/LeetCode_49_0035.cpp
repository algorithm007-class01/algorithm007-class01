class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string,vector<string>> m;
        vector<vector<string>> res;
        for (auto s : strs){
            string strtmp = s;
            sort(s.begin(),s.end());
            m[s].push_back(strtmp);
        }
        for (auto str : m){
            res.push_back(str.second);
        }
        return res;
    }
};