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
    public TreeNode create(TreeNode root,int val){
        if(root==null){
            TreeNode nn=new TreeNode(val,null,null);
            root=nn;
        }
        else if(val<root.val){
            root.left=create(root.left,val);
        }
        else{
            root.right=create(root.right,val);
        }
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=null;
        for(int i:preorder){
            root=create(root,i);
        }
        return root;
    }
}