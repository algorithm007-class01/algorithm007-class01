#include <iostream>
#include<vector>
using namespace std;

class MyStack{
private:
    vector<int> data;
public:
    void push(int x) {
        data.push_back(x);
    }
    bool isEmpty(){
        return data.empty();
    }
    int top(){
        return data.back();
    }
    bool pop(){
        if (isEmpty()){
            return false;
        }
        data.pop_back();
        return true;
    }
};


int main(){
    MyStack s;
    s.push(1);
    s.push(2);
    s.push(3);
    for (int i = 0; i < 4;++i){
        if(s.isEmpty()){
            cout << s.top() << endl;
        }
        cout << (s.pop() ? "ture" : "false") << endl;
    }
}