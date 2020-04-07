//leetcode_860_0109.cpp
//柠檬水找零

#include <iostream>
#include <vector>

//统计5和10的个数，收到10要找零的话一定是5，收到20要找零的话一定是5*3或者10+5,
//找零了之后就把5和10的数量减掉
//时间复杂度O(n),空间复杂度O(1)
bool lemonadeChange(std::vector<int>& bills) 
{
    if(bills[0] != 5 || bills.size() <= 0)
    {
        return false;
    }
    int cnt[2] = { 0 };
    for (unsigned int i = 0; i < bills.size(); ++i)
    {
        if(5 == bills[i])
        {
            cnt[0]++;
        }
        else if(10 == bills[i])
        {
            if(cnt[0] < 1)
            {
                return false;
            }
            else
            {
                cnt[0]--;
                cnt[1]++;
            }
        }
        else if(20 == bills[i])
        {
            if(cnt[1] >= 1 && cnt[0] >= 1)//优先用10块的找零，5块的要留着给10块找零
            {
                cnt[0]--;
                cnt[1]--;
            }
            else if(cnt[0] >= 3)
            {
                cnt[0] -= 3;
            }
            else
            {
                return false;
            }
        }
    }
    return true;
}

int main(void)
{
    std::vector<int> vec;
    //vec.push_back(5);
    vec.push_back(10);
    vec.push_back(10);
    bool b = lemonadeChange(vec);
    std::cout << b << std::endl;

    char ar;
    std::cin >> ar;
    return 0;
}