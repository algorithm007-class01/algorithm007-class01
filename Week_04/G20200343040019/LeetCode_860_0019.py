class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        cash5,cash10=0,0
        for bill in bills:
            if bill == 5:
                cash5+=1
            elif bill == 10:
                if cash5>0:
                    cash5-=1
                    cash10+=1
                else:
                    return False
            elif bill == 20:
                if cash10>0 and cash5>0:
                    cash10-=1
                    cash5-=1
                elif cash5>=3:
                    cash5-=3
                else:
                    return False
        return True