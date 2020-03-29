/*
* Summary:trapping-rain-water
* Parameters:
*   height: source vector
* Return: capacity value
*/
class Solution {
public:
    int trap(vector<int>& height) {
        stack<int> st;
        size_t current = 0;
        int capacity = 0;
        while (current < height.size()) {
            while (!st.empty() && height[current] > height[st.top()]) {
                int top = st.top();
                st.pop();
                if (st.empty()) {
                    break;
                }
                int distance = current - st.top() - 1;
                int bound_height = min(height[current], height[st.top()]) - height[top];
                capacity += distance * bound_height;
            }
            st.push(current++);
        }
        return capacity;    
    }
};