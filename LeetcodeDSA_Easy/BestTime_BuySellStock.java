class Solution {
    public int maxProfit(int[] prices) {
       int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
       return maxprofit;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        while(sc.hasNextInt())
        {
            int val = sc.nextInt();
            array.add(val);
        }
        int prices[] = new int[array.size()];
        for(int i=0;i<array.size();i++)
        {
            prices[i] = array.get(i);
        }
        Solution obj = new Solution();
        int maxProfit = obj.maxProfit(prices);
        System.out.print(maxProfit);

    }
}