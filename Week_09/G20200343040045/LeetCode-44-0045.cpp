#include <iostream>
#include <vector>
using namespace std;
/**
 * 字符串匹配，单独判断.和*的判断
*/
class Solution {
   public:
    bool isMatch(string s, string p) {
        int i = 0, j = 0, iStar = -1, jStar = -1, m = s.size(), n = p.size();
        while (i < m) {
            if (j < n && (s[i] == p[j] || p[j] == '?')) {
                ++i;
                ++j;
            } else if (j < n && p[j] == '*') {  //记录如果之后序列匹配不成功时， i和j需要回溯到的位置
                iStar = i;                      //记录星号
                jStar = j++;                    //记录星号 并且j移到下一位 准备下个循环s[i]和p[j]的匹配
            } else if (iStar >= 0) {            //发现字符不匹配且没有星号出现 但是istar>0 说明可能是*匹配的字符数量不对 这时回溯
                i = ++iStar;                    //i回溯到istar+1 因为上次从s串istar开始对*的尝试匹配已经被证明是不成功的（不然不会落入此分支） 所以需要从istar+1再开始试 同时inc istar 更新回溯位置
                j = jStar + 1;                  //j回溯到jstar+1 重新使用p串*后的部分开始对s串istar（这个istar在上一行已经inc过了）位置及之后字符的匹配
            } else {
                return false;
            }
        }
        while (j < n && p[j] == '*') ++j;  //去除多余星号
        return j == n;
    }
};