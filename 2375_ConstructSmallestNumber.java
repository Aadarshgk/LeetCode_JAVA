class Solution {
    StringBuilder sb;
    public String smallestNumber(String pattern) {
        sb=new StringBuilder();
        boolean[] freq=new boolean[pattern.length()+2];
        helper(pattern,0,freq);
        return sb.toString();
    }

    public boolean helper(String pattern, int pos,boolean[] freq){
        if(pos>=pattern.length()+1){
            return true;
        }

        if(pos==0){
            for(int i=1;i<=9;i++){
                sb.append(i);
                freq[i]=true;
                if(helper(pattern,pos+1,freq)) return true;
                sb.deleteCharAt(pos);
                freq[i]=false;
            }
        }
        int num=sb.charAt(pos-1)-'0';
        char val=pattern.charAt(pos-1);
        
        if(val=='I'){
            for(int i=num+1;i<=9;i++){
                if(!freq[i]){
                    sb.append(i);
                    freq[i]=true;
                    if(helper(pattern,pos+1,freq)) return true;
                    sb.deleteCharAt(pos);
                    freq[i]=false;
                }
            }
        }else{
            for(int i=1;i<num;i++){
                if(!freq[i]){
                    sb.append(i);
                    freq[i]=true;
                    if(helper(pattern,pos+1,freq)) return true;
                    sb.deleteCharAt(pos);
                    freq[i]=false;
                }
            }
        }
        return false;
    }
}