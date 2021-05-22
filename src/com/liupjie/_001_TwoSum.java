package com.liupjie;

import java.util.HashMap;
import java.util.Map;

public class _001_TwoSum {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] solution = solution1(nums, target);
//        int[] solution = solution(nums, target);
        System.out.println(solution[0]);
        System.out.println(solution[1]);
    }


    private static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]), i};
            map.put(target - nums[i], i);
        }
        return null;
    }


    private static int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
