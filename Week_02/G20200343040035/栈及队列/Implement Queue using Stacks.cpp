#include <iostream>
#include<vector>
#include<stack>

using namespace std;

class MyQueue {
private:
    stack<int> inStack,outStack;
    int in_pos,out_pos;
public:
    /** Initialize your data structure here. */
    MyQueue() {
        in_pos = 0;
        out_pos = 0;
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        inStack.push(x);
        in_pos++;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        if (outStack.empty()){
            while (!inStack.empty()){
                outStack.push(inStack.top());
                inStack.pop();
            }
        }
        int res = outStack.top();
        outStack.pop();
        return res;

    }
    
    /** Get the front element. */
    int peek() {
        if (outStack.empty()){
            while (!inStack.empty()){
                outStack.push(inStack.top());
                inStack.pop();
            }
        }
        int res = outStack.top();
        return res;

    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return inStack.empty() && outStack.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */


int main(){
    MyStack s;
    s.push(1);
    s.push(2);
    s.push(3);
    for (int i = 0; i < 4;++1){
        if(s.isEmpty()){
            cout << s.top() << endl;
        }
        cout << (s.pop() ? "ture" : "false") << endl;
    }
}