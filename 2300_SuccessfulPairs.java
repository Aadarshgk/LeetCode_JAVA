import java.util.Arrays;
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int spellLen=spells.length;
        int potionLen=potions.length;

        Arrays.sort(potions);

        int[] ans= new int[spellLen];
        long maxPotion= potions[potionLen-1];
        long minPotion= potions[0];

        for(int i=0;i<spellLen;i++){
            long  num=spells[i];
            if(num*maxPotion < success){
                ans[i]=0;
                continue;
            }
            
            if(num*minPotion > success){
                ans[i]=potionLen;
                continue;
            }


            int l=0,r=potionLen-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if((long)(num*potions[mid]) < success){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }

            int count= potionLen-l;
            ans[i]=count;
        }

        return ans;
    }
}