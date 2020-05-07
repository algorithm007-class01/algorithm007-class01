class Solution {
public:    
    void heapSort (int a[], int len) {

        priority_queue<int, vector<int>, greater<int>> q;
        for (int i = 0; i < len; i++) {
            q.push(a[i]);
        }
        
        for (int i = 0; i < len; i++) {
            a[i] = q.pop();
        }
    }
};    























