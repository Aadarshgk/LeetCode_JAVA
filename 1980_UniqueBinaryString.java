import java.util.HashSet;
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set=new HashSet<>();
        int len=nums.length;
        for(String n: nums){
            set.add(n);
        }

        return backtrack(new StringBuilder(),0,len,set);
    }

    public String backtrack(StringBuilder sb,int pos,int len,HashSet<String> set){
        if(pos==len){
            if(!set.contains(sb.toString())){
                return sb.toString();
            }else{
                return "";
            }
        }

        for(int i=0;i<=1;i++){
            sb.append(0);
            String str=backtrack(sb,pos+1,len,set);
            if(str.length()==len) return str;
            sb.deleteCharAt(pos);
        }

        return "";
    }
}

//Diagonal Method
// class Solution {
//     public String findDifferentBinaryString(String[] nums) {
//         int len=nums.length;
//         StringBuilder sb=new StringBuilder();

//         for(int i=0;i<len;i++){
//             sb.append(nums[i].charAt(i)=='0' ? '1' : '0');
//         }

//         return sb.toString();
//     }
// }