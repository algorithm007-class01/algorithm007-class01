//leetcode_26_0109.cpp
//删除数组重复的数字

#include <iostream>
#include <vector>
#include <map>

int removeDuplicates(std::vector<int>& nums) 
{
    if(nums.size() <= 1)
        return nums.size();

    //使用双坐标，一个一直往后轮询，一个记录下一个该放的位置，空间复杂度O(n),时间复杂度O(1)
    int i = 1;//记录不同元素下一个位置是什么
    int nlen = 1;//已经把num[0]作为1个了
    int nTemp = nums[0];
    for(unsigned int j = i; j < nums.size(); ++j)
    {
        if(nTemp != nums[j])
        {
            nums[i++] = nums[j];
            nTemp = nums[j];
            nlen++;
        }
    }
    return nlen;
}

int main(void)
{
    std::vector<int> vec;
    vec.push_back(1);
    vec.push_back(1);
    vec.push_back(2);

    int nlen = removeDuplicates(vec);

    for(unsigned int i = 0; i < nlen; ++i)
    {
        std::cout<<vec.at(i)<<std::endl;
    }

    char ar;
    std::cin>>ar;
    return 0;
}