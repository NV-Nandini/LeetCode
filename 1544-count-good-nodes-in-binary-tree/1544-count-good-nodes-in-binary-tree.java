/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

        private int dfs(TreeNode root, int max){
            if (root == null) return 0;
             int good = 0;
        if (root.val >= max) {
            good = 1;
        }

        max = Math.max(max, root.val);
        good+=dfs(root.left,max);
        good+=dfs(root.right,max);

        return good;
       
    }
}