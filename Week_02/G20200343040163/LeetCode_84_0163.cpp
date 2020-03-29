class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        heights.push_back(0);
        const int size_h = heights.size();
        stack<int> stk;
        int i = 0, max_a = 0;
        while (i < size_h) {
            if (stk.empty() || heights[i] >= heights[stk.top()]) stk.push(i++);
            else {
                int h = stk.top();
                stk.pop();
                max_a = max(max_a, heights[h] * (stk.empty() ? i : i - stk.top() - 1));
            }
        }
        return max_a;
    }
};