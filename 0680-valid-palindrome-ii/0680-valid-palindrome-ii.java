class Solution {
    public boolean validPalindrome(String s) {
       int left =0;
       int right=s.length()-1;
 
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
              return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1); // we skip one character by moving left or right                            
    
            }
            left++;
            right--; }
            return true; //already a palindrome      
   
    }
    public boolean isPalindrome(String s, int left, int right){
        while(left<right){
        if(s.charAt(left++)!=s.charAt(right--))// even after skipping one character, if the characters do not match, then it is not a palindrome
        return false;       
    } return true;
    }
    
}