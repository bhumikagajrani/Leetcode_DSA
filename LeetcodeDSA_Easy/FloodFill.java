class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int start=image[sr][sc];
        if(start!=color)
        {
            Helper(image, sr, sc, start, color);
        }
        return image;
    }

    private void Helper(int[][] image, int sr, int sc, int start, int color) {

        if(image[sr][sc]==start)
        {
            image[sr][sc]=color;

            if(sc>=1)
            Helper(image,sr,sc-1,start,color);

            if(sr>=1)
            Helper(image,sr-1,sc,start,color);

            if(sr+1<image.length)
            Helper(image,sr+1,sc,start,color);

            if(sc+1<image[0].length)
            Helper(image,sr,sc+1,start,color);
        }
    }
}
