# -*- coding: utf-8 -*-


class Solution(object):
    def lemonadeChange(self, bills):
        """
        :type bills: List[int]
        :rtype: bool
        """

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


if __name__ == '__main__':
    s = Solution()
    print(s.lemonadeChange([5, 10, 20]))
