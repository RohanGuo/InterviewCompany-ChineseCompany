package meituan;

import java.util.Arrays;
import java.util.Scanner;

/*
已知可花销的钱数，已知有多少张优惠券，
同时给你一个二维数组，数组的每个元素，包含商品的价格和用券后商品的价格
问最大可以购物几件物品？此时花费多少钱

3 5 1
4 3
3 1
6 5
Output: 2 4

3 50 1
10 5
20 15
30 25

PS: 太难了，没搞懂

*/

public class maxItemNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), X = sc.nextInt(), Y = sc.nextInt();
        int[] p1 = new int[N+1];
        int[] p2 = new int[N+1];
        for (int i=1; i<=N; i++){
            p1[i] = sc.nextInt();
        }
        for (int i=1; i<=N; i++){
            p2[i] = sc.nextInt();
        }
        int[][][] amount = new int[N+1][X+1][Y+1]; // the max tickets when x money and y coupons
        int[][][] cost = new int[N+1][X+1][Y+1];
        for (int i = 1; i <= N; i++) {
        	int price = p1[i];
    		int discountedPrice = p2[i];
        	for (int j=1; j <= X; j++) {        	
        		for (int k=0; k<=Y; k++) {
        			
        			// Case 1: Don't buy the item
            		amount[i][j][k] = amount[i - 1][j][k];
                    cost[i][j][k] = cost[i - 1][j][k];

                    // Case 2: Buy the item without using a coupon
                    if (j >= price && amount[i][j][k] < amount[i - 1][j - price][k] + 1) {
                    	amount[i][j][k] = amount[i - 1][j - price][k] + 1;
                        cost[i][j][k] = cost[i - 1][j - price][k] + price;
                    }

                    // Case 3: Buy the item using a coupon
                    if (k > 0 && j >= discountedPrice && amount[i][j][k] < amount[i - 1][j - discountedPrice][k - 1] + 1) {
                        amount[i][j][k] = amount[i - 1][j - discountedPrice][k - 1] + 1;
                        cost[i][j][k] = cost[i - 1][j - discountedPrice][k - 1] + discountedPrice;
                    }
        		}
        		
        		
        	}

        }
        System.out.println(Arrays.deepToString(amount));
        System.out.println(Arrays.deepToString(cost));
        System.out.println(amount[N][X][Y] + " " + cost[N][X][Y]);
    }

}
//        为了计算在购买最大数量的物品的情况下，实际花费的钱数，我们需要稍微修改一下上面的代码。我们可以再定义一个cost[i][j][k]数组，表示在前i个物品中，使用预算为j和优惠券为k的情况下，实际花费的钱数。我们可以在上面三种情况中，记录实际花费的钱数，即：
//
//        不购买物品，cost[i][j][k]等于cost[i-1][j][k]
//        不使用优惠券购买物品，cost[i][j][k]等于cost[i-1][j-price][k]+price，其中price为物品的价格
//        使用一张优惠券购买物品，cost[i][j][k]等于cost[i-1][j-discountedPrice][k-1]+discountedPrice，其中discountedPrice为使用一张优惠券后物品的价格。
//        最终，我们返回cost[n][budget][numCoupons]，即可得到实际花费的钱数。
//
//        以下是修改后的Java代码：

//        该代码中，我们使用动态规划来解决问题。我们定义dp[i][j][k]为在前i个物品中，使用预算为j和优惠券为k的情况下，可以购买的最大物品数量。我们可以使用三种情况来计算dp[i][j][k]的值：
//
//        不购买物品，dp[i][j][k]等于dp[i-1][j][k]
//        不使用优惠券购买物品，dp[i][j][k]等于dp[i-1][j-price][k]+1，其中price为物品的价格
//        使用一张优惠券购买物品，dp[i][j][k]等于dp[i-1][j-discountedPrice][k-1]+1，其中discountedPrice为使用一张优惠券后物品的价格。
//        最终，我们需要返回dp[n][budget][numCoupons]，其中n为物品的数量，即可得到最大可以购买的物品数量。


//public class ShoppingCart {
//    public static int maxItems(int budget, int numCoupons, int[][] items) {
//        int n = items.length;
//        int[][][] dp = new int[n + 1][budget + 1][numCoupons + 1];
//        int[][][] cost = new int[n + 1][budget + 1][numCoupons + 1];
//
//        for (int i = 1; i <= n; i++) {
//            int price = items[i - 1][0];
//            int discountedPrice = items[i - 1][1];
//
//            for (int j = 1; j <= budget; j++) {
//                for (int k = 0; k <= numCoupons; k++) {
//                    // Case 1: Don't buy the item
//                    dp[i][j][k] = dp[i - 1][j][k];
//                    cost[i][j][k] = cost[i - 1][j][k];
//
//                    // Case 2: Buy the item without using a coupon
//                    if (j >= price && dp[i][j][k] < dp[i - 1][j - price][k] + 1) {
//                        dp[i][j][k] = dp[i - 1][j - price][k] + 1;
//                        cost[i][j][k] = cost[i - 1][j - price][k] + price;
//                    }
//
//                    // Case 3: Buy the item using a coupon
//                    if (k > 0 && j >= discountedPrice && dp[i][j][k] < dp[i - 1][j - discountedPrice][k - 1] + 1) {
//                        dp[i][j][k] = dp[i - 1][j - discountedPrice][k - 1] + 1;
//                        cost[i][j][k] = cost[i - 1][j - discountedPrice][k - 1] + discountedPrice;
//                    }
//                }
//            }
//        }
//        return n;
//    }
//}

//        System.out.println("Total cost: " + cost[n][budget][
