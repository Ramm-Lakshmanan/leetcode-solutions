import java.util.*;

class Solution {

    public int func(TreeNode root, Map<TreeNode, Integer> hm) {

        if (root == null) return 0;

        // If already calculated, return stored value
        if (hm.containsKey(root)) {
            return hm.get(root);
        }

        // Choice 1: Rob the current node
        int ch1 = root.val;

        if (root.left != null) {
            ch1 += func(root.left.left, hm);
            ch1 += func(root.left.right, hm);
        }

        if (root.right != null) {
            ch1 += func(root.right.left, hm);
            ch1 += func(root.right.right, hm);
        }

        // Choice 2: Don't rob the current node
        int ch2 = func(root.left, hm) + func(root.right, hm);

        int ans = Math.max(ch1, ch2);

        hm.put(root, ans);

        return ans;
    }

    public int rob(TreeNode root) {

        Map<TreeNode, Integer> hm = new TreeMap<>(
            (a, b) -> {
                if (a == b) return 0;

                return Integer.compare(
                    System.identityHashCode(a),
                    System.identityHashCode(b)
                );
            }
        );

        return func(root, hm);
    }
}