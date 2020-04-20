"""
这两段代码一上LeetCode就报错，然而本地一点问题都没有，火大！！！
(╯‵□′)╯︵┻━┻
"""
# def lemonadeChange(bills):
#     five_money_num = 0
#     ten_money_num = 0
#     result = "true"
#     for money in bills:
#         if money == 5:
#             five_money_num += 1
#         elif money == 10 and five_money_num >= 1:
#             five_money_num -= 1
#             ten_money_num += 1
#         elif money == 20:
#             if ten_money_num >= 1 and five_money_num >= 1:
#                 ten_money_num -= 1
#                 five_money_num -= 1
#             elif five_money_num >= 3:
#                 five_money_num -= 3
#             else:
#                 result = "false"
#                 break
#         else:
#             result = "false"
#             break
#     return result


def lemonadeChange(bills):
    five_money_num = 0
    ten_money_num = 0
    for money in bills:
        if money == 5:
            five_money_num += 1
        elif money == 10 and five_money_num >= 1:
            five_money_num -= 1
            ten_money_num += 1
        elif money == 20:
            if ten_money_num >= 1 and five_money_num >= 1:
                ten_money_num -= 1
                five_money_num -= 1
            elif five_money_num >= 3:
                five_money_num -= 3
            else:
                return "false"
        else:
            return "false"
    return "true"


