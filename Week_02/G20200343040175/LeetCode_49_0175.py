"""
异位数分组

给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

class Solution:
    def groupAnagrams(self, strs: list) -> list:
        from collections import defaultdict
        #字符串通过排序，找到对应异位数的list
        # result_dict = defaultdict(list)
        # for unsort_str in strs:
        #     result_dict[tuple(sorted(unsort_str))].append(unsort_str)
        
        # result = list()
        # for v in result_dict.values():
        #     result.append(v)
        # return result

        #按照ascii计数,找到异位数
        result_dict = defaultdict(list)
        for unsort_str in strs:
            count_dict = [0]*26
            for s in unsort_str:
                count_dict[ord(s)-ord('a')]+=1
            result_dict[tuple(count_dict)].append(unsort_str)
        
        result = list()
        for v in result_dict.values():
            result.append(v)
        return result

if __name__ == "__main__":
    solution = Solution()
    strs = ["eat","tea","tan","ate","nat","bat"]
    print(solution.groupAnagrams(strs))
    