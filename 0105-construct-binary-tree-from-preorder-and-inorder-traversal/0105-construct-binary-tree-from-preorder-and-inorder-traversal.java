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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(inorder[i],i);
        }
        Deque<TreeNode> stk=new ArrayDeque<>();
        TreeNode root=new TreeNode(preorder[0],null,null);
        stk.offerLast(root);
        for(int i:preorder){
            if(i!=preorder[0]){
                TreeNode nn=new TreeNode(i,null,null);
                if(stk.isEmpty() || hm.get(stk.peekLast().val)>hm.get(i)){
                    if(!stk.isEmpty()){
                        stk.peekLast().left=nn;
                    }
                }
                else{
                    TreeNode temp=root;
                    while(!stk.isEmpty() && hm.get(stk.peekLast().val)<hm.get(i)){
                        temp=stk.pollLast();
                    }
                    temp.right=nn;
                }
                stk.offerLast(nn);
            }   
        }
        return root;
    }
}