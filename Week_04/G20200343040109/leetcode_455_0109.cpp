//leetcode_455_0109.cpp
//分发饼干

#include <iostream>
#include <vector>
#include <algorithm>

//给两个数组排序，按照小孩胃口和饼干大小排序，这样从小到大一个一个去满足，数量就是最多的
//胃口小的肯定是最容易满足的
//时间复杂度为O（n）
int findContentChildren(std::vector<int>& g, std::vector<int>& s)
{
    if(g.size() <= 0 || s.size() <= 0)
    {
        return 0;
    }

    std::sort(g.begin(), g.end());
    std::sort(s.begin(), s.end());

    int ncnt = 0;
    for (unsigned int i = 0; i < g.size(); ++i)
    {
        if(g[i] >= s[ncnt])
        {
            ncnt++;
            if(ncnt >= s.size())
            {    
                break;
            }
        }
    }
    return ncnt;
}

int main(void)
{
    std::vector<int> g;
    std::vector<int> s;
    g.push_back(1);
    g.push_back(1);

    s.push_back(1);
    s.push_back(2);
    s.push_back(3);

    int n = findContentChildren(g, s);
    std::cout << "n = " << n << std::endl;
    char ar;
    std::cin >> ar;
    return 0;
}