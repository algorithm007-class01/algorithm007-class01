#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/lemonade-change/description/
题目描述
860. Lemonade Change
Easy
At a lemonade stand, each lemonade costs $5.
Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.

Note that you don't have any change in hand at first.
Return true if and only if you can provide every customer with correct change.

Example 1:
Input: [5,5,5,10,20]
Output: true
Explanation:
From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.

Example 2:
Input: [5,5,10]
Output: true

Example 3:
Input: [10,10]
Output: false

Example 4:
Input: [5,5,10,10,20]
Output: false
Explanation:
From the first two customers in order, we collect two $5 bills.
For the next two customers in order, we collect a $10 bill and give back a $5 bill.
For the last customer, we can't give change of $15 back because we only have two $10 bills.
Since not every customer received correct change, the answer is false.
Note:
0 <= bills.length <= 10000
bills[i] will be either 5, 10, or 20.
"""

from typing import List


class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        # 解法1 贪心算法
        if not bills: return True

        from collections import defaultdict
        my_money = defaultdict(int)
        for i in range(len(bills)):
            pay = bills[i]
            my_money[pay] += 1
            if pay == 5: continue

            pay_back = pay - 5
            for c in [20, 10, 5]:
                while c <= pay_back and my_money[c] > 0:
                    my_money[c] -= 1
                    pay_back -= c

            if pay_back: return False
        return True


res = Solution().lemonadeChange([5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5])
print(res)
