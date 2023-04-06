package meituan;
import java.util.*;

// 物理攻击
// 告诉很多点的位置，告诉A，B分别代表长和宽，请问一次可以最多圈住几个点

public class physicalAttack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt();
        int[][] p = new int[N][2];
        for (int i=0; i<N; i++){
            p[i][0] = sc.nextInt();
            p[i][1] = sc.nextInt();
        }
        int maxPoints = findMaxPoints(p, A, B);    
        System.out.println(maxPoints);
    }
    public static int findMaxPoints(int[][] points, int A, int B) {
    	int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE, minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] point : points) {
            maxX = Math.max(maxX, point[0]);
            maxY = Math.max(maxY, point[1]);
            minX = Math.min(minX, point[0]);
            minY = Math.min(minY, point[1]);
        }
        int maxCount = Integer.MIN_VALUE;
        if (minX >= maxX - A && minY >= maxY - B) {
        	return points.length;	
        }	
        for (int i = minX; i <= maxX - A; i++) {
            for (int j = minY; j <= maxY - B; j++) {
                int count = 0;
                for (int[] point : points) {
                    if (point[0] >= i && point[0] <= i + A && point[1] >= j && point[1] <= j + B) {
                        count++;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;                    
                }
            }
        }
        return maxCount;
    }
}

/*
10 5 5
2 3
1 5
4 2
5 5
1 2
3 4
4 1
2 5
5 3
3 2
out: 10

5 4 6
1 2
2 4
3 1
4 5
5 3

 */




//Scanner sc = new Scanner(System.in);
//int N = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt();
//int[][] p = new int[N][2];
//for (int i=0; i<N; i++){
//    p[i][0] = sc.nextInt();
//    p[i][1] = sc.nextInt();
//}
//
//Arrays.sort(p, (a,b)->(a[0]-b[0]));  
//List<int[]> list = new LinkedList<>();
//int max = Integer.MIN_VALUE;
//for (int i=0; i<N; i++){
//    int j = i;
//    while (p[j][0] <= p[i][0] + A) {
//        list.add(p[j]);
//    }
//    Collections.sort(list, (a,b)->(a[1] - b[1]));
//    int count = 0;
//    for (int m=0; m<list.size(); m++){
//        int[] xx = list.get(m);
//        count = 0;
//        for (int n = m+1; n<list.size(); n++){
//            int[] yy = list.get(n);
//            if (yy[1] <= xx[1] + B){
//                count ++;
//                max = Math.max(count, max);
//            }
//        }
//    }
//}
//System.out.println(max);
//
