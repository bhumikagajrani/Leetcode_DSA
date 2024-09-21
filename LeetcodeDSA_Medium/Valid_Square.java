class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        HashSet<Integer> set = new HashSet<>();
        set.add(dist(p1,p2));
        set.add(dist(p2,p3));
        set.add(dist(p3,p4));
        set.add(dist(p1,p4));
        set.add(dist(p1,p3));
        set.add(dist(p2,p4));

        return (!set.contains(0) && set.size()==2);
        
    }

    private int dist(int[] pt1, int[] pt2) {

        return ((pt1[0]-pt2[0])*(pt1[0]-pt2[0]) + (pt1[1]-pt2[1])*(pt1[1]-pt2[1]));
        
    }
}
