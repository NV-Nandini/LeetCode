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
    public int maxLevelSum(TreeNode root) {
        if (root == null) return root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int currentLevel = 1;

        while(!queue.isEmpty()){
           int levelSize = queue.size();
            int levelSum = 0;
            for(int i=0;i<levelSize;i++){
                TreeNode curr=queue.poll();
                levelSum+=curr.val; 
               if (curr.left != null) queue.offer(curr.left);
               if (curr.right != null) queue.offer(curr.right);

            }

            if (levelSum > maxSum) {
            maxSum = levelSum;
            maxLevel = currentLevel;
            }
            currentLevel++;
        }
        return  maxLevel;

    }

}