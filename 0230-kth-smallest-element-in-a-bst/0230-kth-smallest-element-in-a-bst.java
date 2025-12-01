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

    public int[] find(TreeNode root,int k,int cnt,int res){
        int data=root.val;

        if(root.left!=null){
            int[] ans=find(root.left,k,cnt,res);
            cnt=ans[1];
            res=ans[0];
        }
        cnt=cnt+1;
        if(cnt==k){
            return new int[]{data,cnt};
        }
        if(root.right!=null){
            int[] ans=find(root.right,k,cnt,res);
            cnt=ans[1];
            res=ans[0];
        }
        return new int[]{res,cnt};
    }
    public int kthSmallest(TreeNode root, int k) {
        return find(root,k,0,-1)[0];
    }
}