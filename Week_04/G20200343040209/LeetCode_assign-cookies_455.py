
def findContent(g, s):
    cook_dict = dict()
    success_num = 0
    for cookie in s:
        if cookie in cook_dict.keys():
            cook_dict[cookie] += 1
        else:
            cook_dict[cookie] = 1
    cook_list = list(cook_dict.keys())
    cook_list.sort()
    for child in g:
        if child in cook_list and cook_list[child] >= 1:
            success_num += 1
            cook_list[child] -= 1
        else:
            for index, value in enumerate(cook_list):
                if value >= child:
                    for list_index in range(index - 1):
                        if cook_dict[cook_list[list_index]] >= 1:
                            success_num += 1
                            cook_list[child] -= 1
                            break
    return success_num

# 又一次发生本地可以调试但是力扣报错的情况
#     def findContentChildren(self, g: List[int], s: List[int]) -> int:
#         g.sort()
#         s.sort()
#         child = 0
#         cookie = 0
#         while child < len(g) and cookie < len(s):
#             if g[child] <= s[cookie]:
#                 child += 1
#             cookie += 1
#         return child
