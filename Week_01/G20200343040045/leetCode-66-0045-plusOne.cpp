#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>
#include <math.h>

using namespace std;

/**
 * clarification:非空数组，非负整数，在该数的基础上+1；
 * > 分析：1.末尾为9加1会有进位；2：数组为[9],[9,9],...时，数组长度会发生变化；
 * solutions:
 * > 时间复杂度为O(n)，空间复杂度为O(n)(最坏情况：当数组长度发生变化)
 *   
 * testCases:只有一个元素的数组[0]、[1];特殊的数组[9],[9,9]...
*/
class Solution
{
public:
    /**
     * Solution:
     * > 使用 从末尾开始，遍历计算+1的结果，赋值结果为结果/10，判断如果结果余10为0，则退出遍历
     * > 特殊边界条件，当遍历结束后，首位+1计算结果余10不为0，说明数组长度不够，需要将长度增1
     * > 对于上述特殊边界条件，使用vector<int> newArray(len+1)，之后将首位置为1即可
    */
    vector<int> plusOne(vector<int> &digits)
    {
        int plus = 1;
        int len = digits.size();
        int i = len - 1;
        for (; i >= 0; i--)
        {
            int p = (digits[i] + plus) / 10;
            digits[i] = (digits[i] + plus) % 10;
            if (p == 0)
                break;
            plus = p;
        }
        if (i == -1 && plus > 0)
        {
            vector<int> newDigits(len + 1);
            newDigits[0] = 1;
            return newDigits;
        }
        return digits;
    }
    void traverse(vector<int> &nums)
    {
        for (int i = 0; i < nums.size(); i++)
            cout << nums[i] << ' ';
        cout << endl;
    }
};
int main()
{
    // 官方测试用例 [1,2,4]
    vector<int> t1{};
    t1.push_back(1);
    t1.push_back(2);
    t1.push_back(3);

    // [9]
    vector<int> t2;
    t2.push_back(9);
    // [9x100]
    vector<int> t3;
    for (int i = 0; i < 100; i++)
    {
        t3.push_back(9);
    }
    Solution solution;
    vector<int> res1 = solution.plusOne(t1);
    solution.traverse(res1);
    vector<int> res2 = solution.plusOne(t2);
    solution.traverse(res2);
    vector<int> res3 = solution.plusOne(t3);
    solution.traverse(res3);
}