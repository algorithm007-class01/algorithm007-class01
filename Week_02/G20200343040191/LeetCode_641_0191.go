type MyCircularDeque struct {
    buffer []int
    cnt int
    k int
    front int
    rear int
}


/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {
    return MyCircularDeque{
        buffer: make([]int, k),
        cnt: 0,
        k: k,
        front: k - 1,
        rear: 0,
    }
}


/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
    if this.cnt == this.k {
        return false
    }
    this.buffer[this.front] = value
    this.front = (this.front - 1 + this.k) % this.k
    this.cnt++

    return true
}


/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
    if this.cnt == this.k {
        return false
    }
    this.buffer[this.rear] = value
    this.rear = (this.rear + 1) % this.k
    this.cnt++

    return true
}


/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {
    if this.cnt == 0 {
        return false
    }
    this.front = (this.front + 1) % this.k
    this.cnt--

    return true
}


/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
    if this.cnt == 0 {
        return false
    }
    this.rear = (this.rear - 1 + this.k) % this.k
    this.cnt--

    return true
}


/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {
    if this.cnt == 0 {
        return -1
    }
    return this.buffer[(this.front + 1) % this.k]
}


/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {
    if this.cnt == 0 {
        return -1
    }
    return this.buffer[(this.rear - 1 + this.k) % this.k]
}


/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
    return this.cnt == 0
}


/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
    return this.cnt == this.k
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
