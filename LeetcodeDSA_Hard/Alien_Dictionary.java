class Solution {
    public String alienOrder(String[] words) {

        Map<Character,List<Character>> adjList = new HashMap<>();
        Map<Character,Integer> indegree = new HashMap<>();

        for(String i:words) {
            for(char c:i.toCharArray()) {
                adjList.put(c,new ArrayList<>());
                indegree.put(c,0);
            }
        }

        for(int i=0;i<words.length-1;i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            if((word1.length()>word2.length()) && (word1.startsWith(word2))){
                return "";
            }

            for(int j=0;j<Math.min(word1.length(),word2.length());j++) {
                char char1 = word1.charAt(j);
                char char2 = word2.charAt(j);
                if(char1!=char2) {
                    adjList.get(char1).add(char2);
                    indegree.put(char2,indegree.get(char2)+1);
                    break;
                }
            }
        }

            Queue<Character> q = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for(char c:indegree.keySet()) {
                if(indegree.get(c)==0) {
                    q.add(c);
                }
            }

            while(!q.isEmpty()) {
                Character c = q.poll();
                sb.append(c);
                for(char next:adjList.get(c)) {
                    indegree.put(next,indegree.get(next)-1);
                    if(indegree.get(next)==0) {
                        q.add(next);
                    }
                }
            }

            if(sb.length()<indegree.size()) {
                return "";
            }
            return sb.toString();
        
    }
}
