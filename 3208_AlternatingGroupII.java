class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int len=colors.length,count=0;
        int[] temp=new int[len];
        for(int i=1;i<len;i++){
            if(colors[i]!=colors[i-1]){
                temp[i]=temp[i-1]+1;
            }else{
                temp[i]=0;
            }
        }

        if(colors[len-1]!=colors[0]){
            temp[0]=temp[len-1]+1;
        }else{
            temp[0]=0;
        }

        for(int i=1;i<k;i++){
            if(colors[i]!=colors[i-1]){
                temp[i]=temp[i-1]+1;
            }else{
                temp[i]=0;
            }
        }

        for(int n:temp){
            if(n>=k-1){
                count++;
            }
        }

        return count;

    }
}