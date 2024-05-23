import java.util.ArrayList;

class Solution {
    public String convert(String s, int numRows) {
        ArrayList<StringBuilder> ls=new ArrayList<>();
        int i=0,len=s.length();
        for(int j=0;j<numRows;j++){
            ls.add(new StringBuilder());
        }
        while(i<len){
            for(int j=0;j<numRows && i<len;j++,i++){
                ls.get(j).append(s.charAt(i));
            }

            for(int j=numRows-2;j>0 && i<len;j--,i++){
                ls.get(j).append(s.charAt(i));
            }
        }
        StringBuilder res= new StringBuilder();
        for(StringBuilder a: ls){
            res.append(a);
        }
        return res.toString();

    }
}