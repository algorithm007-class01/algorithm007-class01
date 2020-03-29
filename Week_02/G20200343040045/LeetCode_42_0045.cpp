/**
 * 题目描述：接雨水
 * clarification:
 * solutions:
 * 1. 暴力法 时间复杂度为O(n^2) 空间复杂度为O(1)
 * 2. 暴力法优化，使用数组存储不需要重复计算的值 时间复杂度为O(n) 空间复杂度为O(n)
 * 3. 双指针 时间复杂度为O(n) 空间复杂度为O(1)
 * 4. 栈的解法 时间复杂度为O(n) 空间复杂度为O(n)
 * test cases:空数组[]，只有一个元素的数组[1]，接不了雨水的数组[1,2,3,4,4,3,2,1]，正常数组
*/

class Solution
{
public:
    int trap(vector<int> &height)
    {
        /**
          * 1. 遍历每个元素
          * 2. 取该元素的左边最大值，和右边最大值（各使用max遍历一遍）
          * 3. 取出第二步的两个最大值的最小值，减去当前元素的高度就是该元素的接水量
         */
        int res = 0;
        int len = height.size();
        for (int i = 0; i < len - 1; i++)
        {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--)
                max_left = max(max_left, height[j]);
            for (int k = i; k < len; k++)
                max_right = max(max_right, height[k]);
            res += min(max_left, max_right) - height[i];
        }
        return res;
    }
    /**
     * 1. 优化第一步的暴力求解过程中的左边最大值和右边最大值的运算，将max_left和max_right使用数组进行保存
     * 2. 遍历数组生成辅助数组max_left和max_right
     * 3. 计算求和E(min(max_left[i],max_right[i])-height[i])
    */
    int trap(vector<int> &height)
    {
        int len = height.size();
        if (len <= 1)
            return 0;
        int res = 0;
        vector<int> max_left(len), max_right(len);
        max_left[0] = height[0];
        max_right[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++)
        {
            max_left[i] = max(max_left[i - 1], height[i]);
        }
        for (int j = len - 2; j >= 0; j--)
        {
            max_right[j] = max(max_right[j + 1], height[j]);
        }
        for (int k = 0; k < len; k++)
        {
            res += min(max_left[k], max_right[k]) - height[k];
        }
        return res;
    }
    /**
     * 1. 定义头尾连个指针，
     * 2. 遍历过程中生成左边最大值和右边最大值
     * 3. 满足计算的条件为左边下一个元素的值小于左边最大值，或者右边元素的值小于右边最大值
    */
    int trap(vector<int> &height)
    {
        int res = 0;
        int len = height.size();
        int max_left = 0, max_right = 0, i = 0, j = len - 1;
        while (i < j)
        {
            // 此处可以换成max_left<=max_right,但是上面的while条件要换成i<=j
            if (height[i] <= height[j])
            {
                if (height[i] >= max_left)
                    max_left = height[i];
                else
                    res += max_left - height[i];
                i++;
            }
            else
            {
                if (height[j] >= max_right)
                    max_right = height[j];
                else
                    res += max_right - height[j];
                j--;
            }
        }
        return res;
    }
    /**
     * 1. 使用栈进行辅助计算，栈中存放数据为从大到小，当栈顶的元素小于下一个入栈元素时，触发pop和数据计算
     * 2. 倒金字塔型计算面积和
    */
    int trap(vector<int> &height)
    {
        int len = height.size();
        int res = 0, current = 0;
        stack<int> st;
        while (current < len)
        {
            while (!st.empty() && height[current] > height[st.top()])
            {
                int top = st.top();
                st.pop();
                if (st.empty())
                    break;
                int d = current - st.top() - 1;
                int h = min(height[current], height[st.top()]) - height[top];
                res += d * h;
            }
            st.push(current++);
        }
        return res;
    }
};
