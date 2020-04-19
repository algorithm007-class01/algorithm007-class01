class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        res = []
        for b in bills:
            res.append(b)
            if b == 10:
                try:
                    res.remove(5)
                except:
                    return False
            if b == 20:
                try:
                    if 5 in res and 10 in res:
                        res.remove(5)
                        res.remove(10)
                    else:
                        res.remove(5)
                        res.remove(5)
                        res.remove(5)
                except:
                    return False
    
        return True
 