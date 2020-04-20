package app;

public class LeetCode_122_0333 {
    public int maxProfit(int[] prices) {
        if(null==prices||prices.length<=1) return 0;
        //return getMaxValue(prices,0);
        return getMaxValueBetter(prices,0);
    }
    private int getMaxValueBetter(int[] prices,int start){
        
        int max=0;
        for(int i=start+1;i<prices.length;i++){
            if(prices[i]<=prices[i-1]){
                continue;
                
            }else{
                max+=prices[i]-prices[i-1];
            }
            
        }
        return max;
    }
    private int getMaxValue(int[] prices,int start){
        if(start==prices.length) return 0;
        
        int max=0;
        for(int i=start+1;i<prices.length;i++){
            //System.out.println(max+","+i+","+start);
            if(prices[i]<prices[i-1]){
                
                max+=getMaxValue(prices,i);
                break;
            }else{
                max+=prices[i]-prices[i-1];
            }
            
        }
        return max;
    }
}