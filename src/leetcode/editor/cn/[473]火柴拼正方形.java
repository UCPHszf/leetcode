package leetcode.editor.cn;//你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能
//折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。 
//
// 如果你能使这个正方形，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: matchsticks = [1,1,2,2,2]
//输出: true
//解释: 能拼成一个边长为2的正方形，每边两根火柴。
// 
//
// 示例 2: 
//
// 
//输入: matchsticks = [3,3,3,3,4]
//输出: false
//解释: 不能用所有火柴拼成一个正方形。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= matchsticks.length <= 15 
// 1 <= matchsticks[i] <= 10⁸ 
// 
//
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 441 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MakeSquare473 {
    int[] nums;
    boolean[] st;

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int m : matchsticks) sum += m;
        if (sum % 4 != 0) return false;
        nums = matchsticks;
        int average = sum / 4;
        st = new boolean[matchsticks.length];
        Arrays.sort(nums);
        return dfs(0, 0, average, 4);
    }

    public boolean dfs(int start, int cur, int sum, int k) {
        if (k == 0) return true;
        if (cur == sum) return dfs(0, 0, sum, k - 1);
        for (int i = start; i < nums.length; i++) {
            if (st[i]) continue;
            if (cur + nums[i] <= sum) {
                st[i] = true;
                if (dfs(i + 1, cur + nums[i], sum, k)) return true;
                st[i] = false;
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
            if (cur == 0 || cur + nums[i] == sum) return false;
        }
        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
