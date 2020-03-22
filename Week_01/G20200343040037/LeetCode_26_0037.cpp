class Solution{
	public:
		int removeDupliactes(vector<int>& nums){
			// 第一种办法，快慢指针
			/*if(nums.empty()){
				return 0;
			}
			int slow  = 0;// 记录不重复的值索引
			int fast = 1;// 记录数组的下标索引
			while(fast < nums.size()){
				if(nums[slow] != nums[fast]){ // 不等就更新
					slow++;// 只在不相等时更新
					nums[slow] = nums[fast];// 
				}
				fast++;// 不管相不相等，都需要自增.
			}
			return slow + 1;*/

			// 第二种办法 双指针法
			if(nums.empty()){
				return 0;
			}
			int uniqueIndex = 0;// 记录不重复值的下标
			for(int cur = 1; cur < nums.size(); cur++){
				if(nums[cur] != nums[cur - 1]){ // 
					nums[uniqueIndex++] = nums[cur]; 
				}
			}
			return uniqueIndex + 1;
			
		}

};
