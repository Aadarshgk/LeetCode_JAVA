class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res=0;
        for(int i=low;i<=high;i++){
            if(i<10 || (i>99 && i<1000)) continue;
            if(helper(i)) {
                res++;
            }   
        }
        return res;
    }

    public boolean helper(int num){
        String s=Integer.toString(num);
        int len=s.length(),left=0,right=0;;
        for(int i=0;i<len/2;i++){
            left+=s.charAt(i)-'0';
            right+=s.charAt(len-1-i)-'0';
        }

        return left==right;
    }
}