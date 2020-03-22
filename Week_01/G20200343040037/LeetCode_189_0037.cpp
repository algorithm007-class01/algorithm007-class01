class Solution{
	public:
		void rotate(vector<int>& nums, int k){
			// 方法一：三步反转大法.
			// size-k ~ size -1处子数组记为X
			// 0 ~ size - k - 1处子数组记为Y
			// 第一步：将X反转，X->X^T;
			// 第二步：将Y反转, Y->Y^T.
			// 第三步: 将X^TY^T反转，(X^TY^T)^T = YX

			/*int size = nums.size();
			k %= size;// 防止k大于size的情况出现
			int start = size - k;
			int end = size - 1;
			reverse(nums, start, end);

			start = 0;
			end = size - k - 1;
			reverse(nums, start, end);

			start = 0;
			end = size - 1;
			reverse(nums, start, end);*/

			// 第二种方法：元素后移末尾元素前插法
			int size = nums.size();
			k %= size;// 防止k大于size
			int temp = 0;
			while(k-- > 0){ 
				temp = nums[size - 1];// 记录末尾元素
				for(int i = size - 1; i >=0; i--){ // 将size - 1个元素后移
					nums[i] = nums[i-1];
				}
				nums[0] = temp;// 末尾元素前插，作为首元素。
			}
		}
		void reverse(vector<int>& nums, int start, int end){
			int temp = 0;
			while(start < end){
				temp = nums[start];
				nums[start++] = nums[end];
				nums[end--] = temp;
			}
		}
};
