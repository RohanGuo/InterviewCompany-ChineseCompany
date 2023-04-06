package meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 给定一个字符串，你最多可以将2个字符改成小写字母
// 输出最小的回文串（确保得出结果）

public class palindrome {
    public static void main(String[] args) {
        // 如果有2对字母不一致，如果有一对字母不一致，如果没有字母不一致
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        char[] arr = s.toCharArray();
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len/2; i++) {
        	if (arr[i] != arr[len - i - 1]) {
        		list.add(i);
        	}
        }
        if (list.size() == 2){
            int x1 = list.remove(0);
            int x2 = list.remove(0);
//            System.out.println(x1+" "+x2);
            arr[x1] = arr[len-x1-1] = (char) Math.min(arr[x1], arr[len-x1-1]);
            arr[x2] = arr[len-x2-1] = (char) Math.min(arr[x2], arr[len-x2-1]);           
        } else if (list.size() == 1){ // 1对不一致
            int x1 = list.remove(0);
            if (arr[x1] != 'a' && arr[len-x1-1] != 'a') {
            	arr[x1] = arr[len-x1-1] = 'a';
            } else {
            	arr[x1] = arr[len-x1-1] = 'a';
            	arr[len/2] = 'a';
            }
        } else {
            int x = 0;
            for (int i = 0; i < len/2; i++) {
                if (s.charAt(i) != 'a') {
                    x = i;
                    break;
                }
            }
            arr[x] = arr[len-x-1] = 'a';
        }
        System.out.println(new String(arr));
    }
}

/*
abcd -> abba
abcde -> aacae
aabca -> aaaaa


 */