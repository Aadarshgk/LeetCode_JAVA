import java.util.List;
import java.util.ArrayList;

//Boyer moore's voting algorithm
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res= new ArrayList<>();
        int ctr1=0,ctr2=0;
        int el1=0,el2=0;
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(ctr1==0 && nums[i]!=el2){
                ctr1++;
                el1=nums[i];
            }else if(ctr2==0 && nums[i]!=el1){
                ctr2++;
                el2=nums[i];
            }else if(el1==nums[i]){
                ctr1++;
            }else if(el2==nums[i]){
                ctr2++;
            }else{
                ctr1--;
                ctr2--;
            }
        }   
        int count1=0,count2=0;
        for(int i=0;i<len;i++){
            if(nums[i]==el1){
                count1++;
            }else if(nums[i]==el2){
                count2++;
            }
        }
        if(count1>len/3){
            res.add(el1);
        }
        if(count2>len/3){
            res.add(el2);
        }

        return res;
    }
}