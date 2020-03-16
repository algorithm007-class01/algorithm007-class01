#include <iostream>
#include <vector>
using namespace  std; 


/*
    26: remove-duplicates-from-sorted-array/
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

int main(int argc, char* argv[]) {
    test_remove_duplicate();
    return 0; 
}