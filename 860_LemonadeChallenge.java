class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        for(int a: bills){
            if(a==5){
                five++;
            }else if(a==10){
                if(five==0) return false;
                five--;
                ten++;
            }else{
                if(five==0) return false;
                if(ten==0){
                    if(five<3) return false;
                    five-=3;
                }else{
                    ten--;
                    five--;
                }
            }
        }

        return true;
    }
}