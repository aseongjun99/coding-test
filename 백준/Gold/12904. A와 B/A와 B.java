import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder S, T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = new StringBuilder(br.readLine());
		T = new StringBuilder(br.readLine());
		
		Queue<StringBuilder> q = new LinkedList<>();
		q.add(T);
		while (true) {
			StringBuilder temp = new StringBuilder(q.poll());
			
			if (temp.toString().equals(S.toString())) {
				System.out.println(1);
				return;
			} else if (temp.length() < S.length()) {
				System.out.println(0);
				return;
			}
			
			if (temp.charAt(temp.length()-1) == 'A') {
				q.add(temp.deleteCharAt(temp.length()-1));
			} else {
				q.add(temp.deleteCharAt(temp.length()-1).reverse());
			}
			
		}
	}
}
