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
    public int[] func(TreeNode root,int ans){
        if(root.left==null && root.right==null){
            return new int[]{0,ans};
        }
        int lh=-1,rh=-1;
        if(root.left!=null){
            int[] left=func(root.left,ans);
            lh=left[0]+1;
            if(left[1]>ans) ans=left[1];
        }
        if(root.right!=null){
            int[] right=func(root.right,ans);
            rh=right[0]+1;
            if(right[1]>ans) ans=right[1];
        }
        
        if(lh==-1) return new int[]{rh,Math.max(rh,ans)};
        else if(rh==-1) return new int[]{lh,Math.max(lh,ans)};
        else{
            ans=Math.max(ans,lh+rh);
            return new int[]{Math.max(lh,rh),ans};
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return func(root,0)[1];
    }
}