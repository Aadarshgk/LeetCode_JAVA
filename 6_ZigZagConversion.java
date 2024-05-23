class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int len=s.length(),count=2*(numRows-1),i,j,k;
        StringBuilder res= new StringBuilder();
        for(i=0;i<numRows;i++){
            j=i;
            k=count-2*i;
            while(j<len){
                res.append(s.charAt(j));
                if(j+k<len && i!=0 && i!=numRows-1){
                    res.append(s.charAt(j+k));
                }
                j+=count;
            }
        }
        return res.toString();
    }
}


// import java.util.ArrayList;

// class Solution {
//     public String convert(String s, int numRows) {
//         ArrayList<StringBuilder> ls=new ArrayList<>();
//         int i=0,len=s.length();
//         for(int j=0;j<numRows;j++){
//             ls.add(new StringBuilder());
//         }
//         while(i<len){
//             for(int j=0;j<numRows && i<len;j++,i++){
//                 ls.get(j).append(s.charAt(i));
//             }

//             for(int j=numRows-2;j>0 && i<len;j--,i++){
//                 ls.get(j).append(s.charAt(i));
//             }
//         }
//         StringBuilder res= new StringBuilder();
//         for(StringBuilder a: ls){
//             res.append(a);
//         }
//         return res.toString();

//     }
// }