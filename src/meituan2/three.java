package meituan2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 3 行数字，1代表读，0代表加

public class three {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N+1];
		
		int M = sc.nextInt();
		int[] o1 = new int[M];
		int[] o2 = new int[M];
		int[] o3 = new int[M];
		
		for (int i=0; i<M; i++) {
			o1[i] = sc.nextInt();
		}
		for (int i=0; i<M; i++) {
			o2[i] = sc.nextInt();
		}
		for (int i=0; i<M; i++) {
			o3[i] = sc.nextInt();
		}
		
		List<Integer> res = new ArrayList<>();
		for (int i=0; i<M; i++) {
			if (o1[i] == 1) { // query
				int sum = 0;
				for (int j = o2[i]; j<=o3[i]; j++) {
					sum += num[j];
				}
				res.add(sum);
			} else if (o1[i] == 0) {
				num[o2[i]] += o3[i];
			}
			// System.out.println(Arrays.toString(num));
		}
		for (int i=0; i<res.size(); i++) {
			if (i == res.size()-1) {
				System.out.println(res.get(i));
			} else {
				System.out.print(res.get(i)+" ");
			}
		}
	}
	

}

/*

4 7
1 0 1 0 1 0 1
1 1 1 3 1 4 1
3 2 3 5 3 100 3

output: 0 2 7 7

*/


