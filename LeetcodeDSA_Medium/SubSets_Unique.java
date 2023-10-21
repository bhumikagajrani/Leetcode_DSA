class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        GenerateSubset(0,nums,new ArrayList<Integer>(),ans);
        return ans;
    }
    private void GenerateSubset(int i, int[] nums, List<Integer> list, List<List<Integer>> ans)
    {
        if(i==nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        GenerateSubset(i+1,nums,list,ans);
        list.remove(list.size()-1);

        GenerateSubset(i+1,nums,list,ans);
        
    }
}
