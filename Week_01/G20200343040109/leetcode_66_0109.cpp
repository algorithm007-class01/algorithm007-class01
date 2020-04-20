//leetcode_66_0109.cpp
//加1

#include <iostream>
#include <vector>
#include <cmath>
#include <string.h>

std::vector<int> judge(std::vector<int>& digits, int nPos, bool bPlus)
{
    if(bPlus)
    {
        digits[nPos]++;
    }
    
    if(digits[nPos] == 10)
    {
        bPlus = true;
        digits[nPos] = 0;
        if(0 == nPos)//0为最后的退出条件
        {
            digits.insert(digits.begin(), 1);
            return digits;
        }
    }
    else
    {
        return digits;
    }

    return judge(digits, nPos - 1, bPlus);
}

std::vector<int> plusOne2(std::vector<int>& digits) 
{
    int nsize = digits.size();
    //方法2：递归，时间复杂度为O(n),空间复杂度为O(1)
    return judge(digits, nsize - 1, true);
}

std::vector<int> plusOne(std::vector<int>& digits) 
{
    int nsize = digits.size();

    //方法1：把每一位都记录下来，看是否要加1，时间复杂度O(n),额外申请了一个内存，所以空间复杂度O(n)
    bool* pbPlus = new bool[nsize + 1];
    memset(pbPlus, 0, sizeof(bool) * (nsize + 1));//有可能会进一位，所以pbPlus[0]要预留着
    pbPlus[nsize] = true;

    //i记录的是pbplus的坐标，j记录的是vec的坐标
    for(int i = nsize, j = nsize - 1; i >= 0, j >= 0; --i, --j)
    {
        if(pbPlus[i])
        {
            digits[j] = digits[j] + 1;
        }
        if(digits[j] == 10)
        {
            digits[j] = 0;
            pbPlus[i - 1] = true;
        }
        else
        {
            break;
        }
    }
    if(pbPlus[0])
    {
        digits.insert(digits.begin(), 1);
    }
    return digits;
}

int main(void)
{
    std::vector<int> vec;
    vec.push_back(4);
    vec.push_back(3);
    vec.push_back(2);
    vec.push_back(1);

    std::vector<int> vec_ret = plusOne(vec);

    for(unsigned int i = 0; i < vec_ret.size(); ++i)
    {
        std::cout<<vec_ret.at(i)<<std::endl;
    }

    char ar;
    std::cin>>ar;
    return 0;
}