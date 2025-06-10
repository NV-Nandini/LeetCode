class Solution {
    public void moveZeroes(int[] nums) {
        int p=0,z=0;
        int n=nums.length;
        for(int num:nums){
            if(num!=0){
                nums[p++]=num;
            }
            else z++;
        }
        for(int i=n-z;i<n;i++){
            nums[i]=0;
        }

    }
}