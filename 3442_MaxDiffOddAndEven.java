class Solution {
    public int maxDifference(String s) {
        char[] ar= s.toCharArray();
        Arrays.sort(ar);
        int oddMin=Integer.MAX_VALUE,oddMax=0,evenMax=0,evenMin=Integer.MAX_VALUE;
        int i=0,len=ar.length;
        while(i<len){
            int count=1;
            while(i<len-1 && ar[i]==ar[i+1]){
                count++;
                i++;
            }
            if(count%2==0){
                evenMin=Math.min(evenMin,count);
            }else{
                oddMax=Math.max(oddMax,count);
            }
            i++;
        }

        return oddMax-evenMin;
    }
}