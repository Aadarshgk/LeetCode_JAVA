class Solution {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character,int[]> map=new HashMap<>();
        int len=s.length();
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(!map.containsKey(s.charAt(i))){
                map.put(c,new int[]{i,i});
            }else{
                int[] ar=map.get(c);
                ar[1]=i;
                map.put(c,ar);
            }
        }

        int count = 0;
        for(Character c: map.keySet()){
            HashSet<Character> set= new HashSet<>();
            int[] ar=map.get(c);
            if(ar[0]==ar[1])continue;

            for(int i=ar[0]+1;i<ar[1];i++){
                set.add(s.charAt(i));
            }

            count += set.size();
        }

        return count;
    }
}