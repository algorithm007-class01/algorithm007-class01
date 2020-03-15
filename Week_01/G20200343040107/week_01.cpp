#include <iostream>
#include <vector>
using namespace  std; 


/*
    remove-duplicates-from-sorted-array/
*/
int removeDuplicates(vector<int>& nums) {
    if(nums.size() <= 0) {
        return 0; 
    }

    int len = nums.size(); 
    int updateIndex = 0; 
    for(int j = 1; j < len; j++) {
        if(nums[updateIndex] != nums[j]) {
            updateIndex++; 
            nums[updateIndex] = nums[j];
        }; 
    }
    return updateIndex+1;
}

void test_remove_duplicate() {
    vector<int> empty_vec; 
    cout <<  "empty array test: " << removeDuplicates(empty_vec) << endl;

    vector<int> no_dup_vec = {1, 2, 3, 4, 5};
    cout <<  "no dup array test: " << removeDuplicates(no_dup_vec) << endl;

    vector<int> dup_vec = {1, 2, 2, 3, 4, 4, 4, 5, 5, 5};
    cout <<  "no dup array test: " << removeDuplicates(dup_vec) << endl;
}


/*
    rotate-array
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
    test_remove_duplicate();
    rotate_test();
    return 0; 
}