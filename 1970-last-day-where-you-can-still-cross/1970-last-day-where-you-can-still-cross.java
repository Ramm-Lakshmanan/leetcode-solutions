class Solution {

    // DFS to check reachability to bottom
    public boolean dfs(int[][] mat, boolean[][] vis, int r, int c) {
        int R = mat.length, C = mat[0].length;

        if (r < 0 || c < 0 || r >= R || c >= C) return false;
        if (vis[r][c] || mat[r][c] == 1) return false;

        if (r == R - 1) return true;

        vis[r][c] = true;

        return dfs(mat, vis, r + 1, c) ||
               dfs(mat, vis, r - 1, c) ||
               dfs(mat, vis, r, c + 1) ||
               dfs(mat, vis, r, c - 1);
    }

    // Check if crossing is possible after flooding first `day` cells
    public boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] mat = new int[row][col];

        // Flood first `day + 1` cells
        for (int i = 0; i <= day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            mat[r][c] = 1;
        }

        // Try starting DFS from all top-row land cells
        for (int c = 0; c < col; c++) {
            if (mat[0][c] == 0) {
                boolean[][] vis = new boolean[row][col];
                if (dfs(mat, vis, 0, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int low = 0, high = row * col - 1;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canCross(row, col, cells, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans+1;
    }
}
