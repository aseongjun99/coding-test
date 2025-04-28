import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0;t<T;t++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String x = br.readLine();
			x = x.substring(1, x.length()-1);
			String[] xArr = x.split(",");
			Deque<String> dq = new ArrayDeque<>();
			for (String s : xArr) {
				dq.add(s);
			}
			
			boolean reverse = false;
			boolean isError = false;
			for (int i=0;i<p.length();i++) {
				char c = p.charAt(i);
				if (c == 'R') {
					reverse = !reverse;
				}
				else if (c == 'D') {
					if (n == 0 || dq.size() == 0) {
						isError = true;
						break;
					}
					else if (reverse) {
						dq.removeLast();
					}
					else if (!reverse) {
						dq.removeFirst();
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			if (isError) {
				System.out.println("error");
			} else {
				sb.append("[");
				int idx = dq.size();
				if (reverse) {
					for (int i=0;i<idx;i++) {
						sb.append(dq.removeLast()).append(",");
						if (i == idx-1) {
							sb.deleteCharAt(sb.length()-1);
						}
					}
				} else {
					for (int i=0;i<idx;i++) {
						sb.append(dq.removeFirst()).append(",");
						if (i == idx-1) {
							sb.deleteCharAt(sb.length()-1);
						}
					}
				}
				sb.append("]");
				System.out.println(sb);
			}
		}
	}
}
