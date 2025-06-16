class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustScores=new int[n+1];

        for(int[]t:trust){
            int a=t[0];
            int b=t[1];

            trustScores[a]--;
            trustScores[b]++;
        }

        for(int i=1;i<=n;i++){
            if(trustScores[i]==n-1){
                return i;
            }
        }
        return -1;



    }
}