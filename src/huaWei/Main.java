package huaWei;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    String s1 = in.next();
	    int s2 = in.nextInt();
	    int sum = 0;
	    
	    for (int k=1; k<=s2; k++) {
	    	String ten = Tento2(k);
	    	System.out.println(ten);
	    	for(int i=s1.length()-1, j= ten.length()-1; i>=0 && j>=0; i--,j--) {
	    		if(s1.charAt(i) == ten.charAt(j)) {
	    			sum += 1;
	    			break;
	    		}
	    	}
	    }
	    System.out.println(sum);
	       		
	}
	private static String Tento2 (int a) {
		StringBuilder sb = new StringBuilder();
		while (a != 0) {
			sb.append(a%2);
			a = a/2;
		}
		return sb.reverse().toString();
	}
}

//2 4 8
//
//9/2 = 4 -- 1
//4/2 = 2 -- 0
//2/2 = 1 -- 0
//1/2 = 0 -- 1
//double len = Math.log(s2)/Math.log(2);
//int length = (int)len+1;
//System.out.println("length " + length); //s2 二进制的长度
//
//char[] cs = s1.toCharArray();
//
//Set<Integer> set = new HashSet<>();
//for (int i=s1.length()-1, j=0; j<length ; i--,j++){
//	if (cs[i] == '1') {
//		continue;
//	}
//	System.out.print(j + " ");
//	set.add((int)Math.pow(2,j));
//}
//System.out.println();
//for (Integer r: set) {
//	System.out.print(r + " ");
//}






