package com.liupjie;

public class _066_PlusOne {

    public static void main(String[] args) {
        int[] nums = {8,9,9};
        for (int i : plusOne(nums)) {
            System.out.println(i);
        }
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        int[] arr = new int[length + 1];
        arr[0] = 1;
        int i = length - 1;
        int plus = 1;
        while (i >= 0) {
            int ele = digits[i] + plus;
            if (ele > 9) {
                digits[i] = 0;
                arr[i + 1] = 0;
            } else {
                digits[i] = ele;
                plus = 0;
            }
            i--;
        }
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
