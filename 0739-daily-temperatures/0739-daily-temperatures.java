class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();  // will store indices

        for (int i = 0; i < n; i++) {
            // While current temp is higher than the one at the top of the stack,
            // resolve those “waiting” days
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int prev = stack.pop();
                res[prev] = i - prev;
            }
            // Push this day’s index to wait for its warmer future day
            stack.push(i);
        }
        // Any indices still in the stack have no warmer future day → remain 0
        return res;
    }
}
