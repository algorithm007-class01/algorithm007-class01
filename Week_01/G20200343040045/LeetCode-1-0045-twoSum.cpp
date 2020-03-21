#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>
#include <unordered_map>

using namespace std;

/**
 * clarification:找出数组中和为目标值target的两个整数
 * > 分析：1.暴力法：两层循环；2：使用hashmap方式；C++ unordered_map;
 * solutions:
 * > 解法1：暴力法，时间复杂度为O(n^2),空间复杂度为O(1);
 * > 解法2：使用unordered_map，时间复杂度为O(n)，空间复杂度为O(n);
 * testCases:空数组[];只有一个元素的数组[1];正常的数组[2, 7, 11, 15];数组中无解[-3,-1,0,10,20,30]
*/
class Solution
{
public:
    /**
     * Solution 1:
     * > 两层循环
     * > 异常情况判断
    */
    vector<int> twoSum1(vector<int> &nums, int target)
    {
        int len = nums.size();
        if (len < 2)
            throw "数组长度不足";
        for (int i = 0; i < len; i++)
        {
            for (int j = i + 1; j < len; j++)
            {
                if (nums[j] == target - nums[i])
                {
                    return {i, j};
                }
            }
        }
        throw "无解";
    }
    /**
     * Solution 2:
     * > 使用unordered_map记录
     * > 异常情况判断
     * > return的时候用{j,tempMap[target - nums[j]]},一定是顺序的
    */
    vector<int> twoSum2(vector<int> &nums, int target)
    {
        int len = nums.size();
        if (len < 2)
            throw "数组长度不足";
        unordered_map<int, int> tempMap;
        for (int i = 0; i < len; i++)
        {
            tempMap[nums[i]] = i;
        }
        for (int j = 0; j < len; j++)
        {
            if (tempMap.find(target - nums[j]) != tempMap.end() && tempMap[target - nums[j]] != j)
            {
                return {j, tempMap[target - nums[j]]};
            }
        }
        throw "无解";
    }
    /**
     * 数组遍历打印
    */
    void traverse(vector<int> &nums)
    {
        for (int i = 0; i < nums.size(); i++)
            cout << nums[i] << ' ';
        cout << endl;
    }
};
int main()
{
    Solution solution;
    // []
    vector<int> t1;
    try
    {
        solution.twoSum2(t1, 0);
    }
    catch (const char *e)
    {
        cout << "异常1：" << e << endl;
    }

    // [1]
    vector<int> t2;
    t2.push_back(1);
    try
    {
        solution.twoSum2(t2, 0);
    }
    catch (const char *e1)
    {
        cout << "异常2：" << e1 << endl;
    }

    // [2,7,11,15]
    vector<int> t3;
    t3.push_back(2);
    t3.push_back(7);
    t3.push_back(11);
    t3.push_back(15);
    vector<int> test = solution.twoSum2(t3, 9);
    solution.traverse(test);

    //
    vector<int> t4;
    t4.push_back(-3);
    t4.push_back(-1);
    t4.push_back(0);
    t4.push_back(10);
    t4.push_back(20);
    t4.push_back(30);
    try
    {
        solution.twoSum2(t4, 0);
    }
    catch (const char *e2)
    {
        cout << "异常3：" << e2 << endl;
    }
}