//方法1：栈

/**我们用栈保存每堵墙。当遍历墙的高度的时候，
(1)如果当前高度小于栈顶的墙高度，说明这里会有积水，我们将墙的高度的下标入栈。
(2)如果当前高度大于栈顶的墙的高度，说明之前的积水到这里停下，我们可以计算下有多少积水了。计算完，就把当前的墙继续入栈，作为新的积水的墙。
*/
class Solution {
public:
    int trap(vector<int>& height) {
        int res = 0, curr = 0;
        stack<int> st;
        while (curr < height.size()) {
            while (!st.empty() && height[curr] > height[st.top()]) {
                int top = st.top();
                st.pop();
                if (st.empty()) break; 
                int instance = curr - st.top() - 1;
                int bounded_height = min(height[curr], height[st.top()]) - height[top];
                res += instance * bounded_height;
            }
            st.push(curr++);
        }
        return res;
    }
};
//时间复杂度：O(n)  空间复杂度：O(n)


//方法2：双指针
class Solution {
public:
    int trap(vector<int>& height) {
        int l = 0, r = height.size()-1, level = 0, water = 0;
        while (l < r) {
            int lower = height[height[l] < height[r] ? l++ : r--];
            level = max(level, lower);
            water += level - lower;
        }
        return water;
    }
};
//时间复杂度：O(n)  空间复杂度：O(1)