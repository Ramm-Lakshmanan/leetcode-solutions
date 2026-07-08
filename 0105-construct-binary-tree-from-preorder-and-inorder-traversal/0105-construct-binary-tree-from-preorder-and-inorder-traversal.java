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
    int idx=0;

    public TreeNode func(int[] pre,Map<Integer,Integer>hm,int start,int end){
        if(start>end) return null;

        TreeNode node=new TreeNode(pre[idx]);

        int mid=hm.get(pre[idx]);
        idx++;

        node.left=func(pre,hm,start,mid-1);
        node.right=func(pre,hm,mid+1,end);

        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        Map<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<n;i++){
            hm.put(inorder[i],i);
        }

        return func(preorder,hm,0,n-1);        
    }
}