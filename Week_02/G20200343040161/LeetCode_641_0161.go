package G20200343040161

type MyCircularDeque struct {
	Data        []int
	Cap         int
}


/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {
	data := make([]int, 0)
	return MyCircularDeque{
		Data:   data,
		Cap:    k,
	}
}


/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
	if len(this.Data) == this.Cap {
		return false
	}
	this.Data = append(this.Data, value)
	return true
}


/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
	if len(this.Data) == this.Cap {
		return false
	}
	res := make([]int, len(this.Data)+1)
	res[0] = value
	for i := 0; i < len(this.Data); i++ {
		res[i+1] = this.Data[i]
	}
	this.Data = res
	return true
}


/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {
	if len(this.Data) == 0 {
		return false
	}
	this.Data = this.Data[:len(this.Data)-1]
	return true
}


/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
	if len(this.Data) == 0 {
		return false
	}
	this.Data = this.Data[1:]
	return true
}


/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {
	if len(this.Data) == 0 {
		return -1
	}

	return this.Data[len(this.Data)-1]
}


/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {
	if len(this.Data) == 0 {
		return -1
	}

	return this.Data[0]
}


/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
	if len(this.Data) == 0 {
		return true
	}
	return false
}


/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
	if len(this.Data) == this.Cap {
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
