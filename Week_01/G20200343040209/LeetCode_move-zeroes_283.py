class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # method1
        zero_num = nums.count(0)
        if zero_num != 0:
            for i in range(zero_num):
                nums.remove(0)
            nums.extend([0 for i in range(zero_num)])

        # method2
        # 保存0的索引位置的列表
        zero_index_list = []
        # 保存0列表的长度
        zero_list_len = 0
        # 0已替换的长度
        replace_zero_len = 0
        # 下一个待替换的0的索引位置
        repalce_zero_index = 0
        for index, value in enumerate(nums):
            if value != 0 and replace_zero_len == zero_list_len:
                continue
            if value == 0:
                zero_index_list.append(index)
                # 保存0索引的列表的长度+1
                zero_list_len += 1
                # 更新默认的待替换0的索引位置
                if repalce_zero_index == 0:
                    repalce_zero_index = zero_index_list[replace_zero_len]
            if value != 0 and replace_zero_len < zero_list_len:
                # 交换剩余位置最早的一个0和非零数
                nums[index], nums[repalce_zero_index] = nums[repalce_zero_index], nums[index]
                # 更新已替换0的长度
                replace_zero_len += 1
                # 记录新的0的位置
                zero_index_list.append(index)
                # 保存0列表的长度
                zero_list_len += 1
                # 记录新的0的位置
                repalce_zero_index = zero_index_list[replace_zero_len]
