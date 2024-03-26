class Solution {
    public boolean isBipartite(int[][] graph) {

        int len = graph.length;
        int color[] = new int[len];
        for(int i=0;i<len;i++)
        {
            if(color[i]==0 && !validcolor(i,1,color,graph))
            {
                return false;
            }
        }
        return true;
    }

    private boolean validcolor(int start, int colornode, int[] color, int[][] graph)
    {
        if(color[start]!=0)
        {
            return (color[start]==colornode);
        }
        color[start]=colornode;
        for(int i:graph[start])
        {
            if(!validcolor(i,-colornode,color,graph))
            return false;
        }
        return true;
    }
}
