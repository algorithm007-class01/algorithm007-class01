//leetcode_122_0109.cpp
//买卖股票的最佳时机II

#include <iostream>
#include <vector>

//要求得最大盈利，即需要抓住每一个上涨，只要每次上涨都买，跌的时候不操作就可以了，最大的盈利就是每次上涨的总和
int maxProfit(std::vector<int>& prices) 
{
    int nMax = 0;
    for (unsigned int i = 0; i < prices.size() - 1; ++i)
    {
        if(prices[i+1] > prices[i])
        {
            nMax += (prices[i + 1] - prices[i]);
        }
    }
    return nMax;
}

int main(void)
{
    char ar;
    std::cin >> ar;
    return 0;
}