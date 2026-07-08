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
    public TreeNode func(TreeNode root,int val,Map<Integer,Integer> hm){
        if(root==null){
            root=new TreeNode(val,null,null);
        }

        else if(hm.get(val)<hm.get(root.val)){
            root.left=func(root.left,val,hm);
        }

        else{
            root.right=func(root.right,val,hm);
        }

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        Map<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<n;i++){
            hm.put(inorder[i],i);
        }

        TreeNode root=func(null,preorder[0],hm);

        for(int i=1;i<n;i++){
            root=func(root,preorder[i],hm);
        }

        return root;
    }
}