class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        Helper(0,board,ans);
        return ans;
        
    }

    private void Helper(int col, char[][] board, List<List<String>> ans)
    {
        if(col==board.length)
        {
            ans.add(form(board));
            return;
        }

        for(int row=0;row<board.length;row++)
        {
            if(isSafe(row,col,board))
            {
                board[row][col]='Q';
                Helper(col+1,board,ans);
                board[row][col]='.';
            }
        }
        
        
    }

    private List<String> form(char[][] board)
    {
        List<String> list = new ArrayList<>();
        for(int i=0;i<board.length;i++)
        {
            String res  = new String(board[i]);
            list.add(res);
        }
        return list;
        
    }

    private boolean isSafe(int i, int j, char[][] board)
    {
        
        int r=i, c=j;
        while(r>=0 && c>=0)
        {
            if(board[r][c]=='Q')
            return false;
            r--;
            c--;
        }

        r=i;
        c=j;

        while(c>=0)
        {
            if(board[r][c]=='Q')
            return false;
            c--;
        }

        r=i;
        c=j;

        while(r<board.length && c>=0)
        {
            if(board[r][c]=='Q')
            return false;
            r++;
            c--;
        }

        return true;
    }
}
