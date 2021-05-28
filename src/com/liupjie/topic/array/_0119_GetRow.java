package com.liupjie.topic.array;

import java.util.Arrays;
import java.util.List;

public class _0119_GetRow {

    public static void main(String[] args) {
        List<Integer> generate = getRow1(5);
        System.out.println(generate);
    }

    public static List<Integer> getRow(int rowIndex) {
        Integer[] nums = null;
        for (int k = 0; k <= rowIndex; k++) {
            Integer[] lastNums = nums;
            nums = new Integer[k + 1];
            for (int j = 0; j < k + 1; j++) {
                if (j == 0 || j == k) {
                    nums[j] = 1;
                } else {
                    nums[j] = lastNums[j - 1] + lastNums[j];
                }
            }
        }
        return Arrays.asList(nums);
    }

    // 优化
    public static List<Integer> getRow1(int rowIndex) {
        Integer[] nums = new Integer[rowIndex + 1];
        for (int k = 0; k <= rowIndex; k++) {
            for (int j = k; j >= 0; j--) {
                if (j == 0 || j == k) {
                    nums[j] = 1;
                } else {
                    nums[j] = nums[j - 1] + nums[j];
                }
            }
        }
        return Arrays.asList(nums);
    }
}
