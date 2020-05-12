package G20200343040039


import "container/heap"

type IntHeap []int
func (h IntHeap) Len() int {
	return len(h)
}

func (h IntHeap) Less(i, j int) bool {
	return h[i] < h[j]
}

func (h IntHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *IntHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
	res := (*h)[len(*h)-1]
	*h = (*h)[0:len(*h)-1]
	return res
}

type Leaderboard struct {
	m map[int]int
}

func Constructor() Leaderboard {
	return Leaderboard{m:map[int]int{}}
}

func (this *Leaderboard) AddScore(playerId int, score int)  {
	this.m[playerId] += score
}

func (this *Leaderboard) Top(K int) int {
	h := &IntHeap{}
	heap.Init(h)
	for _, v := range this.m {
		heap.Push(h, v)
		if h.Len()>K {
			heap.Pop(h)
		}
	}
	res := 0
	for h.Len() > 0 {
		res += heap.Pop(h).(int)
	}
	return res
}


func (this *Leaderboard) Reset(playerId int)  {
	this.m[playerId] = 0
}