class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i=0,count=0,len=flowerbed.length;
        while(i<len){
            if(flowerbed[i]==0){
                if(i==0){
                    if(i==len-1 || flowerbed[i+1]==0){
                        count++;
                        i+=2;
                    }else{
                        i++;
                    }
                }else if(i<len-1){
                    if(flowerbed[i-1]==0 && flowerbed[i+1]==0){
                        count++;
                        i+=2;
                    }else{
                        i++;
                    }
                }else{
                    count++;
                    i++;
                }
            }else{
                i+=2;
            }
        }        
        return (count>=n)?true:false;
    }
}