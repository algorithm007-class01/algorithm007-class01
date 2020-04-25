#include <iostream>
#include <vector>
using namespace std;

/**
 * clarification:任务调度器
 * solution:
 *      1. 找到数量最多的任务,则将该任务执行完成至少需要（count-1）*（n+1）+1的时间，而且后面的任务均不需要增加延迟
 *         时间复杂度为O(N),空间复杂度为O(26)
 * testcases 
*/
class Solution {
   public:
    int leastInterval(vector<char>& tasks, int n) {
        vector<int> cnt(26, 0);
        for (char type : tasks) cnt[type - 'A']++;
        int maxValue = 0, equal_cnt = 0;
        for (int i : cnt) maxValue = fmax(i, maxValue);
        for (int i = 25; i >= 0; --i) {
            if (maxValue == cnt[i])
                ++equal_cnt;
        }
        int ans = fmax((maxValue - 1) * (n + 1) + equal_cnt, tasks.size());
        return ans;
    }
};