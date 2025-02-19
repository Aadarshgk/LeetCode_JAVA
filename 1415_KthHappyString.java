class Solution {
    int count = 0;
    StringBuilder sb=new StringBuilder();
    public String getHappyString(int n, int k) {
        return backtrack(0,n,k);
    }

    public String backtrack(int pos, int n,int k){
        if(pos==n){
            count++;
            if(count==k){
                return sb.toString();
            }else{
                return "";
            }
        }
        
        for(int i=0;i<3;i++){
            if(pos!=0 && sb.charAt(pos-1)-'a'==i){
                continue;
            }
            sb.append((char)('a'+i));
            String str=backtrack(pos+1,n,k);
            if(str.length()>0) return str;
            sb.deleteCharAt(pos);
        }
        return "";
    }
}