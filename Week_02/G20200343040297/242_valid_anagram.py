class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # check edge case
        if len(s) != len(t):
            return False
        
        count = {}
        
        for letter in s:
            if letter in count:
                count[letter] += 1
            else:
                count[letter] = 1
        
        for letter in t:
            if letter in count:
                count[letter] -= 1
                if count[letter] < 0:
                    return False
            else:
                return False
            
            
        return True