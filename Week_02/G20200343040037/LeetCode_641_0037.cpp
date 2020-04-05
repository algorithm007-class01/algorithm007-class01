class MyCircularDeque {
private:
	int front_;
	int rear_;
	int size_;
	int capacity_;
	vector<int> vec_;
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k):size_(0), rear_(0), front_(k - 1), capacity_(k) {
        vec_.reserve(k);
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if(isFull()){
		return false;
	}
	vec_[front_] = value;
	front_ = (front_ - 1 + capacity_) % capacity_;
	size_++;
	return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
         if(isFull()){
                return false;
        }
        vec_[rear_] = value;
        rear_ = (rear_ + 1) % capacity_;
        size_++;
        return true;

    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if(isEmpty()){
                return false;
        }
        front_ = (front_ + 1) % capacity_;
        size_--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if(isEmpty()){
                return false;
        }
        rear_ = (rear_ - 1 + capacity_) % capacity_;
        size_--;
        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if(isEmpty()){
		return false;
	}
	return vec_[(front_ + 1)% capacity_];
    }
    
    /** Get the last item from the deque. */
    int getRear() {
         if(isEmpty()){
                return false;
        }
        return vec_[(rear_ - 1 + capacity_)% capacity_];
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return size_ == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return size_ == capacity_;
    }
};
