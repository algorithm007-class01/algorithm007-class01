from collections import Counter, OrderedDict
# @lc code=start
class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        map_s = Counter(s)
        
        for i, c in enumerate(s):
            if map_s[c]==1:
                return i
        return -1
        

Solution().firstUniqChar('loveleetcode')