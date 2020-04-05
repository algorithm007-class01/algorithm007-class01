# -*- coding: utf-8 -*-


class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        strs_dict = {}
        for ss in strs:
            s = list(ss)
            s.sort()
            key = tuple(s)
            if key in strs_dict:
                value = strs_dict[key]
                value.append(ss)
                strs_dict[key] = value
            else:
                strs_dict[key] = [ss]
        return strs_dict.values()


if __name__ == '__main__':
    s = Solution()
    print(s.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
