import java.util.HashSet;
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char a= board[i][j];
                if(a=='.') continue;
                else if(!rowSet.contains(a) && a>='0' && a<='9'){
                    rowSet.add(a);
                }else{
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            HashSet<Character> colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char b= board[j][i];
                if(b=='.') continue;
                else if(!colSet.contains(b) && b>='0' && b<='9'){
                    colSet.add(b);
                }else{
                    return false;
                }
            }
        }

        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                HashSet<Character> boxSet= new HashSet<>();
                for(int m=0;m<3;m++){
                    for(int n=0;n<3;n++){
                        char a=board[i+m][j+n];
                        if(a=='.') continue;
                        else if(!boxSet.contains(a) && a>='0' && a<='9'){
                            boxSet.add(a);
                        }else{
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}