class Solution {
    public String makeFancyString(String s) {
        int count=0;
        StringBuilder sb= new StringBuilder();
        char prev=s.charAt(0);
        for(char c: s.toCharArray()){
            if(prev==c){
                count++;
            }else{
                count=1;
                prev=c;
            }

            if(count<3){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}