class Solution {
    public void solveSudoku(char[][] board) {

        Helper(board);
        
    }

    private boolean Helper(char[][] board)
    {
        for(int row=0;row<board.length;row++)
        {
            for(int col=0;col<board.length;col++)
            {
                if(board[row][col]=='.')
                    {
                        for(char num='1';num<='9';num++)
                        {
                            if(canFill(num,row,col,board))
                            {
                                board[row][col]=num;
                                if(Helper(board))
                                return true;
                                else
                                board[row][col]='.';
                            }
                        }
                        return false;
                    }
                    
            }
        }
        return true;
    }
    

    private boolean canFill(int num, int row, int col, char[][] board)
    {
        for(int i=0;i<board.length;i++)
        {
            if(board[row][i]==num)
            return false;
    
            if(board[i][col]==num)
            return false;

            if(board[3*(row/3)+(i/3)][3*(col/3)+(i%3)]==num)
            return false;
        }
        
        return true;


    }
}
