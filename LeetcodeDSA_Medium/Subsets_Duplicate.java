class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);


        List<List<Integer>> ans = new ArrayList<>();
       
        Helper(nums, new ArrayList<Integer>(), 0, ans);
        return ans;
        
    }
    private void Helper(int[] nums, List<Integer> list, int i, List<List<Integer>> ans)
    {
        ans.add(new ArrayList<>(list));
        
        for(int j=i;j<nums.length;j++)
        {
            if(j!=i  && (nums[j]==nums[j-1]))
            {
                continue;
            }

            list.add(nums[j]);
            Helper(nums,list,j+1,ans);
            list.remove(list.size()-1);
        }

    }
}
