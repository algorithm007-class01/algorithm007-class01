class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> record;  //(元素，频率)
        //遍历数组，录入频率
        for(int i = 0; i < nums.size(); i++){
            record[nums[i]]++;
        }
        int n = record.size();

        //扫描record。维护当前出现频率最多的k个元素
        //最小堆。如果当前元素的频率大于优先队列中最小频率元素的频率，则替换
        //优先队列中，按频率排序，所以数据对是(频率，元素)形式
        priority_queue< pair<int,int> , vector< pair<int,int> >, greater< pair<int,int> > > pq;
        for(auto iter = record.begin(); iter != record.end(); iter++){
            if(k == pq.size()){ //队列已满
                if(iter->second > pq.top().first){
                    pq.pop();
                    pq.push(make_pair(iter->second,iter->first));
                }
            }
            else{
                pq.push(make_pair(iter->second,iter->first));
            }
        }

        vector<int> result;
        while(!pq.empty()){
            result.push_back(pq.top().second);
            pq.pop();
        }
        return result;
    }
};