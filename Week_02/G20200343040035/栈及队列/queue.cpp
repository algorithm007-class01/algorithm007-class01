#include <iostream>
#include<vector>
using namespace std;

class Queue{
private:
    vector<int> data;
    int p_start;

public:
    Queue() { p_start = 0; }
    bool enQueue(int val){
        data.push_back(val);
        return true;
    }
    bool deQueue(){
        if (isEmpty())return false;
        p_start++;
        return true;
    }
    int front(){
        return data[p_start];
    }
    int isEmpty(){
        return p_start >= data.size();
    }
};


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