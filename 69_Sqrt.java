class Solution {
    public int mySqrt(int x) {
        int i=1,j=x,mid=x/2;
        if(x==0||x==1){
            return x;
        }
        while(i<=j){
            mid= i+(j-i)/2;
            if(mid<=x/mid && (mid+1)>x/(mid+1)){
                return mid;
            }else if(mid>x/mid){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }      
        return mid;
    }
}