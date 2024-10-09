class Solution {
    public int minAddToMakeValid(String s) {
        int count=0;
        int required=0;
        for(char c: s.toCharArray()){
            if(c=='('){
                count++;
            }else{
                count--;
            }

            if(count<0){
                required+=Math.abs(count);
                count=0;
            }
        }

        required+=count;
        return required;
    }
}