
import java.util.*;
import java.io.*;

public class Main {

	static int K;
	static int L;
	static String[] waitings;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		waitings = new String[L];
		
		for (int i=0;i<L;i++) {
			waitings[i] = br.readLine();
		}
		
		List<String> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (int i=L-1;i>=0;i--) {
			if (map.containsKey(waitings[i])) {
				continue;
			}
			list.add(waitings[i]);
			map.put(waitings[i], 0);
		}
		
		int count = 0;
		for (int i=list.size()-1;i>=0;i--) {
			if (count == K) {
				break;
			}
			System.out.println(list.get(i));
			count++;
		}
	}
}
