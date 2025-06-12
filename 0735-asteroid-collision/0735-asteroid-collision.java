class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean alive = true;

            // Only possible collisions when 'ast' is moving left (negative)
            // and the top of the stack is a right‐mover (positive)
            while (alive && ast < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int top = stack.peek();
                
                if (top < -ast) {
                    // The right‐mover at 'top' is smaller, so it explodes
                    stack.pop();
                    // and we loop again to see if 'ast' hits the next one
                } 
                else if (top == -ast) {
                    // Same size: both explode
                    stack.pop();
                    alive = false;
                } 
                else {
                    // The incoming 'ast' is smaller, so it explodes
                    alive = false;
                }
            }

            // If 'ast' survived all collisions, push it onto the stack
            if (alive) {
                stack.push(ast);
            }
        }

        // Convert the stack into an array in the correct left‐to‐right order
        int n = stack.size();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
