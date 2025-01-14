class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len=A.length,count=0;
        int[] map= new int[len+1];
        
        int[] res= new int[len];

        for(int i=0;i<len;i++){
            int a= A[i];
            int b= B[i];

            if(a==b){
                count++;
            }else{
                if(map[a]<0){
                    count++;
                }
                map[a]++;
                
                if(map[b]>0){
                    count++;
                }
                map[b]--;
            }

            res[i]=count;
        }

        return res;
    }
}