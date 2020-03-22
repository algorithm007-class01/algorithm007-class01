class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = dict()
        for index, value in enumerate(nums):
            #　后面两句代码注释掉的原因是
            # 竟然有一个测试用例是nums = [3, 3]，target = 6， 然后结果还是[0, 1]，我TM！(╯‵□′)╯︵┻━┻
            # if value in dic.keys():
            #     continue
            difference = target - value
            if difference in dic.keys():
                return [dic[difference], index]
            dic[value] = index