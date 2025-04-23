import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		Stack<String> st = new Stack();
		for (String s : input.split("")) {
			// 여는 괄호는 스택에 추가
			if (s.equals("(") || s.equals("[")) {
				st.add(s);
			}
			else if (s.equals(")")) {
				int sum = 0;
				while (true) {
					if (st.isEmpty()) {
						System.out.println(0);
						return;
					}
					String temp = st.pop();
					if (temp.equals("[")) {
						System.out.println(0);
						return;
					}
					else if (temp.equals("(")) {
						if (sum != 0) {
							sum *= 2;
							st.add(Integer.toString(sum));
							sum = 0;
						}
						else {
							st.add("2");							
						}
						break;
					}
					else {
						sum += Integer.parseInt(temp);
					}
				}
			}
			else if (s.equals("]")) {
				int sum = 0;
				while (true) {
					if (st.isEmpty()) {
						System.out.println(0);
						return;
					}
					String temp = st.pop();
					if (temp.equals("(")) {
						System.out.println(0);
						return;
					}
					else if (temp.equals("[")) {
						if (sum !=0) {
							sum *=  3;
							st.add(Integer.toString(sum));
							sum = 0;
						}
						else {
							st.add("3");
						}
						break;
					}
					else {
						sum += Integer.parseInt(temp);
					}
				}
			}
		}
		int answer = 0;
		while (!st.isEmpty()) {
			String temp = st.pop();
			if (temp.equals("(") || temp.equals("[") || temp.equals(")") || temp.equals("]")) {
				System.out.println(0);
				return;
			}
			answer += Integer.parseInt(temp);
		}
		
		System.out.println(answer);
	}

}