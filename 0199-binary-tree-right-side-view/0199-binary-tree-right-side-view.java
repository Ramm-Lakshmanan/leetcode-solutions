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
    public List<Integer> rightSideView(TreeNode root) {
        int row=0;
        List<Integer> ans=new ArrayList<>();
        Deque<TreeNode> que=new ArrayDeque<>();
        if(root==null) return ans;
        que.offerLast(root);
        int cnt=0,req=1;
        while(!que.isEmpty()){
            TreeNode temp=que.peekFirst();

            if(temp.left!=null) que.offerLast(temp.left);
            if(temp.right!=null) que.offerLast(temp.right);

            cnt++;
            if(row>=ans.size()) ans.add(temp.val);
            else ans.set(row,temp.val);
            que.pollFirst();
            if(cnt==req){
                row++;
                cnt=0;
                req=que.size();
            }
        }
        return ans;
    }
}