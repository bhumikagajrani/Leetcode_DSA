class Solution {
    public boolean exist(char[][] board, String word) {

        return (Helper(board,word));
    }


    private boolean Helper(char[][] board, String word)
    {

        int m = board.length;
        int n = board[0].length;
        int i=0, j=0;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(SearchNext(board,word,0,i,j,m,n))
                    return true;
                }
            }
        }

       return false;
    }

    private boolean SearchNext(char[][] board, String word, int index, int i, int j, int m, int n)
    {

        if(index==word.length())
        {
            return true;
        }

        if(i<0 || j<0 || i==m || j==n || board[i][j]!=word.charAt(index))
        {
            return false;
        }
        char c = board[i][j];
        board[i][j]='#';
        boolean left = SearchNext(board,word,index+1,i,j-1,m,n);
        boolean right = SearchNext(board,word,index+1,i,j+1,m,n);
        boolean top = SearchNext(board,word,index+1,i-1,j,m,n);
        boolean down = SearchNext(board,word,index+1,i+1,j,m,n);
        board[i][j]=c;
        return (left || right || top || down);
        
    }
}
