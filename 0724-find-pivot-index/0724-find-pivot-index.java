class Solution {
    public int pivotIndex(int[] nums) {
        int prev=0;      
        int pivot;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        sum=sum+nums[i];
        int post=sum;
        for(int i=0;i<nums.length;i++){
            post=sum-prev-nums[i];
            if(prev==post) return i;
            prev=prev+nums[i];

        }
        return -1;
    }
}