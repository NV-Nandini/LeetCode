class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int alt;
        alt=0;
        int max=0;
        for(int g:gain){
            alt+=g;
           // System.out.println(alt);
            max=Math.max(max,alt);
        }
        return max;
    }
}