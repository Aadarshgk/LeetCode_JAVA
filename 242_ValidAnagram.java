import java.util.Arrays;
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        
        char[] a=s.toCharArray();
        Arrays.sort(a);
        char[] b=t.toCharArray();
        Arrays.sort(b);

        return Arrays.equals(a,b);
    }
}


// class Solution {
//     public boolean isAnagram(String s, String t) {
//         int[] s1= new int[26];
//         int[] t1=new int[26];
//         int len1= s.length(),len2=t.length(),i=0;
//         if(len1!=len2) return false;

//         while(i<len1){
//             s1[s.charAt(i)-'a']++;
//             t1[t.charAt(i)-'a']++;
//             i++;
//         }
//         i=0;
//         while(i<26){
//             System.out.println(s1[i] + " " + t1[i]);
//             if(s1[i]!=t1[i]){
//                 return false;
//             }
//             i++;
//         }
//         return true;

//     }
// }

