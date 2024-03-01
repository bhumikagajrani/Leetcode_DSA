class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int visited[]= new int[isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++)
        {
            if(visited[i]==0)
            {
                DFS(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }

    private void DFS(int start, int[][] isConnected, int[] visited) {
        
        visited[start]=1;
        for(int i=0;i<isConnected.length;i++)
        {
            if(visited[i]==0 && isConnected[start][i]==1)
            DFS(i,isConnected,visited);
        }

    }
}
