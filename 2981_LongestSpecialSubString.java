import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public int maximumLength(String s) {
        int len= s.length();
        if(len<3) return -1; 
        
        List<String> list= new ArrayList<>();

        for(int i=0;i<len;i++){
            int ind=i;

            while(ind<len && s.charAt(ind)==s.charAt(i)){
                list.add(s.substring(i,ind+1));
                ind++;
            }
        }

        Map<String,Integer> map=new HashMap<>();
        for(String str: list){
            map.put(str,map.getOrDefault(str,0)+1);
        }

        int maxLen=0;
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            String keyVal=entry.getKey();
            int count=entry.getValue();
            if(count>=3){
                maxLen=Math.max(maxLen,keyVal.length());
            }
        }

        return maxLen==0?-1:maxLen;

    }
}