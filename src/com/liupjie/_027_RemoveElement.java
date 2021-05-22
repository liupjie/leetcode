package com.liupjie;

public class _027_RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0};
        int val = 0;
        int newLength = removeElement(nums, val);
        System.out.println(newLength);
        System.out.println("=============");
        for (int i = 0; i < newLength; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        // 数组为空，新数组长度为0
        if (nums.length == 0)
            return 0;
        // 新数组长度
        int newLength = 0;
        // 记录操作次数，用于跳出循环
        int opTimes = 0;
        for (int i = 0; i < nums.length; i++) {
            // 操作数加1
            opTimes++;
            if (nums[i] != val) {
                // 当前元素不等于给定值，则新数组长度加1
                newLength++;
            } else {
                // 当前元素等于给定值，则删除当前值，并将数组从当前位置开始的所有值向前移动一个位置
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                // 指针位置不移动，继续比较
                i--;
            }
            // 操作次数大于等于数组长度时，跳出循环，操作结束
            if (opTimes >= nums.length)
                break;
        }
        return newLength;
    }
}
