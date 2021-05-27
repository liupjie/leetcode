package com.liupjie.topic.array;

public class _0035_SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11, 13};
        int target = 8;
        System.out.println(searchInsertOfficial(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0)
            return 0;
        // 边界判断
        if (nums[0] > target)
            return 0;
        if (nums[length - 1] < target)
            return length;
        // 二分查找
        return binarySearch(0, length - 1, nums, target);
    }

    public static int binarySearch(int start, int end, int[] nums, int target) {
        // 获取中间下标
        int mid = (end + start) / 2;
        // 比较中间元素与target是否相等
        if (nums[mid] == target)
            return mid;
        // 判断查找的下标是否相邻，此时小下标nums[start==mid] != target，因此大下标必然满足nums[end] >= target
        if (end - start == 1) {
            return end;
        } else {
            return nums[mid] > target ? binarySearch(0, mid, nums, target) : binarySearch(mid, end, nums, target);
        }
    }


    public static int searchInsertOfficial(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
