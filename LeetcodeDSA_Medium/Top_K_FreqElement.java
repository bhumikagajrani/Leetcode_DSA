class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int[] ans = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap=new PriorityQueue<>(
            (a,b)->(map.get(a)-map.get(b))
        );

        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(int i:map.keySet())
        {
            heap.offer(i);
            if(heap.size()>k)
            {
                heap.poll();
            }
        }

        for(int i=k-1;i>=0;i--)
        {
            ans[i]=heap.poll();
        }
        return ans;

        
    }
}
