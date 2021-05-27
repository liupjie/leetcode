package com.liupjie.topic.array;

public class _0053_MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArrayOfficial(nums));
    }

    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        // 当数组长度为1时，最大值就是第一个值
        if (length == 1)
            return nums[0];
        // 最大值，默认设置为第一个值
        int maxV = nums[0];
        // 双层循环，外层循环控制子数组的起始位置，内层循环控制子数组的结束位置
        // 每次获取到值都与当前最大值比较，并更新最大值
        // 时间复杂度O(n)，空间复杂度O(1)
        for (int i = 0; i < length; i++) {
            if (nums[i] > maxV)
                maxV = nums[i];
            int total = nums[i];
            for (int j = i + 1; j < length; j++) {
                total += nums[j];
                if (total > maxV)
                    maxV = total;
            }
        }
        return maxV;
    }

    /**
     * 动态规划
     * 最大子数组的确定：nums[i]是单独成为最大子数组还是加入前方的子数组，取决于nums[i]与f(i-1)+nums[i]
     */
    public static int maxSubArrayOfficial(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


}
