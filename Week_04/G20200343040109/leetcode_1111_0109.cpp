//leetcode_1111_0109.cpp
//有效括号的嵌套深度

#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <stack>
#include <utility>

//时间复杂度O(n)，空间复杂度O(n)
std::vector<int> maxDepthAfterSplit(std::string seq) 
{
    std::vector<int> vec;
    if(!seq.size())
    {
        return vec;
    }
    //通过栈分析每一个括号的深度
    std::map<int, int> map_dept; 
    unsigned int size = seq.length();
    std::stack<char> ss;

    int dept = 0;
    for(unsigned int i = 0; i < size; ++i)
    {
        if(ss.size())
        {
            char ch = ss.top();
            if(ch != seq[i])//配对
            {
                map_dept.insert(std::pair<int, int>(i, dept));
                dept--;//深度要减1
            }
            else
            {
                map_dept.insert(std::pair<int, int>(i, ++dept));
                ss.push(seq[i]);
            }
        }
        else
        {
            ss.push(seq[i]);
            map_dept.insert(std::pair<int, int>(i, ++dept));
        }
    }
    //深度为奇数放入A，深度为偶数放入B
    for(std::map<int, int>::iterator iter = map_dept.begin(), isize = map_dept.end(); iter != isize;  ++iter)
    {
        vec.push_back(!((iter->second) % 2));
    }
    return vec;
}

//官方题解
//( ( ) )
//1 2 2 1
//时间复杂度O(n)，空间复杂度O(1)
std::vector<int> maxDepthAfterSplit2(std::string seq) 
{
    std::vector<int> vec;
    if(!seq.size())
    {
        return vec;
    }
    //只需要知道和“（”是否相等就可以知道每一个括号的深度
    //只要不是“）”那深度就要+1，如果配对成功一个，深度就要-1
    int ndept = 0;
    unsigned int size = seq.length();
    for(unsigned int i = 0; i < size; ++i)
    {   
        if('(' == seq[i])
        {
            ndept++;
            vec.push_back(!(ndept%2));  
        }
        else
        {
            vec.push_back(!(ndept%2));
            ndept--;
        }
    }
    return vec;
}

int main(void)
{
    std::string str = "(()())";
    std::vector<int> vec = maxDepthAfterSplit2(str);
    typedef std::vector<int>::iterator iter_type;
    for(iter_type iter = vec.begin(), isize = vec.end(); iter != isize; ++iter)
    {
        std::cout<<*iter<<" ";
    }
    std::cout<<std::endl;
    char ar;
    std::cin>>ar;
    return 0;
}