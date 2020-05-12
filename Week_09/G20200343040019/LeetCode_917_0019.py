class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        i = 0
        j = len(S)-1
        res = [S[i] for i in range(len(S))]
        while i<j:
            if res[i] not in string.ascii_letters:
                i+=1
                continue
            if res[j] not in string.ascii_letters:
                j-=1
                continue
            
            res[i], res[j] = res[j], res[i]
            i+=1
            j-=1
        return "".join(res)