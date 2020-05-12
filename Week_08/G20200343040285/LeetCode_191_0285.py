class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        # while n:
        #     n = n & (n-1)
        #     count +=1
        # return count

#2
        return bin(n).count('1')

#3
        mask = 1
        for i in range(32):
            if (n & mask)==1:
                count += 1
            mask <<= 1
        return count