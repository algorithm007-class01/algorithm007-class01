class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        # 归并排序
        # 像是只有锤子
        # 想到以前数学老师讲的故事，什么叫数学思想，题目A，给你一个水壶，一个有水的自来水管，一个炉子，如何得到一壶热水，答案A，接水点火烧水。题目B，给你一个装满水的水壶，一个有水的自来水管，一个炉子，如何得到一壶热水，答案B：把水倒掉，按A来

        def count(nums):
            if len(nums)<2:
                return nums, 0

            mid = len(nums)//2
            left, countleft = count(nums[:mid])
            right, countright = count(nums[mid:])

            resc = countleft+countright

            resn = []

            i,j=0,0
            tleft = [i/2 for i in left]
            while i<len(tleft) and j<len(right):
                if tleft[i] <= right[j]:
                    i+=1
                else:
                    resc+= len(tleft)-i   
                    j+=1
                
            return sorted(left+right), resc
        
        n, c = count(nums)
        return c