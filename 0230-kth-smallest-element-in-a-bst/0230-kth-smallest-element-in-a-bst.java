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
    public int[] func(TreeNode root,int k){
        
        if(root.left!=null){
            int[] res=func(root.left,k);
            if(res[0]==0) return res;
            k=res[0];
        }
        k--;
        if(k==0) return new int[]{k,root.val};

        if(root.right!=null){
            int[] res=func(root.right,k);
            if(res[0]==0) return res;
            k=res[0];
        }
        return new int[]{k,-1};

    }
    public int kthSmallest(TreeNode root, int k) {
        return func(root,k)[1];
    }
}