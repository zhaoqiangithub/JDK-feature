package com.rk.springboot_test.test;

public class Main {

  public int[] sortedSquares(int[] nums) {
    int[] results = new int[nums.length];

    int i = 0;
    int j = nums.length - 1;
    int index = nums.length - 1;
    // 双指针，从两边往中间滑动
    while (i <= j) {
      if (nums[i] * nums[i] > nums[j] * nums[j]) {
        results[index--] = nums[i] * nums[i];
        i++;
      } else {
        results[index--] = nums[j] * nums[j];
        j--;
      }
    }
    return results;
  }


  public static void main(String[] args) {
    int[] nums = new int[]{-11,-4,-1,0,3,10};
    int[] ints = new Main().sortedSquares(nums);
    for (int anInt : ints) {
      System.out.println(anInt);
    }

  }

}
