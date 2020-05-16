#include <cstdint>
using namespace std;

class Solution {
   public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t result = 0, power = 31;
        // 使用位运算，遍历移位
        while (n != 0) {
            result += (n & 1) << power;
            n = n >> 1;
            power -= 1;
        }
        return result;
    }
};