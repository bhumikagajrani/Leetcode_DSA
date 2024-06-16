class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> list = new ArrayList<>();
        Queue<Integer> courses = new LinkedList<>();
        int indegree[] = new int[numCourses];

        for(int i=0;i<numCourses;i++) {
            list.add(new ArrayList<>());
        }

        for(int[] pre:prerequisites) {
            list.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        for(int i=0;i<numCourses;i++) {
            if(indegree[i]==0) {
                courses.offer(i);
            }
        }

        int ans[] = new int[numCourses];
        int j=0, nodesvisited=0;
        while(!courses.isEmpty()) {
            nodesvisited++;
            ans[j]=courses.poll();
            for(int i:list.get(ans[j]))
            {
                indegree[i]--;
                if(indegree[i]==0) {
                    courses.offer(i);
                }
            }
            j++;
        }
        if(j==numCourses) {
            return ans;
        }
        
        return new int[0];  
    }
}
