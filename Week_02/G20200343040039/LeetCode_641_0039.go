package G20200343040039

type ListNode struct {
	value int
	pre *ListNode
	next *ListNode
}

type MyCircularDeque struct {
	head *ListNode
	tail *ListNode
	len int
	cap int
}



// ["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]
// [[3],[1],[2],[3],[4],[],[],[],[4],[]]


/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {
	return MyCircularDeque{
		head: nil,
		tail: nil,
		len: 0,
		cap: k,
	}
}


/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
	if this.IsFull() {
		return false
	}

	node := &ListNode{
		value: value,
		pre: nil,
		next: nil,
	}

	if this.IsEmpty() {
		this.head = node
		this.tail = node
		this.len++
		return true
	}

	this.head.pre = node
	node.next = this.head
	this.head = node

	this.len++

	return true
}


/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
	if this.IsFull() {
		return false
	}

	node := &ListNode{
		value: value,
		pre: nil,
		next: nil,
	}

	if this.IsEmpty() {
		this.head = node
		this.tail = node
		this.len++
		return true
	}

	this.tail.next = node
	node.pre = this.tail
	this.tail = node

	this.len++

	return true
}


/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {
	if this.IsEmpty() {
		return false
	}

	if this.len == 1 {
		this.head = nil
		this.tail = nil
		this.len--

		return true
	}

	newHead := this.head.next
	newHead.pre = nil
	this.head.next = nil
	this.head = newHead

	this.len--

	return true
}


/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
	if this.IsEmpty() {
		return false
	}

	if this.len == 1 {
		this.head = nil
		this.tail = nil
		this.len--
		return true
	}

	newTail := this.tail.pre
	this.tail.pre.next = nil
	this.tail = newTail
	this.tail.next = nil

	this.len--

	return true
}


/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {
	if this.IsEmpty() {
		return -1
	}
	return this.head.value
}


/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {
	if this.IsEmpty() {
		return -1
	}
	return this.tail.value
}


/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
	if this.len == 0 {
		return true
	}

	return false
}


/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
	if this.len == this.cap {
		return true
	}

	return false
}


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * obj := Constructor(k);
 * param_1 := obj.InsertFront(value);
 * param_2 := obj.InsertLast(value);
 * param_3 := obj.DeleteFront();
 * param_4 := obj.DeleteLast();
 * param_5 := obj.GetFront();
 * param_6 := obj.GetRear();
 * param_7 := obj.IsEmpty();
 * param_8 := obj.IsFull();
 */