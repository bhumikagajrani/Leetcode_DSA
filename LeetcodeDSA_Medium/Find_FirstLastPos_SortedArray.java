class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] res = new int[2];
        res[0]=findOccurence(nums,target,true);
        res[1]=findOccurence(nums,target,false);
        return res;

    }
   
        public int findOccurence(int[] nums, int target, boolean check)
        {
        int l=0, h=nums.length-1, ans=-1;
        while(l<=h)
        {
            int mid=(l+h)/2;
            if(nums[mid]==target) 
            {
                if(check==true)
                h=mid-1;
                else
                l=mid+1;
                ans=mid;
            }
            else if(nums[mid]<target)
            {
                l=mid+1;
            }
            else
            {
                h=mid-1;
            }
        }
        return ans;
        }
}
