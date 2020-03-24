#include <iostream>
#include<vector>
#include<stack>
#include<queue>

using namespace std;

class MyStack {
private:
    queue<int> en_queue, de_queue;
    int topVal;
public:
    /** Initialize your data structure here. */
    MyStack() {
    
    }
    /** Push element x onto stack. */
    void push(int x) {
        en_queue.push(x);
        topVal = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    int pop() {
        while(en_queue.size()>1){
            topVal = en_queue.front;//注意此处
            de_queue.push(topVal);
            en_queue.pop();
        }
        int res = en_queue.front();
        en_queue.pop();
        en_queue.swap(de_queue);
        return res;
    }
    
    /** Get the top element. */
    int top() {
        return topVal;
    }
    
    /** Returns whether the stack is empty. */
    bool empty() {
        return en_queue.empty();
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */


// int main(){
//     MyStack s;
//     s.push(1);
//     s.push(2);
//     s.push(3);
//     for (int i = 0; i < 4;++1){
//         if(s.isEmpty()){
//             cout << s.top() << endl;
//         }
//         cout << (s.pop() ? "ture" : "false") << endl;
//     }
// }