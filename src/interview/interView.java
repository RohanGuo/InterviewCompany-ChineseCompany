package interview;

public class interView {
	public static void main(String[] args) {
		String s = "-121";
		int out = toInt(s);
		System.out.println(out);
	}
	public static int toInt(String s) {
		int res = 0;
		int flag = 1;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i); 
			if (i==0 && c == '-') {
				flag = -1;
				continue;
			}
			int t = c -'0';
			res = res * 10 + t;
		}
		return res*flag;
	}

}
