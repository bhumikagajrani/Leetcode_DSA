class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int s=0,e=0,count=0;
        while(e<nums.length)
        {
            if(nums[e]==0)
            {
                count++;
            }
            e++;
            if(count>k)
            {
                if(nums[s]==0)
                {
                    count--;
                }
                s++;
            }
        }
        return e-s;
    }
}
