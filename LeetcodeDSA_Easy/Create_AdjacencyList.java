import java.util.*;
public class Solution {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            list.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        int[][] graph = new int[n][];
        for(int i=0;i<n;i++)
        {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(i);
            temp.addAll(list.get(i));

            graph[i]=new int[temp.size()];

            for(int j=0;j<temp.size();j++)
            {
                graph[i][j]=temp.get(j);
            }

            
        }
        return graph;
    }
}
