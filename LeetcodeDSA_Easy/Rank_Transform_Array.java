class Solution {
    public int[] arrayRankTransform(int[] arr) {

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++)
        {
            minheap.offer(arr[i]);
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        int temp=1;
        while(!minheap.isEmpty())
        {
            int val=minheap.poll();
            if(!map.containsKey(val))
            {
                map.put(val,temp++);
            }
        }

        for(int i=0;i<arr.length;i++)
        {
            
            arr[i]=map.get(arr[i]);
        }
        return arr;

    }
}
