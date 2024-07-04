class Solution {
    public int coinChange(int[] coins, int amount) {

        int prev[] = new int[amount+1];
        int n = coins.length;

        for(int i=0;i<=amount;i++) {
            if(i%coins[0]==0) {
                prev[i]=i/coins[0];
            }
            else {
                prev[i]=(int)1e9;
            }
        }
        
        for(int i=1;i<n;i++) {
            int curr[] = new int[amount+1];
            for(int j=0;j<=amount;j++) {
                int notpick = prev[j];
                int pick=(int)1e9;
                if(coins[i]<=j) {
                    pick = 1+curr[j-coins[i]];
                }
                curr[j]=Math.min(pick,notpick);
            }
            prev=curr;
        }

        if(prev[amount]>=(int)1e9) {
            return -1;
        }
        return prev[amount];
        
    }
}
