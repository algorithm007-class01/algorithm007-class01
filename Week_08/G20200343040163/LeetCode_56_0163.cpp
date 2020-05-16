class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> res;
        sort(intervals.begin(), intervals.end());
        int cur = 0;
        for (const auto &interval: intervals) {
            if (res.empty()) {
                res.push_back(interval);
            }
            if (interval[0] <= res[cur][1]) {
                res[cur][1] = max(interval[1], res[cur][1]);
            } else {
                res.push_back(interval);
                ++cur;
            }
        } 
        return res;
    }
};