//leetcode_1_0109.cpp
//两数之和

#include <iostream>
#include <vector>
#include <map>

std::vector<int> twoSum(std::vector<int>& nums, int target) 
{
    std::vector<int> vec;
    //方法1、暴力求解法，时间复杂度O(n^2),空间复杂度O(1)
    // for(unsigned int i = 0; i < nums.size(); ++i)
    // {
    //     for(unsigned int j = i + 1; j < nums.size(); ++j)
    //     {
    //         if((nums[i] + nums[j]) == target)
    //         {
    //             vec.push_back(i);
    //             vec.push_back(j);
    //         }
    //     }
    // }

    //方法2：map法,时间复杂度O(n),空间复杂度为O(n)
    std::map<int, int> value_key_map;
    std::map<int, int>::iterator iter;
    for(unsigned int i = 0; i < nums.size(); ++i)
    {
        int n = target - nums[i];
        iter = value_key_map.find(n); 
        if(iter == value_key_map.end())//没找到
        {
            value_key_map.insert(std::pair<int, int>(nums[i], i));
        }
        else
        {
            vec.push_back(iter->second);
            vec.push_back(i);           
        }
    }

    return vec;
}

int main(void)
{
    std::vector<int> vec;
    vec.push_back(2);
    vec.push_back(7);
    vec.push_back(11);
    vec.push_back(5);

    int nTarget = 9;
    std::vector<int> vec_ret = twoSum(vec, nTarget);


    for(unsigned int i = 0; i < vec_ret.size(); ++i)
    {
        std::cout<<vec.at(i)<<std::endl;
    }

    char ar;
    std::cin>>ar;
    return 0;
}