package G20200343040039

type LRUCacheNode struct {
	key int
	value int
	prev *LRUCacheNode
	next *LRUCacheNode
}

type LRUCache struct {
	cache map[int]*LRUCacheNode
	len int
	capacity int
	head *LRUCacheNode
	tail *LRUCacheNode
}

func Constructor(capacity int) LRUCache {
	lc := LRUCache{
		cache: make(map[int]*LRUCacheNode),
		capacity: capacity,
		len: 0,
	}

	lc.head = &LRUCacheNode{}
	lc.tail = &LRUCacheNode{}
	lc.head.prev = nil
	lc.head.next = lc.tail
	lc.tail.prev = lc.head
	lc.tail.next = nil

	return lc
}

//如果不存在，返回-1，如果存在，移动到表头
func (this *LRUCache) Get(key int) int {
	if _, exist := this.cache[key]; !exist {
		return -1
	}

	this.MoveToHead(this.cache[key])

	return this.cache[key].value
}

//如果key存在，更新value，移动到表头
//如果key不存在，如果满了，需要删除表尾，
func (this *LRUCache) Put(key int, value int)  {
	if _, exist := this.cache[key]; exist {
		this.cache[key].value = value
		this.MoveToHead(this.cache[key])
	} else {
		if this.len > this.capacity {
			panic("impossible")
		}

		if this.len == this.capacity {
			this.DeleteTail()
			this.len--
		}

		node := &LRUCacheNode{
			key: key,
			value: value,
		}

		this.cache[key] = node
		this.AddToHead(node)
		this.len++
	}
}

func (this *LRUCache) MoveToHead(node *LRUCacheNode) {
	this.RemoveNode(node)
	this.AddToHead(node)
}

func (this *LRUCache) RemoveNode(node *LRUCacheNode) {
	node.prev.next = node.next
	node.next.prev = node.prev

	node.next = nil
	node.prev = nil
}

func (this *LRUCache) AddToHead(node *LRUCacheNode) {
	node.prev = this.head
	this.head.next.prev = node

	this.head.next = node
	node.next = this.head.next
}

func (this *LRUCache) DeleteTail() {
	if this.len > 0 {
		delete(this.cache, this.tail.prev.key)
		this.RemoveNode(this.tail.prev)
	}

}
