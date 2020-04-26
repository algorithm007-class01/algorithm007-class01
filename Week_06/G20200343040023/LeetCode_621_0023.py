# -*- coding: utf-8 -*-


class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        from collections import Counter
        ct = Counter(tasks)
        nbucket = ct.most_common(1)[ 0 ][ 1 ]
        last_bucket_size = list(ct.values()).count(nbucket)
        res = (nbucket - 1) * (n + 1) + last_bucket_size
        return max(res , len(tasks))
