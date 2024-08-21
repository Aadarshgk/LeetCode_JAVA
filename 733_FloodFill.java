class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ogColor=image[sr][sc];
        if(ogColor!=color){
            floodFill(image,sr,sc,ogColor,color);
        }
        return image;
    }

    public void floodFill(int[][] image, int i,int j,int ogColor,int color){
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=ogColor) return;
        image[i][j]=color;
        floodFill(image,i-1,j,ogColor,color);
        floodFill(image,i+1,j,ogColor,color);
        floodFill(image,i,j-1,ogColor,color);
        floodFill(image,i,j+1,ogColor,color);
    }
}