#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int hammingWeight(uint32_t n) {
        int sum = 0;
        while (n != 0) {
            ++sum;
            n &= (n-1);
        }
        return sum;
    }
};

void test_case() {
    Solution sol;
    uint32_t  data = 0b00000000000000000000000000001011;
    if ( 3 == sol.hammingWeight(data)) {
        cout << "run success" << endl;
    }
}

int main(int argc, char* argv[]) {
    test_case();
	return 0;
}