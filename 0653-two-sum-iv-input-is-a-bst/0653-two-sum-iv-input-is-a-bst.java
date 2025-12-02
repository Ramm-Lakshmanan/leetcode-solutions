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
    public TreeNode search(TreeNode root,int target,TreeNode found){
        if(root==null) return found;

        if(target>root.val){
            found= search(root.right,target,found);
        }
        else if(target<root.val){
            found= search(root.left,target,found);
        }
        else found=root;

        return found;
    }

    public boolean res(TreeNode root,TreeNode node,int k,boolean ans){
        if(node==null) return ans;
        TreeNode found=search(root,(k-node.val),null);
        if(found!=null && found!=node) ans=true;
        if(node.left!=null) ans=res(root,node.left,k,ans);
        if(node.right!=null) ans=res(root,node.right,k,ans);

        return ans;
    }
    public boolean findTarget(TreeNode root, int k) {
        return res(root,root,k,false);
    }
}