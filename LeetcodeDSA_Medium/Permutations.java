class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Helper(0,nums,ans);
        return ans;
    }

    private void Helper(int ind, int nums[], List<List<Integer>> ans)
    {
        
        if(ind==nums.length)
        {
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<nums.length;i++)
            {
                list.add(nums[i]);
            }
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=ind;i<nums.length;i++)
        {
            swap(ind,i,nums);
            Helper(ind+1,nums,ans);
            swap(ind,i,nums);
        
        }   
    }

    private void swap(int n1, int n2, int[] nums)
    {
        int temp=nums[n1];
        nums[n1]=nums[n2];
        nums[n2]=temp;
    }
}
