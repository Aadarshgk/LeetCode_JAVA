import java.util.Arrays;
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int row=box.length,col=box[0].length;
        char[][] res= new char[col][row];

        for(char[] r: res){
            Arrays.fill(r,'.');
        }

        for(int i=0;i<row;i++){
            int count=0;
            for(int j=0;j<col;j++){
                if(box[i][j]=='#'){
                    count++;
                }else if(box[i][j]=='*'){
                    res[j][row-1-i]='*';
                    for(int k=j-1;count>0;k--){
                        res[k][row-i-1]='#';
                        count--;
                    }
                }
            }

            for(int k=col-1;count>0;k--){
                res[k][row-1-i]='#';
                count--;
            }
        }

        return res;
    }
}