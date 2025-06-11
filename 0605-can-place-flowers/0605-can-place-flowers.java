class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
       int num=flowerbed.length;
       int prev;
       int next;
       int count=0;
       for(int i=0;i<num;i++){
        next = (i == num - 1) ? 0 : flowerbed[i + 1];
        if(i==0){prev=0;}else prev=flowerbed[i-1];
        if(flowerbed[i]==0 && prev!=1 && next!=1 ){
            count++;  
            flowerbed[i]=1;     
        }
       }
       return (count>=n);
    }
}