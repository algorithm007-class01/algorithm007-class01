"""
455. 分发饼干
思路 满足胃口小的孩子

"""
class fenbinggan():
    def food(self,child,bing):
        child =[1,3,4,5]
        bing = [2,3,4,5]
        child.sort()
        bing.sort()
        childi = 0
        bingi = 0
        res = 0
        while childi < len(child) and bingi < len(bing):
            if child[childi] > bing[bingi]:
                childi+=1
                bingi += 1
                res += 1
            else:
                bingi += 1
            return res


