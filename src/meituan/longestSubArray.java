package meituan;

import java.util.Scanner;

/*
给定一个数组，包含各种数字，每个数字代表一个颜色
同时给定一个数字，代表最多几个颜色，问最长的子串

Input: 
8 3
1 2 3 2 1 4 5 1

Output: 5
*/

public class longestSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        int[] nums = new int[N];
        for (int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        int[] color = new int[2000];
        int count = 0;
        int left = 0;
        int res = Integer.MIN_VALUE; // [ ]
        for (int i = 0; i < N; i++) {
            if (color[nums[i]] == 0){
                count++;
            }
            color[nums[i]] ++;
            while (left<=i && count > K){
                color[nums[left]] --;
                if (color[nums[left]] == 0)
                    count --;
                left ++;
            }
            res = Math.max(res, i-left+1);
        }
        System.out.println(res);
    }
}
