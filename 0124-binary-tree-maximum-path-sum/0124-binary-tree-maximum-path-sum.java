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
    int ans=Integer.MIN_VALUE;
    int check(TreeNode root){
        if(root==null)return 0;
        int lhigh=check(root.left);
        int rhigh=check(root.right);
        int max=root.val;
        if(lhigh>0)max+=lhigh;
        if(rhigh>0)max+=rhigh;
        ans=Math.max(ans,max);
        return Math.max(0,Math.max(lhigh,rhigh))+root.val;
    }
    public int maxPathSum(TreeNode root) {
        check(root);
        return ans;
    }
}