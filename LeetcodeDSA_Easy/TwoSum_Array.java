class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        int ans=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            ans = target-nums[i];
            if(map.containsKey(ans))
            {
                res[0] = i;
                res[1] = map.get(ans);
            }
                map.put(nums[i],i);
            
        }
        return res;
    }
}