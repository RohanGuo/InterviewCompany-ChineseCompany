package meituan2;

import java.util.Scanner;
import java.util.Stack;

// 计算器
// 第二行N个数字，第四行是改动的运算符，求结果


public class one {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0, M = 0;
		N = sc.nextInt();
		int[] nums = new int[N];
		for (int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		M = sc.nextInt();
		int k = 0;
		String sign = "";
		double[] res = new double[M];
		for (int i=0; i<M; i++) {
			k = sc.nextInt();
			sign = sc.next();
			res[i] = compute(nums, k, sign);
			if (i == M-1){
		      System.out.printf("%.1f", res[i]);
		    } else {
		      System.out.printf("%.1f ", res[i]);
		    }
		}
	}
	public static double compute(int[] nums, int k, String sign) {
		Stack<Double> stack = new Stack<>();
		for (int i=0; i<nums.length; i++) {
			if (i == k) {
				if (sign.charAt(0) == '+') {
					stack.push((double) nums[i]);
				} else if (sign.charAt(0) == '-') {
					stack.push((double) -nums[i]);
				} else if (sign.charAt(0) == '*') {
					stack.push(stack.pop()*nums[i]);
				} else if (sign.charAt(0) == '/') {
					stack.push(stack.pop()/nums[i]);
				}
			} else {
				stack.push((double) nums[i]);
			}
		}
		double res = 0;
		// System.out.println(stack);
		while (!stack.isEmpty()) {
			res += stack.pop();
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
/*
3
1 2 3
1
1 *

5 
1 2 4 2 5
3
1 - 2 * 4 /

 * */
