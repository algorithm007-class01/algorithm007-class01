# 基因变换 双向BFS
class Solution:
    def minMutation(self, start, end, bank):
        if end not in bank: return -1
        bank = set(bank)
        front = {start}
        back = {end}
        length = 0
        change = {'A':'CTG','C':'ATG','G':'ACT','T':'ACG'}
        while front:
            length += 1
            next_front = set()
            for gen in front:
                for i in range(len(gen)):
                    for j in change[gen[i]]:
                        if j != gen[i]:
                            new = gen[:i] + j + gen[i+1:]
                            if new in back:
                                return length
                            if new in bank:
                                next.front.add(new)
                                bank.remove(new)
            front = next_front
            if len(front) > len(back):
                front, back = back, front
        return -1