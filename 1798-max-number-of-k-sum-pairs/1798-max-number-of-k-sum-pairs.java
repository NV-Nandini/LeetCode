class Solution {
    public int maxOperations(int[] nums, int k) {
        int left=0;
        int sum=0;
        int count=0;
        int right=nums.length-1;
        Arrays.sort(nums);
        while(left<right){
            sum=nums[left]+nums[right];
            if(sum==k){
                count++;
                left++;
                right--;
            }
            else if(sum>k){
                right--;
            }
            else
            left++;
        }
        return count;
    }
}