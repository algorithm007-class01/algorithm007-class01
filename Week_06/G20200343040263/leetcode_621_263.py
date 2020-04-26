class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int
        if not tasks: return 0
        dict1 = {}
        for i in tasks:
            # 构造字典，键是任务，值是任务的统计结果
            dict[i] = dict1.get(i,0)+1
        # 初始化最小时间
        min_time = 0
        # 最多的任务，此处得到的是键
        max_task = max(dict1, key=dict1.get)
        # 完成次数最多的任务需要的任务时间为 (count - 1) * (n + 1) + 1
        min_time = (dict1[max_task] - 1)*(n+1) + 1
        for k, v in dict1.items():
            # 找到相同任务次数的其他任务
            if v == dict[max_task] and k!= max_task:
                min_time += 1
        # 任务总时间必须大于数组长度，如果 任务种类-1>n，说明可以直接依次完成任务，例如ABCDABC
        if min_time < len(task):
            min_time = len(task)
        return min_time