package com.liupjie.topic.array;

public class _0066_PlusOne {

    public static void main(String[] args) {
        int[] nums = {8,9,9};
        for (int i : plusOne(nums)) {
            System.out.println(i);
        }
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        // 创建一个长度为length+1的新数组，用来保存99+1的情况产生的结果
        // 并且将第一位初始化为1
        int[] arr = new int[length + 1];
        arr[0] = 1;
        // 从最后一位开始遍历，加1，如果结果超过9，则向前进1
        int i = length - 1;
        int plus = 1;
        while (i >= 0) {
            int ele = digits[i] + plus;
            if (ele > 9) {
                digits[i] = 0;
            } else {
                digits[i] = ele;
                plus = 0;
            }
            i--;
        }
        // 原始数组的第1位如果为0，则是99+1的情况，直接返回新数组arr，否则返回digits
        return digits[0] == 0 ? arr : digits;
    }

    public static int[] plusOneBetter(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
