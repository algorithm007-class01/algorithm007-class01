class Solution {
public:
    int mySqrt(int x) {
        if (x < 2) return x;
        long long left = 0, right = x / 2;
        while (left <= right) {
            long long mid = (right - left) / 2 + left;
            if (x == mid * mid) return mid;
            else if (x < mid * mid) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
};