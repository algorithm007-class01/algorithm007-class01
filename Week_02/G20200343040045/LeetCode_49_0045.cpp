/**
 * 题目描述：字母异位词分组
 * clarification:
 * solutions:
 * 1. 使用sort函数进行排序，使用Map进行存储，时间复杂度为O(N*KlogK) 空间复杂度为O(N * K)
 * 2. 双层map进行统计： 时间复杂度为O(N*K)，空间复杂度O(N*K)
 * test cases:空数组，没有异位词的数组，正常包含异位词的数组
*/
class Solution
{
public:
    vector<vector<string>> groupAnagrams(vector<string> &strs)
    {
        /**
         * 1. 遍历字符串数组
         * 2. 使用sort进行字符串排序
         * 3. 并且使用unordered_map记录下标
         * 4. 将重复数据添加到二维数组中
        */
        unordered_map<string, int> ma;
        vector<vector<string>> res;
        // 从1开始计数，便于ma[e]取值判断
        int index = 1;
        // 不在for定义变量，节省空间
        string e;
        for (string s : strs)
        {
            e = s;
            sort(e.begin(), e.end());
            if (!ma[e])
            {
                ma[e] = index++;
                // 第一次出现e时，添加一个空的二维数组
                res.push_back(vector<string>());
            }
            res[ma[e] - 1].push_back(s);
        }
        return res;
    }
    vector<vector<string>> groupAnagrams(vector<string> &strs)
    {
        /**
         * 1. 遍历字符串数组
         * 2. 使用两层map记录，第二层map记录其中的字符串数组
         * 3. 遍历最外层map从其中取出values
        */
        map<map<char, int>, vector<string>> ma;
        vector<vector<string>> res;
        for (string s : strs)
        {
            map<char, int> tmp;
            for (int i = 0; i < s.length(); i++)
            {
                tmp[s[i]]++;
            }
            ma[tmp].push_back(s);
        }
        for (map<map<char, int>, vector<string>>::iterator it = ma.begin(); it != ma.end(); it++)
        {
            res.push_back(it->second);
        }
        return res;
    }
};