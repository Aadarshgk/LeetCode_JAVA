class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len=s.length();
        int i=0,j=0;
        int size=len/k;
        size+=((len%k==0)?0:1);
        String[] ar=new String[size];
        while(i<len){
            int count=0;
            StringBuilder sb=new StringBuilder();
            for(count=0;i<len && count<k;count++,i++){
                sb.append(s.charAt(i));
            }

            while(count<k){
                sb.append(fill);
                count++;
            }
            ar[j++]=sb.toString();
        }

        return ar;
    }
}