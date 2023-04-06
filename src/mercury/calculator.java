package mercury;
import java.util.*;

public class calculator {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    String s = in.nextLine();
	    if (isValidParentheses(s)) {
	    	int res = calculateParentheses(s);
	    	System.out.println("The result is " + res);
	    } else {
	    	System.out.println("Not Valid Parentheses");
	    }
	}
	
	public static boolean isValidParentheses(String s) {
		StringBuilder builder = new StringBuilder();
        for (char ch: s.toCharArray()){
            if ( ch == '[' || ch == ']' || ch == '{' || ch == '}' || ch == '(' || ch == ')'){
                builder.append(ch);
            }
        }
		
        Stack<Character> stack = new Stack<>();
        char[] chars = builder.toString().toCharArray();
        for (char c: chars){
            if (c == '('){
                stack.push(')');
            } else if (c == '[') {
            	if (stack.contains(')')) {
            		return false;
            	}
                stack.push(']');
            } else if (c == '{') {
            	if (stack.contains(')') || stack.contains(']')) {
            		return false;
            	}
                stack.push('}');
            } else{
                if ( stack.isEmpty() || stack.pop() != c ){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
	
	public static int calculateParentheses(String s) {
        s = s.replaceAll("\\s+", "");
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
            	int j = i+1;
            	while (j < s.length() && s.charAt(j) != ')') {
            		j++;
            	}
                int parenthesesSum = calculateParentheses(s.substring(i + 1, j));
                i = j;
                if (sign == '+') {
                    stack.push(parenthesesSum);
                } else if (sign == '-') {
                    stack.push(-parenthesesSum);
                } else if (sign == '*') {
                    stack.push(stack.pop() * parenthesesSum);
                } else if (sign == '/') {
                    stack.push(stack.pop() / parenthesesSum);
                }
            } else if (c == '[') {
            	int j = i+1;
            	while (j < s.length() && s.charAt(j) != ']') {
            		j++;
            	}             
                int parenthesesSum = calculateParentheses(s.substring(i + 1, j));
                i = j;
                if (sign == '+') {
                    stack.push(parenthesesSum);
                } else if (sign == '-') {
                    stack.push(-parenthesesSum);
                } else if (sign == '*') {
                    stack.push(stack.pop() * parenthesesSum);
                } else if (sign == '/') {
                    stack.push(stack.pop() / parenthesesSum);
                }
            } else if (c == '{') {
            	int j = i+1;
            	while (j < s.length() && s.charAt(j) != '}') {
            		j++;
            	}             
                int parenthesesSum = calculateParentheses(s.substring(i + 1, j));
                i = j;
                if (sign == '+') {
                    stack.push(parenthesesSum);
                } else if (sign == '-') {
                    stack.push(-parenthesesSum);
                } else if (sign == '*') {
                    stack.push(stack.pop() * parenthesesSum);
                } else if (sign == '/') {
                    stack.push(stack.pop() / parenthesesSum);
                }
            } else if (Character.isDigit(c)) {
                int j = i;
                int value = 0;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    value = 10 * value + (s.charAt(j) - '0');
                    j++;
                }
                i = j;
                if (sign == '+') {
                    stack.push(value);
                } else if (sign == '-') {
                    stack.push(-value);
                } else if (sign == '*') {
                    stack.push(stack.pop() * value);
                } else if (sign == '/') {
                    stack.push(stack.pop() / value);
                }
            } else {
                sign = c;
                i++;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }


}

