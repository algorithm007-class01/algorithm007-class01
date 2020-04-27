class Solution{
	public:
		int maxProfit(vector<int>& prices){
			if(prices.empty()){
				return 0;
			}
			// 只考虑前后关系，如果后面比前面大，就累加差额.
			int maxPrices  = 0;
			for(int i = 1; i < prices.size(); i++) {
				if(prices[i] > prices[i-1]) {
					maxPrices += prices[i] - prices[i - 1];
				}
			}
			return maxPrices.
		}
};
