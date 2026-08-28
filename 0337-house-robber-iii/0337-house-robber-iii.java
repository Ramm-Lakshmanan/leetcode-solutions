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
    public int func(TreeNode root,Map<TreeNode,Integer> hm){
        if(root==null) return 0;

        if(root.left==null && root.right==null) return root.val;

        if(hm.containsKey(root)) return hm.get(root);

        int ch1=root.val;

        if(root.right!=null) {
            ch1+=func(root.right.left,hm)+func(root.right.right,hm);
        }
        if(root.left!=null){
            ch1+=func(root.left.right,hm)+func(root.left.left,hm);
        }

        int ch2= func(root.left,hm)+func(root.right,hm);
        hm.put(root,Math.max(ch1,ch2));
        return Math.max(ch1,ch2);
    }
    public int rob(TreeNode root) {
        Map<TreeNode,Integer> hm=new HashMap<>();

        return func(root,hm);
    }
}