package mercury;

import java.util.Arrays;
import java.util.Scanner;


public class multiSubArrays {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[] nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextLong();
        }
        System.out.println("Input: " + Arrays.toString(nums));
        long[] res = multiSub (nums);
        System.out.println("Output: " + Arrays.toString(res));
        
	}
	
    public static long[] multiSub (long[] nums) {
        long[] multiTwo = new long[nums.length-1];
        long[] multiFour = new long[nums.length-3];
        for (int i=0; i<nums.length-1; i++) {
        	multiTwo[i] = nums[i]*nums[i+1];
        }
        for (int i=0; i<nums.length-3; i++) {
        	multiFour[i] = multiTwo[i]*multiTwo[i+2];
        }
        return multiFour;
    }

}
