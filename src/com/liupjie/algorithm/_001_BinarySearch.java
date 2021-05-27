package com.liupjie.algorithm;

public class _001_BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4, 6, 7, 8, 9};
        int target = 10;
        System.out.println(rightBound(nums, target));
    }

    /**
     * 普通二分查找
     */
    public static int binarySearch1(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) return -1;
        int left = 0, right = length;
        // 查找区间为[left, right)
        // 这里用<，while退出条件为left=right，此时查找区间为[right, right)，区间为空，不会漏数据
        while (left < right) {
            //为避免溢出
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) return -1;
        int left = 0, right = length - 1;
        // 查找区间为[left, right]
        // 这里用<=，while退出条件为left=right + 1，此时查找区间为[right + 1, right]，区间为空，不会漏数据
        // 若这里用<，while退出条件为left=right，此时查找区间为[right, right]，区间不为空，会漏掉数据
        while (left <= right) {
            //为避免溢出
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 寻找最左边界
     */
    public static int leftBound(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) return -1;
        int left = 0, right = length - 1;
        while (left <= right) {
            //为避免溢出
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // while退出条件是left = right + 1
        return left;
    }

    /**
     * 寻找最右边界
     */
    public static int rightBound(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) return -1;
        int left = 0, right = length - 1;
        while (left <= right) {
            //为避免溢出
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // while退出条件是left = right + 1
        return right;
    }

}
