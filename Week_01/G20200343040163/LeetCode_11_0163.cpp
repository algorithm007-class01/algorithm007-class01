class Solution {
public:
    int maxArea(vector<int>& height) {
        int result = 0;
        for (int i = 0, j = height.size() - 1; i < j;) {
            int h = height[i] < height[j] ? height[i++] : height[j--];
            result = max((j - i + 1) * h, result);
        }
        return result;
    }
};