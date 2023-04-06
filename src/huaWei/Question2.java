package huaWei;
import java.util.*;

public class Question2 {

	public static void question2(String[] args) {
    // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
    // please finish the function body here.
    // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][4];
        for (int i =0; i<n; i++) {
        	for (int j=0; j<4; j++) {
        		nums[i][j] = in.nextInt();
        	}
        }
        int[][] dp = new int[n][4];
        dp[0] = nums[0];
        for (int i=1; i<n; i++) {
        	for (int j=0; j<4; j++) {
        		int a = dp[i-1][(j+1)%4];
        		int b = dp[i-1][(j+2)%4];
        		int c = dp[i-1][(j+3)%4];
        		int min = Math.min(Math.min(a, b), c);
        		dp[i][j] = min + nums[i][j];
        	}
        }
        int res = Integer.MAX_VALUE;
        for (int cost: dp[n-1]) {
        	if (cost<res) {
        		res = cost;
        	}
        }
        System.out.println(res);
               
    }
//    private static void dfs(int i, int j, int sum, int[][] nums, int n) {
//    	if (i >= n) {
//    		return;
//    		min = Math.min(sum, min);
//    	}
//    	sum += nums[i][j];
//    	
//    	if (j == 0) {
//	    	dfs(i+1, 1, sum, nums, n);
//	    	dfs(i+1, 2, sum, nums, n);
//	    	dfs(i+1, 3, sum, nums, n);
//    	}
//    	if (j == 1) {
//    		dfs(i+1, 0, sum, nums, n);
//	    	dfs(i+1, 2, sum, nums, n);
//	    	dfs(i+1, 3, sum, nums, n);
//    	}if (j == 2) {
//    		dfs(i+1, 0);
//	    	dfs(i+1, 1);
//	    	dfs(i+1, 3);
//    	}if (j == 3) {
//    		dfs(i+1, 0);
//	    	dfs(i+1, 1);
//	    	dfs(i+1, 2);
//    	}
//	    	
//    }
}
