class Solution {
    int[] prefix;
    public int[] decrypt(int[] code, int k) {
        int len=code.length;
        prefix=new int[2*len];
        prefix[0]=code[0];
        for(int i=1;i<2*len;i++){
            prefix[i]=prefix[i-1]+code[i%len];
        }      
        if(k==0){
            int[] res= new int[len];
            Arrays.fill(res,0);
            return res;
        }  

        return helper(code,k);


    }

    public int[] helper(int[] code,int k){
        int len=code.length;
        int[] res=new int[len];
        if(k>0){
            for(int i=0;i<len;i++){
                res[i]=prefix[i+k]-prefix[i];
            }
        }else{
            k=-k;
            for(int i=len;i<2*len;i++){
                res[i-len]=prefix[i-1]-prefix[i-k-1];
            }
        }


        return res;
    }
}