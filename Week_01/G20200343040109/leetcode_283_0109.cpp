//leetcode_283_0109.cpp
//移动0问题

#include <iostream>
#include <vector>
//两个变量，一个变量一直往后遍历,查询非0值，一个变量一直记录下一个非0值该放的位置
void moveZeroes(std::vector<int>& nums) 
{
    unsigned int nNoZero = 0;
    for(unsigned int i = 0; i < nums.size(); ++i)
    {
        if(0 != nums[i] && i != nNoZero)
        {
            nums[nNoZero] = nums[i];
            nums[i] = 0;
            nNoZero++;
        }
        else if(0 != nums[i] && i == nNoZero)
        {
            nNoZero++;
        }
    }
}

int main(void)
{
    std::vector<int> vec;
    vec.push_back(0);
    vec.push_back(1);
    vec.push_back(0);
    vec.push_back(3);
    vec.push_back(12);

    moveZeroes(vec);

    for(unsigned int i = 0; i < vec.size(); ++i)
    {
        std::cout<<vec.at(i)<<std::endl;
    }
    char ar;
    std::cin>>ar;
    return 0;
}


