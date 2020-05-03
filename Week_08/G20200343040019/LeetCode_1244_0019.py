# 一开始看到top K 想着是不是得用堆实现
class Leaderboard:

    def __init__(self):
        self.rank = {}

    def addScore(self, playerId: int, score: int) -> None:
        if playerId not in self.rank:
            self.rank[playerId] = score
        else:
            self.rank[playerId]+=score

    def top(self, K: int) -> int:
        return sum(sorted(list(self.rank.values()), reverse = True)[:K]) 

    def reset(self, playerId: int) -> None:
        if playerId in self.rank:
            del self.rank[playerId]


# Your Leaderboard object will be instantiated and called as such:
# obj = Leaderboard()
# obj.addScore(playerId,score)
# param_2 = obj.top(K)
# obj.reset(playerId)