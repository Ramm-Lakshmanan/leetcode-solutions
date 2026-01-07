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
    public long sum(TreeNode root){
        if(root==null) return 0L;
        return (long)root.val+sum(root.left)+sum(root.right);
    }
    public long[] ans(TreeNode root,long tot,long max){
        long sum=0L;
        if(root.left!=null){
            long[] req=ans(root.left,tot,max);
            sum+=req[1];
            max=Math.max(max,req[0]);
        }
        if(root.right!=null){
            long[] req=ans(root.right,tot,max);
            sum+=req[1];
            max=Math.max(max,req[0]);
        }
        sum+=root.val;
        max=Math.max((sum)*(tot-sum),max);

        return new long[]{max,sum};
    }
    public int maxProduct(TreeNode root) {
        long tot=sum(root);
        long res=ans(root,tot,0)[0];
        long mod=1000000007;
        return (int)(res%mod);
    }
}