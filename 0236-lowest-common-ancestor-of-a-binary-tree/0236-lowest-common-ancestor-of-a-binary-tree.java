class pair {
    boolean f1, f2;
    TreeNode node;

    public pair(TreeNode node, boolean f1, boolean f2) {
        this.node = node;
        this.f1 = f1;
        this.f2 = f2;
    }
}

class Solution {
    public pair lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return new pair(null, false, false);

        pair left = lca(root.left, p, q);
        // If left subtree already found LCA, return immediately
        if (left.node != null && left.f1 && left.f2) return left;

        pair right = lca(root.right, p, q);
        // If right subtree already found LCA, return immediately
        if (right.node != null && right.f1 && right.f2) return right;

        boolean f1 = left.f1 || right.f1 || (root == p);
        boolean f2 = left.f2 || right.f2 || (root == q);

        TreeNode lcaNode = (f1 && f2) ? root : null;

        return new pair(lcaNode, f1, f2);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q).node;
    }
}
