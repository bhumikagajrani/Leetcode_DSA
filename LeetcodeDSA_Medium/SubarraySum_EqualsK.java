class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixsum=0, count=0;
        for(int i=0;i<nums.length;i++)
        {
            prefixsum+=nums[i];
            int remain = prefixsum-k;
            if(map.containsKey(remain))
            {
                count+=map.get(remain);
            }
            map.put(prefixsum, map.getOrDefault(prefixsum,0)+1);
        }
        return count;


    }
}