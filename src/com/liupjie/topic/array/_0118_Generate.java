package com.liupjie.topic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0118_Generate {

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        for (List<Integer> integers : generate) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows == 0)
            return ret;
        Integer[] nums = null;
        for (int k = 1; k <= numRows; k++) {
            Integer[] lastNums = nums;
            nums = new Integer[k];
            for (int j = 0; j < k; j++) {
                if (j == 0 || j == k - 1) {
                    nums[j] = 1;
                } else {
                    nums[j] = lastNums[j - 1] + lastNums[j];
                }
            }
            ret.add(new ArrayList<>(Arrays.asList(nums)));
        }
        return ret;
    }
}
