class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new int[]{i,j});
                }
                else
                {
                    mat[i][j]=-1;
                }
            }
        }

        int[] deltax = {0,-1,0,1};
        int[] deltay = {-1,0,1,0};
        int distance=0;

        while(!q.isEmpty())
        {
            int size=q.size();
            distance++;
            while(size>0)
            {
                int[] top = q.poll();
                int r = top[0], c = top[1];
                for(int i=0;i<4;i++)
                {
                    int newrow = r+deltax[i];
                    int newcol = c+deltay[i];
                    if(newrow<0 || newcol<0 || newrow+1>m || newcol+1>n || mat[newrow][newcol]>=0)
                    {
                        continue;
                    }

                    mat[newrow][newcol]=distance;
                    q.offer(new int[]{newrow,newcol});
                }
                size--;
            }

        }
        return mat;
    }
}
