class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1, amt=0, maxleft=0, maxright=0; 
        while(l<=r)
        {
            if(height[l]<=height[r])
            {
                if(height[l]>=maxleft)
                {
                    maxleft=height[l];
                }
                else
                {
                    amt += maxleft-height[l];
                }
                l++;
            }
            else
            {
                if(height[r]>=maxright)
                {
                    maxright=height[r];
                }
                else
                {
                    amt+=maxright-height[r];
                }
                r--;
            }
        }
        return amt;

    }
}
