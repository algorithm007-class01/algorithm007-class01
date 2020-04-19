#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

/**
 * 题目：分发饼干
 * solution: 使用贪心算法，
 *          时间复杂度为O(NlogN)，(排序后处理的时间复杂度为O(m+n)),空间复杂度与快排的递归调用栈有关
 * test cases:空数组，正常数据[7,1,5,3,6,4]，返回false的数据[7,6,4,3,1]
*/

class Solution {
   public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int i = 0, j = 0;
        while (i < g.size() && j < s.size()) {
            if (g[i] <= s[j]) i++;
            j++;
        }
        return i;
    }
};
