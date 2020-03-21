//leetcode_189_0109.cpp
//旋转数组

#include <iostream>
#include <vector>
#include <algorithm>

void rotate(std::vector<int>& nums, int k)
{
    int nsize = nums.size();

    //方法1：一个个移动，时间复杂度O(n)，空间复杂度O(1)
    if(k % nsize)
    {
        int nMove = k % nsize;
        for(int n = 0; n < nMove; ++n)
        {
            int nEnd = nums[nsize - 1];
            nums.pop_back();
            nums.insert(nums.begin(), nEnd);                
        }
    }

    //方法2：通过反转函数reverse,时间复杂度为O(n)，空间复杂度为O(1)
    

}

void rotate2(std::vector<int>& nums, int k)
{
    int nsize = nums.size();
    int nMove = k % nsize;
    //方法2：通过反转函数reverse,时间复杂度为O(1)，空间复杂度为O(1)
    std::reverse(&nums[0], &nums[nsize - nMove]);

    std::reverse(&nums[nsize - nMove], &nums[nsize]);

    std::reverse(&nums[0], &nums[nsize]);


}

int main(void)
{
    std::vector<int> vec;
    vec.push_back(1);
    vec.push_back(2);
    vec.push_back(3);
    vec.push_back(4);
    vec.push_back(5);
    vec.push_back(6);
    vec.push_back(7);

    int k = 3;
    //rotate(vec, k);
    rotate2(vec, k);
    for(unsigned int i = 0; i < vec.size(); ++i)
    {
        std::cout<<vec.at(i)<<" ";
    }
    std::cout<<std::endl;

    char ar;
    std::cin>>ar;
    return 0;
}