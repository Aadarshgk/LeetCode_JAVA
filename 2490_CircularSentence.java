class Solution {
    public boolean isCircularSentence(String sentence) {
        char prev=Character.MIN_VALUE;
        String[] ar= sentence.split(" ");
        for(String str: ar){
            if(prev!=Character.MIN_VALUE && str.charAt(0)!=prev){
                return false;
            }
            prev=str.charAt(str.length()-1);
        }

        if(prev==ar[0].charAt(0)) return true;
        return false;
    }
}