/**
 * @author lite
 * @Description: 贪心算法 每步都跳最大值
 * nums[0] = n > 0 下一个可能到达的点就有n个
 * 分别看各个点的最大距离 有任一点能到达终点返回true
 * @date: 2020/9/6 12:31 下午
 * @since JDK 1.8
 */
public class CanJump {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 1, 0, 4};
        CanJump test = new CanJump();
        System.out.println(test.canJump(nums));
        nums = new int[] {2, 3, 1, 1, 4};
        System.out.println(test.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int longestDist = 0;
        for (int i = 0; i <= longestDist; i++) {
            longestDist = Math.max(longestDist, i + nums[i]);
            if (longestDist >= n - 1) {
                return true;
            }
        }
        return false;
    }
}
