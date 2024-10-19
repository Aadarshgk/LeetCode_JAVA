class Solution {
    public int compress(char[] chars) {
        int len=chars.length;
        int i=0,j=0;
        while(j<len){
            char c= chars[j];
            int count=0;
            while(j<len && chars[j]==c){
                count++;
                j++;
            }

            chars[i++]=c;
            if(count>1){
                String str= String.valueOf(count);
                for(char a: str.toCharArray()){
                    chars[i++]=a;
                }
            }
        }

        return i;
    }
}