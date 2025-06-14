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
    public boolean isValidBST(TreeNode root) {
        return  isValid(root,null,null);
        
    }

    private boolean isValid(TreeNode node, Integer min,Integer max){
if(node==null) return true;

         // If node.val must be strictly greater than min (if min != null)
        if (min != null && node.val <= min) return false;
        // If node.val must be strictly less than max (if max != null)
        if (max != null && node.val >= max) return false;

        // Check left subtree: max updated to node.val
        // Check right subtree: min updated to node.val
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }
}