class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb=new StringBuilder();
        int len1=s.length(), len2=part.length();
        int i=-1;
        for(int j=0;j<len1;j++){
            sb.append(s.charAt(j));
            i++;

            if(i>=len2-1 && part.charAt(len2-1)==sb.charAt(i)){
                boolean flag=true;
                for(int k=0;k<len2;k++){
                    if(sb.charAt(i-k)!=part.charAt(len2-k-1)){
                        flag=false;
                        break;
                    }
                }

                if(flag){
                    for(int k=0;k<len2;k++){
                        sb.deleteCharAt(i--);
                    }
                }
            }
        }

        return sb.toString();
    }
}