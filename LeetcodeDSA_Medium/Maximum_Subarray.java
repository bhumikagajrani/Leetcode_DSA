class Solution {
    public int maxSubArray(int[] nums) {

        return helper(nums,0,nums.length-1);

    }

    public int helper(int nums[], int i, int j)
    {
        if(i==j) return nums[i];

        int mid=(i+j)/2;
        int sum=0, leftMaxSum=Integer.MIN_VALUE, rightMaxSum=Integer.MIN_VALUE;
        for(int l=mid;l>=i;l--)
        {
            sum=sum+nums[l];
            if(sum>leftMaxSum)
            {
                leftMaxSum=sum;
            }
        }

        sum=0;
        for(int l=mid+1;l<=j;l++)
        {
            sum=sum+nums[l];
            rightMaxSum=Math.max(sum,rightMaxSum);
        }
        
        int maxLeftRight = Math.max(helper(nums,i,mid),helper(nums,mid+1,j));
        return Math.max(maxLeftRight, leftMaxSum+rightMaxSum);
    }


        
}