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
    long max=Long.MIN_VALUE;

    public long func(TreeNode root){
        if(root==null) return 0;

        Long cur=(long)root.val;
        long left=func(root.left);
        long right=func(root.right);

        max=Math.max(max,cur+left+right);

        cur=Math.max(cur,Math.max(cur+left,cur+right));

        max=Math.max(max,cur);
        
        return cur;
    }

    public int maxPathSum(TreeNode root) {
        long summa=func(root);
        return (int)max;
    }
}