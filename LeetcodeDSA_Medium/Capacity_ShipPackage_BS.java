class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=Integer.MIN_VALUE, sum=0;

        for(int i=0;i<weights.length;i++)
        {
            sum+=weights[i];
            max=Math.max(max,weights[i]);
        }
        int l=max,h=sum;
        while(l<=h)
        {
            int mid=(l+h)/2;
            if(findDays(weights,mid)<=days)
            {
                h=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return l;
        
    }
    public int findDays(int weights[], int cap)
    {
        int day=1, sum=0;
        for(int i=0;i<weights.length;i++)
        {
            sum+=weights[i];
            if(sum>cap)
            {
                day++;
                sum=weights[i];
            }
        }
        return day;
    }

}
