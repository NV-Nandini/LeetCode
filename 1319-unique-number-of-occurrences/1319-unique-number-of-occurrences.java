class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int num :arr){
            if(!map.containsKey(num)){
                map.put(num,1);
            }
            map.put(num,map.get(num)+1);
        }
        Set<Integer>set=new HashSet<>(map.values());

        return(map.size()!=set.size()?false:true);

    }
}