#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>

using namespace std;

/**
 * clarification:将数组的0移到末尾，并保证非零元素的顺序；
 * > 分析：1.修改原数组的方式：非零元素顺序前移；2：不修改原数组方式：按顺序提取非零元素；
 * solutions:
 * > 解法1：使用额外的数组记录，时间复杂度为O(n)，空间复杂度为O(n)
 * > 解法2：使用双指针法，指针i用于操作，指针j用来遍历。遍历指针找到第一个非零数时，将j处的值赋值给i处，并将j处的值置为0.
 *   时间复杂度为O(n)，空间复杂度为O(1)
 * testCases:空数组[];只有一个元素的数组[0]、[1];正常的数组[1000x0,1]
*/
class Solution
{
public:
    /**
     * Solution 1:
     * > 使用额外数组nonZeroNums记录非零值的下标
     * 
    */
    void moveZeroes1(vector<int> &nums)
    {
        vector<int> nonZeroNums;
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums[i] != 0)
            {
                nonZeroNums.push_back(i);
            }
        }
        for (int j = 0; j < nums.size(); j++)
        {
            nums[j] = j < nonZeroNums.size() ? nums[nonZeroNums[j]] : 0;
        }
    }
    /**
     * Solution 2:
     * > 用nonZeroNum记录非零数的长度，并且将非零数覆盖到nums[nonZeroNum]的数据
     * > 排除一些不需要进行覆盖的条件(nums[i]!=0 && nonZeroNum==i)
    */
    void moveZeroes2(vector<int> &nums)
    {
        int nonZeroNum = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums[i] != 0)
            {
                if (nonZeroNum == i)
                {
                    nonZeroNum++;
                }
                else
                {
                    nums[nonZeroNum++] = nums[i];
                    nums[i] = 0;
                }
            }
        }
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
    // test cases
    vector<int> t1;
    vector<int> t2;
    t2.push_back(0);
    vector<int> t3;
    t3.push_back(0);
    t3.push_back(1);
    t3.push_back(0);
    t3.push_back(2);
    t3.push_back(0);
    t3.push_back(3);
    t3.push_back(0);
    t3.push_back(4);
    vector<int> t4;
    for (int i = 0; i <= 999; i++)
        t4.push_back(0);
    t4.push_back(1);
    Solution solution;
    solution.moveZeroes2(t1);
    solution.moveZeroes2(t2);
    solution.moveZeroes2(t3);
    solution.moveZeroes2(t4);
    solution.traverse(t1);
    solution.traverse(t2);
    solution.traverse(t3);
    solution.traverse(t4);
}