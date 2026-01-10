class pair{
    int cnt;
    TreeNode node;
    public pair(TreeNode node,int cnt){
        this.node=node;
        this.cnt=cnt;
    }
}
class Solution {
    public int height(TreeNode root){
        if(root==null) return -1;
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }

    public int func1(TreeNode root,int max_h,int curr_h){
        if(root==null) return 0;
        if(root.left==null && root.right==null && curr_h==max_h) return 1;
        if(root.left==null && root.right==null) return 0;

        return func1(root.left,max_h,curr_h+1)+func1(root.right,max_h,curr_h+1);
    }

    public pair func2(TreeNode root,int max_h,int req,int curr_h){
        int cnt=0;
        if(root.left==null && root.right==null && curr_h==max_h){
            cnt++;
            if(cnt==req) return new pair(root,cnt);
            else return new pair(null,cnt);
        }

        TreeNode ans=null;

        if(root.left!=null){
            pair summa=func2(root.left,max_h,req,curr_h+1);
            cnt+=summa.cnt;
            if(ans==null) ans=summa.node;
        }

        if(root.right!=null){
            pair summa=func2(root.right,max_h,req,curr_h+1);
            cnt+=summa.cnt;
            if(ans==null) ans=summa.node;
        }
        
        if(cnt==req){
            if(ans==null)  return new pair(root,cnt);
            else return new pair(ans,cnt);
        }
        else return new pair(null,cnt);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int h= height(root);
        int cnt=func1(root,h,0);

        return func2(root,h,cnt,0).node;
    }
}