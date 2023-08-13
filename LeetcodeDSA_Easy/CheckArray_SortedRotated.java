class Solution {
    public boolean check(int[] nums) {
        int irr=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>nums[(i+1)%nums.length])
            {
                irr+=1;
            }
        }
        return irr<=1;
    }
}