class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Queue<Integer> courses = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        int indegree[] = new int[numCourses];
        
        for(int i=0;i<numCourses;i++) {
            list.add(new ArrayList<>());
        }

        for(int[] pre:prerequisites) {
            list.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }

        for(int i=0;i<numCourses;i++) {
            if(indegree[i]==0) {
                courses.add(i);
            }
        }

        int nodesvisited=0;
        while(!courses.isEmpty()) {
            int vertex = courses.poll();
            nodesvisited++;
            for(int neighbour:list.get(vertex)) {
                indegree[neighbour]--;
                if(indegree[neighbour]==0) {
                    courses.add(neighbour);
                }
            }
        }

        return nodesvisited==numCourses;
    }
}
