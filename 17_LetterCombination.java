import java.util.List;
import java.util.ArrayList;
class Solution {
    String[] letter={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        List<String> res= new ArrayList<>();
        combDigits(digits, res, new StringBuilder(), 0);
        return res;
    }

    public void combDigits(String digits, List<String> res,StringBuilder temp, int id){
        if(id==digits.length()){
            res.add(new String(temp.toString()));
            return;
        }
        for(int i=0;i<letter[digits.charAt(id)-'2'].length();i++){
            temp.append(letter[digits.charAt(id)-'2'].charAt(i));
            combDigits(digits,res,temp,id+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}