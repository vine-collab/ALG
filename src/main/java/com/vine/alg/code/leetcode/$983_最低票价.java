
public class $983_最低票价 {


    /**
     * https://leetcode.cn/problems/minimum-cost-for-tickets/description/
     */
    public static void main(String[] args) {
        $983_最低票价 z = new $983_最低票价();
    }

    public int mincostTickets(int[] days, int[] costs) {
        this.days = Arrays.stream(days).boxed().collect(Collectors.toSet());
        this.costs = costs;
        this.memo = new Integer[366];
        return dp(1);
    }

    Integer[] memo;
    Set<Integer> days;
    int[] costs;

    // 表示从第i天到 最后一天的花费
    int dp(int i) {

        if (i > 365) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }

        int res;
        // 有出行计划
        if (days.contains(i)) {
            res = Math.min(Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]), dp(i + 30) + costs[2]);
        }
        // 无出行计划
        else {
            res = dp(i + 1);
        }
        memo[i] = res;
        return res;


    }
}