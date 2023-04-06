package meituan2;

import java.util.Arrays;

import java.util.Scanner;
// 简单的相邻绝对值

public class two {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0;
		N = sc.nextInt();
		int[] nums = new int[N];
		for (int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		int res = 0;
		for (int i=1; i<nums.length; i++) {
			res += Math.abs(nums[i]-nums[i-1]);
		}
		System.out.println(res);
	}
}

