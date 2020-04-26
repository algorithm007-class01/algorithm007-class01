// class Solution {
// public:
//     int mySqrt(int x) {
//         long long i = 0;
//         long long j = x / 2 + 1;
//         while(i<j){
//             long long mid = i + (j - i) / 2;
//             long long res = mid * mid;
//             if (res == x) return res;
//             else if (res< x)
//                 i = mid + 1;
//             else
//                 j = mid - 1;
//         }
//         return j;
//     }
// };


class Solution {
public:
    int mySqrt(int x) {
        long long i = 0;
        long long j = x / 2 + 1;
        while (i < j){
            long long mid = i + (j - i) / 2;
            long long res = mid * mid;
            if (res == x){
                return mid;
            }
            if (res < x){
                i = mid + 1;
            }
            if (res>x){
                j = mid - 1;
            }
        }
        return i * i == x ? i : -1;
    }
};