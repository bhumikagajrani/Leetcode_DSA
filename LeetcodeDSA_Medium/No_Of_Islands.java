class Solution {
    public int numIslands(char[][] grid) {

        if(grid==null || grid.length==0)
        return 0;
        
        int row = grid.length, col=grid[0].length;
        int num_island=0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]=='1') {
                    DFS(grid,i,j);
                    num_island++;
                }
            }
        }
        return num_island;
    }

    private void DFS(char[][] grid, int r, int c) {

        int nr=grid.length, nc=grid[0].length;

        if(r<0 || r>=nr || c<0 || c>=nc || grid[r][c]=='0')
        {
            return;
        }

        grid[r][c]='0';
        DFS(grid,r,c-1);
        DFS(grid,r-1,c);
        DFS(grid,r,c+1);
        DFS(grid,r+1,c);

    }
}
