def isAnagram(self, s: str, t: str) -> bool:
    dic = dict()
    # 影响性能
    # if len(s) != len(t):
    #     return False
    for str_s in s:
        if 122 >= ord(str_s) >= 97:
            if str_s not in dic.keys():
                dic[str_s] = 1
            else:
                dic[str_s] += 1
    for str_t in t:
        if 122 >= ord(str_t) >= 97:
            if str_t not in dic.keys():
                return False
            else:
                dic[str_t] -= 1

    for key, value in dic.items():
        if value != 0:
            return False
    return True
