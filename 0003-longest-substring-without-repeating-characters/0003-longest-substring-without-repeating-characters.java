class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer>map=new HashMap<>();
        int left=0;
        int right=0;
        int max=0;
        for( right=0; right<=s.length()-1;right++){
            char c=s.charAt(right);
            if(map.containsKey(c) && map.get(c)>=left){
                left = map.get(c) + 1;
                
            }
            map.put(c, right);
            max = Math.max(max, right - left + 1);
        }
        System.out.println(map);
        return max;
    }
}