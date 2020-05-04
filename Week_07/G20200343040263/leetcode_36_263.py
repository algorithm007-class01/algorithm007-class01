# 检查数独是否有效
class Solution:
    def isValidSudoku(self, board: List[List[str]]):
        h_dict = [[] for i in range(9)]
        l_dict = [[] for j in range(9)]
        k_dict = [[] for q in range(9)]
        for i in range(9):
            for j in range(9):
                num = board[i][j]
                k = i//3*3+j//3
                if num!='.':
                    num = int(num)
                    if num not in h_dict[i]:
                        h_dict[i].append(num)
                    else:
                        return False
                    if num not in l_dict[j]:
                        l_dict[j].append(num)
                    else:
                        return False
                    if num not in k_dict[k]:
                        k_dict[k].append(num)
                    else:
                        return False
        return True