//leetcode_49_0109.cpp
//字母异位词分组

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <map>

//暴力求解，while+for循环加sort
std::vector<std::vector<std::string> > groupAnagrams1(std::vector<std::string>& strs) 
{
    //1、使用while+for循环，对每一个字符串进行sort后比较，如果相等则放在同一个vector,并把相同的删除掉
    std::vector<std::vector<std::string> > vec_vec_string;
    while(strs.size())
    {
        std::vector<std::string> vec_str;
        unsigned int size = strs.size();
        std::string strComp = strs[0]; 
        std::sort(strComp.begin(), strComp.end());
        vec_str.push_back(strs[0]);
        std::vector<int> vec_int;
        vec_int.push_back(0);
        for(unsigned int i = 1; i < size; ++i)
        {    
            std::string sT =  strs[i];
            std::sort(sT.begin(), sT.end());
            if(sT == strComp)
            {
                vec_str.push_back(strs[i]);
                vec_int.push_back(i);
            }
        }
        std::vector<std::string> vec_new;
        for(unsigned int j = 0; j < strs.size(); ++j)
        {
            bool bEqual = false;
            for(unsigned int i = 0; i < vec_int.size(); ++i)
            {
                if(j == vec_int[i])
                {
                    bEqual = true;
                    break;
                }
            }
            if(!bEqual)
            {
                vec_new.push_back(strs[j]);
            }
        }
        strs.clear();
        strs.insert(strs.begin(), vec_new.begin(), vec_new.end());
        vec_vec_string.push_back(vec_str);
    }
    return vec_vec_string;
}

//映射，时间复杂度O(n+m)，空间复杂度是O(n)
std::vector<std::vector<std::string> > groupAnagrams2(std::vector<std::string>& strs) 
{
    typedef std::map<std::string, std::vector<std::string> > map_type;
    typedef map_type::iterator iter_map_type;
    map_type map_string;
    for(unsigned int i = 0; i < strs.size(); ++i)
    {
        std::string strComp = strs[i]; 
        std::sort(strComp.begin(), strComp.end());
        iter_map_type iter = map_string.find(strComp);
        if( iter != map_string.end())
        {
           iter->second.push_back(strs[i]);
        }
        else
        {
            std::vector<std::string> vec_string;
            vec_string.push_back(strs[i]);
            map_string.insert(std::pair<std::string, std::vector<std::string>>(strComp, vec_string));
        }
    }

    std::vector<std::vector<std::string> > vec_vec_string;
    for(iter_map_type iter = map_string.begin(), isize = map_string.end(); iter != isize; ++iter)
    {
        vec_vec_string.push_back(iter->second);
    }
    return vec_vec_string;
}

int main(void)
{
    std::vector<std::string> vec_str;
    //["eat", "tea", "tan", "ate", "nat", "bat"],
    vec_str.push_back("eat");
    vec_str.push_back("tea");
    vec_str.push_back("tan");
    vec_str.push_back("ate");
    vec_str.push_back("nat");
    vec_str.push_back("bat");

    //std::vector<std::vector<std::string> > vec_vec_str = groupAnagrams1(vec_str);
    std::vector<std::vector<std::string> > vec_vec_str = groupAnagrams2(vec_str);

    for(unsigned int i = 0; i < vec_vec_str.size(); ++i)
    {
        for(unsigned int j = 0; j < vec_vec_str[i].size(); ++j)
        {
            std::string s = vec_vec_str[i][j];
            std::cout<< s << " ";
        }
        std::cout<<"\r\n";
    }
    char ar;
    std::cin>>ar;
    return 0;
}