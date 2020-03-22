#
# @lc app=leetcode.cn id=49 lang=python
#
# [49] 字母异位词分组
#
# https://leetcode-cn.com/problems/group-anagrams/description/
#
# algorithms
# Medium (61.11%)
# Likes:    289
# Dislikes: 0
# Total Accepted:    57.1K
# Total Submissions: 93.5K
# Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
#
# 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
# 
# 示例:
# 
# 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
# 输出:
# [
# ⁠ ["ate","eat","tea"],
# ⁠ ["nat","tan"],
# ⁠ ["bat"]
# ]
# 
# 说明：
# 
# 
# 所有输入均为小写字母。
# 不考虑答案输出的顺序。
# 
# 
#
import collections
# @lc code=start
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        map = collections.defaultdict(list)
        for s in strs:
            count = [0] *26
            for c in s:
                count[ord(c) - ord('a')] += 1
            map[tuple(count)].append(s)
        return map.values()

input = ["eat", "tea", "tan", "ate", "nat", "bat"]
Solution().groupAnagrams(input)
# @lc code=end

