class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if (intervals.empty()) return {};
        sort(intervals.begin(), intervals.end());
        vector<vector<int>> merged;
        for (int i = 0; i < intervals.size(); ++i) {
            int left = intervals[i][0], right = intervals[i][1];
            if (!merged.size() || merged.back()[1] < left) {
                merged.push_back({left, right});
            }
            else {
                merged.back()[1] = max(merged.back()[1], right);
            }
        }
        return merged;
    }
};