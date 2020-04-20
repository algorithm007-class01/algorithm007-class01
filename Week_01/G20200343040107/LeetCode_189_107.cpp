#include <iostream>
#include <vector>
using namespace  std; 


/*
    189: rotate-array
*/
void swap(int &x, int &y) {
    x = x ^ y;
    y = x ^ y; 
    x = x ^ y; 
}

void rotate(vector<int>& nums, int k) {
    if(nums.size() <= 0 || k <= 0 || k >= nums.size()) {
        return;
    }

    int len = nums.size();
    int mid = len >> 1; 
    int tem = 0; 

    for(int i = 0; i < mid; i++) {
        swap(nums[i], nums[len - 1 - i]);
    }

    for(int i = 0; i < (k>>1); i++) {
        swap(nums[i], nums[k - 1 - i]); 
    }

    int step = 0;
    for(int i = k; i < k + ((len - k) >> 1); i++) {
        swap(nums[i], nums[len - 1 - step]);
        step++;
    }
}

void rotate_test() {
    vector<int> vecs = {1, 2, 3, 4};
    rotate(vecs, 2);
    vector<int> vecs2 = {1, 2, 3, 4, 5};
    rotate(vecs2, 2);

    vector<int> vecs3 = {1, 2};
    rotate(vecs3, 1);

    vector<int> vecs4;
    rotate(vecs3, 1);
}


int main(int argc, char* argv[]) {
    rotate_test();
    return 0; 
}