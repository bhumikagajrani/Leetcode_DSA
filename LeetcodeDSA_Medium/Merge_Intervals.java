class Solution {
    public int[][] merge(int[][] intervals) {
        
        int n=intervals.length;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int []>()
        {
            public int compare(int a[], int b[])
            {
                return a[0]-b[0];
            }
        });

        for(int i=0;i<n;i++)
        {
            if(res.isEmpty() || intervals[i][0]>res.get(res.size()-1)[1])
            {
                res.add(new int[] {intervals[i][0], intervals[i][1]});
            }
            else
            {
                res.get(res.size()-1)[1] = Math.max(intervals[i][1], res.get(res.size()-1)[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
        
        
    }
}