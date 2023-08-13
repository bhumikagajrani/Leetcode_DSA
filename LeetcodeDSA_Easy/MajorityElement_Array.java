class Solution {
    public int majorityElement(int[] nums) {
        
        int count=0, element=0, n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(count == 0)
            {
                element = nums[i];
                count = 1;
            }
            else
            {
                if(element == nums[i])
                {
                    count++;
                }
                else
                count--;
            }
        }
        count=0;
        for(int i=0;i<n;i++)
        {
            if(element == nums[i])
            {
                count++;
            }
        }
        if(count > n/2)
        return element;
    return -1;
    }
    
}