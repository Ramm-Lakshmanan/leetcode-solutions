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
    public int func(TreeNode root,StringBuilder sb){
        if(root.left==null && root.right==null){
            sb.append(root.val);
            return Integer.parseInt(sb.toString(),2);
        }
        sb.append(root.val);
        int sum=0;
        if(root.left!=null){
            sum+=func(root.left,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(root.right!=null){
            sum+=func(root.right,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        return sum;
    }
    public int sumRootToLeaf(TreeNode root) {
        return func(root,new StringBuilder());
    }
}