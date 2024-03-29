package leetcode.editor.cn;//给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以
//穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。 
//
// 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 
//10⁹ + 7 取余 后的结果。 
//
// 
//
// 示例 1： 
// 
// 
//输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
//输出：6
// 
//
// 示例 2： 
// 
// 
//输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 50 
// 0 <= maxMove <= 50 
// 0 <= startRow < m 
// 0 <= startColumn < n 
// 
//
// Related Topics 动态规划 👍 260 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class OutBoundaryPath576 {
    int[][][] dp;
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    int MOD = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) return 0;
        dp = new int[m][n][maxMove + 1];
        for (int i = 0; i < n; i++) {
            dp[0][i][1]++;
            dp[m - 1][i][1]++;
        }

        for (int i = 0; i < m; i++) {
            dp[i][0][1]++;
            dp[i][n - 1][1]++;
        }

        for (int k = 1; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int u = 0; u < 4; u++) {
                        int a = i + dx[u], b = j + dy[u];
                        if (a >= 0 && a < m && b >= 0 && b < n) {
                            dp[i][j][k] = (dp[i][j][k] + dp[a][b][k - 1]) % MOD;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int k = 1; k <= maxMove; k++) {
            res = (res + dp[startRow][startColumn][k]) % MOD;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
