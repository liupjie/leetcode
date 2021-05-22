package com.liupjie;

public class _026_RemoveDuplicate {

    public static void main(String[] args) {
        int[] nums = {0,1,1};
        int newLength = removeDuplicates(nums);
        System.out.println(newLength);
        System.out.println("=============");
        for (int i = 0; i < nums.length; i++) {
            if (i >= newLength)
                break;
            int num = nums[i];
            System.out.println(num);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        // 数组为空，新数组长度为0
        if (length == 0)
            return 0;
        // 取第一个元素作为第一次比较的参照物
        int lastV = nums[0];
        // 取最后一个元素作为跳出循环的参照物
        int maxV = nums[length - 1];
        // 记录新数组长度，原始长度为1
        int ret = 1;
        // 从第2个元素开始遍历比较
        for (int i = 1; i < nums.length; i++) {
            // 如果元素不同，则将上一个元素设置为当前元素，与后面的元素比较
            // 由于是有序数组，因此相同的元素必然相邻
            // 新数组的长度增加1
            if (lastV != nums[i]) {
                lastV = nums[i];
                ret++;
            } else {
                // 如果元素相同，则将数组从当前位置开始的所有元素向前移动一个位置
                // 移动后指针i不移动，继续比较当前位置上的数与lastV是否重复
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                i--;
            }
            // 如果当前值与数组的最大值相等，则跳出循环，避免死循环
            if (nums[i] == maxV)
                break;
        }
        return ret;
    }

}
