class Solution {
    public boolean canPartition(int[] nums) {

        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++) {
            sum+=nums[i];
        }
        if(sum%2==1) {
            return false;
        }
        int target=sum/2;
        boolean prev[] = new boolean[target+1];
        prev[0]=true;

        if(nums[0]<=target) {
            prev[nums[0]]=true;
        }

        for(int i=1;i<n;i++) {
            boolean curr[] = new boolean[target+1];
            curr[0]=true;
            for(int j=1;j<=target;j++) {
                boolean notpick = prev[j];
                boolean pick=false;
                if(nums[i]<=j) {
                    pick = prev[j-nums[i]];
                }
                curr[j]=(pick || notpick);
            }
            prev=curr;
        }
        return prev[target];
        
    }
}
