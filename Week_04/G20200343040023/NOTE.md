学习笔记

贪心算法：找出局部最优解
860 找零钱:
      def lemonadeChange(bills):
        bills_map = {}
        for b in bills:
            if b == 5:
                if b in bills_map:
                    bills_map[5] += 1
                else:
                    bills_map[5] = 1
            elif b == 10:
                if 5 in bills_map:
                    if bills_map[5] <= 0:
                        return False
                    else:
                        bills_map[5] -= 1
                else:
                    return False

                if 10 in bills_map:
                    bills_map[10] += 1
                else:
                    bills_map[10] = 1
            elif b == 20:
                tmp = 15
                if 10 in bills_map and bills_map[10] > 0:
                    tmp = tmp - 10
                    bills_map[10] -= 1
                while tmp > 0:
                    tmp -= 5
                    bills_map[5] -= 1

                if bills_map[5] < 0:
                    return False
        return True


122: 股票预测差值相加，只要下个选项大于前一个选项

455: 把握好i，j位置， i在里j在外
    def findContentChildren(self, g, s):
        nums = 0
        if not isinstance(g, list) or not isinstance(s, list):
            return nums

        g.sort()
        s.sort()

        i, len_i = 0, len(g)
        j, len_j = 0, len(s)
        while i < len_i and j < len_j:
            if g[i] <= s[j]:
                nums += 1
                i += 1
            j += 1
        return nums