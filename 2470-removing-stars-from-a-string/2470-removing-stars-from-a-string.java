class Solution {
    public String removeStars(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        char[]ch=s.toCharArray();
        for(char c:ch){
            if(c!='*'){
                stack.push(c);
            }
            else if(c=='*'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
    for (char c : stack) {
        sb.append(c);
    }
    return sb.toString();
    }
}