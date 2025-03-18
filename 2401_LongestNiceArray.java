//Brute force
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int[] ar = new int[32];
        int i = 0, j = 0, len = nums.length, max = 1;

        for (i = 0; i < len; i++) {
            int num = nums[i];

            for (int k = 0; k < 32; k++) {
                if ((num & (1 << k)) > 0) {
                    ar[k]++;
                }
            }

            boolean flag = false;
            for(int k=0; k<32; k++){
                if(ar[k] > 1){
                    flag = true;
                    break;
                }
            }

            if (flag) {
                max = Math.max(max, i - j);
                while (flag) {
                    num = nums[j++];
                    for (int k = 0; k < 32; k++) {
                        if ((num & (1 << k)) > 0) {
                            ar[k]--;
                        }
                    }

                    flag = false;
                    for(int k=0; k<32; k++){
                        if(ar[k] > 1){
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }
        max = Math.max(max, i - j); 
        return max;
    }
}