#include<vector>
#include<iostream>

using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        if (m == 0)
            return false;
        int n = matrix[0].size();
        int left = 0;
        int right = m * n - 1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            int midElemnet = matrix[mid / n][mid % n];
            if (midElemnet == target){
                return true;
            }
            else if (midElemnet < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false;
        }
};

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        if (m == 0)
            return false;
        int n = matrix[0].size();
        int left = 0;
        int right = m * n - 1;
        int mid,midElemnet;
        while (left < right)
        {
            mid = left + (right - left) / 2;
            midElemnet = matrix[mid / n][mid % n];
            if (midElemnet == target){
                return true;
            }
            else if (midElemnet < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return matrix[left / n][left % n] == target;
    }
};