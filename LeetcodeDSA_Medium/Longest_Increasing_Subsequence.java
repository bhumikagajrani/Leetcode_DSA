class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int next[] = new int[n+1];
        int curr[] = new int[n+1];
        
        for(int ind=nums.length-1;ind>=0;ind--) {
            for(int prev_ind=ind-1;prev_ind>=-1;prev_ind--) {
                
                int notpick = next[prev_ind+1];
                int pick=Integer.MIN_VALUE;
                if(prev_ind==-1 || nums[ind]>nums[prev_ind]) {
                    pick=1+next[ind+1];
                }
                curr[prev_ind+1]=Math.max(pick,notpick);

            }
            next=curr;

        }

        return next[0];
        
    }
}
