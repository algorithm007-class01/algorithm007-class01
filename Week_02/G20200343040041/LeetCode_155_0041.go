package G20200343040041

//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
//
//push(x) -- 将元素 x 推入栈中。
//pop() -- 删除栈顶的元素。
//top() -- 获取栈顶元素。
//getMin() -- 检索栈中的最小元素。

//解题思路：使用两个栈
type intStack struct{
	stack []int
}


func (i *intStack) empty() bool{
	return len(i.stack)==0
}

func (i *intStack) push(e int){
	i.stack =append(i.stack,e)
}

func (i *intStack) peek() int{
	if i.empty(){
		panic("stack is empty")
	}
	return i.stack[len(i.stack)-1]
}

func (i *intStack) pop() int{
	if i.empty(){
		panic("stack is empty")
	}
	val:=i.stack[len(i.stack)-1]

	i.stack = i.stack[:len(i.stack)-1]

	return val
}

type MinStack struct {
	mins intStack
	nums intStack
}


/** initialize your data structure here. */
func Constructor() MinStack {
	return MinStack{}
}


func (this *MinStack) Push(x int)  {
	this.nums.push(x)
	if this.mins.empty()||x<=this.mins.peek(){
		this.mins.push(x)
	}
}


func (this *MinStack) Pop()  {
	val := this.nums.pop()
	if val==this.mins.peek(){
		this.mins.pop()
	}
}


func (this *MinStack) Top() int {
	return this.nums.peek()
}


func (this *MinStack) GetMin() int {
	return this.mins.peek()
}


/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */
