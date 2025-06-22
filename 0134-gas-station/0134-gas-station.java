class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0,totalCost=0;
        int tank = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];

            tank += gas[i] - cost[i];
            // If tank is negative, we cannot start from this or previous stations
            if (tank < 0) {
                start = i + 1;  // try starting from next station
                tank = 0;       // reset the tank
            }
        }
        return totalGas >= totalCost ? start : -1;
    }
}