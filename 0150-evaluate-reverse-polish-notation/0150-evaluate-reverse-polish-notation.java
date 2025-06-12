class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String tok : tokens) {
            // If token is an operator
            if (tok.equals("+") || tok.equals("-") ||
                tok.equals("*") || tok.equals("/")) {

                // Pop right then left
                int right = stack.pop();
                int left  = stack.pop();

                int res;
                switch (tok) {
                    case "+": res = left + right; break;
                    case "-": res = left - right; break;
                    case "*": res = left * right; break;
                    default:  // "/"
                        // truncate toward zero
                        res = left / right;
                        break;
                }
                stack.push(res);

            } else {
                // It's a number: parse and push
                stack.push(Integer.parseInt(tok));
            }
        }

        // The final result is the only element left
        return stack.pop();
    }
}
