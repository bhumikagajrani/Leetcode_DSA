class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m=matrix.length, n=matrix[0].length;
        //int l=0, h=(m*n)-1;
        /*while(l<=h)
        {
            int mid=(l+h)/2;
            if(matrix[mid/n][mid%n]==target)
            {
                return true;
            }
            else if(matrix[mid/n][mid%n]<target)
            {
                l=mid+1;
            }
            else
            {
                h=mid-1;
            }
        }*/
        for(int i=0;i<m;i++)
        {
            if(matrix[i][0]<=target && target<=matrix[i][n-1])
            {
                int l=0, h=n-1;
                while(l<=h)
                {
                    int mid=(l+h)/2;
                    if(matrix[i][mid]==target)
                    {
                        return true;
                    }
                    if(matrix[i][mid]<target)
                    l=mid+1;
                    else
                    h=mid-1;
                }

            }
        }
        return false;
    }
}
