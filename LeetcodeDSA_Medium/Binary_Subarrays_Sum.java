class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        return atmost(nums,goal)-atmost(nums,goal-1);     
        
    }

    private int atmost(int[] nums, int goal)
    {
        int s=0, e=0, count=0, sum=0, ans=0;
        while(e<nums.length)
        {
            sum=sum+nums[e];
            while(s<=e && sum>goal)
            {
                sum-=nums[s];
                s++;
            }
            ans=ans+(e-s+1);
            e++;
        }
        return ans; 

    }
}
