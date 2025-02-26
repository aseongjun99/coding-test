import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static List<Integer>[] relations;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		relations = new ArrayList[n+1];
		for (int i=0;i<n+1;i++) {
			relations[i] = new ArrayList<>();
		}
		
		for (int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			relations[a].add(b);
			relations[b].add(a);
		}
		
		int answer = 0;
		boolean[] visit = new boolean[n+1];
		visit[1] = true;
		List<Integer> friends = new ArrayList<>();
		for (int i=0;i<relations[1].size();i++) {
			if (!visit[relations[1].get(i)]) {
				visit[relations[1].get(i)] = true;
				friends.add(relations[1].get(i));
				answer++;
			}
		}
		
		for (int i=0;i<friends.size();i++) {
			int friend = friends.get(i);
			for (int j=0;j<relations[friend].size();j++) {
				if (!visit[relations[friend].get(j)]) {
					visit[relations[friend].get(j)] = true;
					answer++;
				}
			}
		}
		
		System.out.println(answer);
		
	}

}