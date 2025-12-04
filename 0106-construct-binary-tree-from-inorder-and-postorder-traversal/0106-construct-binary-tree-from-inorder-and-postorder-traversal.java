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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=postorder.length;
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(inorder[i],i);
        }
        Deque<TreeNode> stk=new ArrayDeque<>();
        TreeNode root=new TreeNode(postorder[n-1],null,null);
        stk.offerLast(root);
        for(int i=n-2;i>=0;i--){
            TreeNode nn=new TreeNode(postorder[i]);
            if(stk.isEmpty() || hm.get(stk.peekLast().val)<hm.get(postorder[i])){
                stk.peekLast().right=nn;
            }
            else{
                TreeNode temp=root;
                while(!stk.isEmpty() && hm.get(stk.peekLast().val)>hm.get(postorder[i])){
                    temp=stk.pollLast();
                }
                temp.left=nn;
            }
            stk.offerLast(nn);
        }
        return root;
    }
}