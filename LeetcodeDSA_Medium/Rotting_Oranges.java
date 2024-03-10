class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int total_orange=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]!=0)
                {
                    total_orange++;
                }
            }
        }
        
        if(total_orange==0) return 0;
        int count_minute=0, count_rotten=0;
        int dx[] = {0,-1,0,1};
        int dy[] = {-1,0,1,0};

        while(!q.isEmpty())
        {
            int size = q.size();
            count_rotten+=size;
            for(int i=0;i<size;i++)
            {
                int[] top=q.poll();
                for(int j=0;j<4;j++)
                {
                    int x = top[0] + dx[j];
                    int y = top[1] + dy[j];

                    if(x<0 || y<0 || x+1>m || y+1>n || grid[x][y]==0 || grid[x][y]==2)
                    {
                        continue;
                    }

                    grid[x][y]=2;
                    q.offer(new int[]{x,y});
                }
            }
            if(q.size()!=0)
            count_minute++;
        }
        return (count_rotten==total_orange)?count_minute:-1; 
    }
}
