class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxarea=0;
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<=heights.length;i++)
        {

            while(!st.isEmpty() && (i==heights.length || heights[st.peek()]>=heights[i]))
            {
                int height = heights[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty())
                {
                    width=i;
                }
                else
                {
                    width=i-st.peek()-1;
                }
                maxarea=Math.max(maxarea, height*width);
            }
            
            st.push(i);
        }
        return maxarea;
        
    }
}
