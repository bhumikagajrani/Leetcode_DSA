class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(n==0) return;
        int rot=1;
        k=k%n;
        while(rot<=k)
        {
            int temp=nums[n-1];
            for(int i=n-1;i>=1;i--)
            {
                nums[i]=nums[i-1];
            }
            nums[0]=temp;
            rot++;
        }

    }
}
        