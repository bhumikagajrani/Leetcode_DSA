class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> st = new Stack<>();
        int visited[] = new int[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            DFS(i,adj,visited,st);
        }
        int ans[] = new int[V];
        int j=0;
        while(!st.isEmpty()) {
            ans[j]=st.pop();
            j++;
        }
        return ans;
    }
    
    static void DFS(int vertex, ArrayList<ArrayList<Integer>> adj, int[] visited, Stack<Integer> st) {
        
        visited[vertex]=1;
        for(int i:adj.get(vertex)) {
            if(visited[i]==0) {
                DFS(i,adj,visited,st);
            }
        }
        st.push(vertex);
        
        
    }
    
    
}
