class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        unordered_map<int, int> map;
        vector<int> res;
        vector<int> restemp;
        for (int i = 0; i < arr1.size(); i++)  {
          map[arr1[i]]++;
        }
        for (int i = 0; i < arr2.size(); i++) {
          while (map[arr2[i]] > 0) {
            res.push_back(arr2[i]);
            map[arr2[i]]--;
          }
        }
        for (int num: arr1) {
          if (map[num] > 0) {
            restemp.push_back(num);
          }
        }
        sort(restemp.begin(),restemp.end());
        res.insert(res.end(), restemp.begin(), restemp.end());
        return res;
    }
};