class Solution {
    public int countComponents(int n, int[][] edges) {

        int parent[] = new int[n];
        int size[] = new int[n];
        int count=n;

        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            size[i]=1;
        }

        for(int i=0;i<edges.length;i++)
        {
            count -= combine(parent,size,edges[i][0],edges[i][1]);
        }
        return count;
    }

    private int combine(int[] parent, int[] size, int start, int end) {

        start=find(parent,start);
        end=find(parent,end);

        if(start==end) {
            return 0;
        }
        else {
            if(size[end]>size[start]) {
                parent[start]=end;
                size[end]+=size[start];
            }
            else {
                parent[end]=start;
                size[start]+=size[end];
            }
            return 1;
        }

    }

    private int find(int[] parent, int vertex) {
        if(vertex==parent[vertex])
        {
            return vertex;
        }

        return parent[vertex]=find(parent,parent[vertex]);

    }
}
