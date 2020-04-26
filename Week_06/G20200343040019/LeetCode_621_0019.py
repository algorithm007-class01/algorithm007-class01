from collections import Counter
from queue import PriorityQueue
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if not tasks:
            return 0
        if n == 0:
            return len(tasks)

        taskC = Counter(tasks)
        tasklist = sorted(list(taskC.values()))
        res = 0
        c = len(tasks)
        while tasklist[-1]!=0:
            for i in range( n + 1 ):
                # print(i,tasklist,res)
                if i<len(tasklist) and tasklist[-i-1]>0 :
                    tasklist[-i-1]-=1
                    c-=1
                res+=1
                if c==0 :
                    break
            tasklist.sort()
        return res


        # q = PriorityQueue()
        # for k, v in taskC.items():
        #     q.put((-v, k))
        
        # res = 0
        # while not q.empty():
        #     num = min(n+1, q.qsize())
        #     movelist = []
        #     for i in range(num):
        #         c, item = q.get()
        #         if c<-1:
        #             movelist.append((c+1, item))
            
        #     for mi in movelist:
        #         q.put(mi)

        #     if q.empty():
        #         res += num
        #     else:
        #         res += n+1
                
        # return res