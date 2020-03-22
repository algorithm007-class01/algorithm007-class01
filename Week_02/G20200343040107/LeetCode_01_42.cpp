#include <iostream>
#include <vector>
#include <algorithm>

using namespace std; 

int trap(vector<int>& height) {
    if(height.empty()) {
        return 0;
    }

    int len = height.size();
    vector<int> left_max(len);
    left_max[0] = height[0];
    vector<int> right_max(len);
    right_max[len-1] = height[len-1];

    for(int i = 1; i < len; i++) {
        left_max[i] = max(height[i], left_max[i-1]);
    }
    for(int i = len-2; i >=0; i--) {
        right_max[i] = max(height[i], right_max[i+1]);
    }

    int rain_volume = 0;
    for(int i = 1; i < len - 1; i++) {
        rain_volume += min(left_max[i], right_max[i]) - height[i];
    }

    return rain_volume;
}

void test_case() {
    // 在leetcode已经测试过
}


int main(int argc, char* argv) {
    test_case();
	return 0; 
}