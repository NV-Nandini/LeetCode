import java.util.Collections;
class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
         int left=0;
         int right= n-1;
         int maxArea=0;
         while(left< right){
            maxArea=Math.max(maxArea,( Math.min(height[left],height[right])*(right-left)));
 
        if(height[left]<height[right])//moving the shorter line inward
            
        {
            left++;
        }
        else
        right--;
    
    }
        return maxArea;
    }
}
