class Solution {
    public int[] rearrangeArray(int[] nums) {
        int [] res = new int [nums.length];
          int i=0;
          int j=1;

          for(int val:nums){
            if(val>0){              
               res[i] = val;
               i = i + 2;
            }
            else{       
                res[j] = val;
                j = j + 2;
            }
          }
           return res;
    }
}