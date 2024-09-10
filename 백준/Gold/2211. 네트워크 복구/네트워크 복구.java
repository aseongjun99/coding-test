import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<int[]>[] graph = new ArrayList[N+1];
		for (int i=1;i<N+1;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new int[] {to, weight});
			graph[to].add(new int[] {from, weight});
		}
		
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		boolean[] visit = new boolean[N+1];
		int[] distance = new int[N+1];
		Arrays.fill(distance, INF);
		distance[1] = 0;
		int[] path = new int[N+1];

//		pq.add(1);
		pq.add(new int[] {1, 0});
		int k =0;
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int node = now[0];
			int w = now[1];
			
			if (visit[node]) {
				continue;
			}
			visit[node] = true;
			
			
			for (int i=0;i<graph[node].size();i++) {
				int target = graph[node].get(i)[0];
				int weight = graph[node].get(i)[1];
				if (!visit[target] && distance[target] > w + weight) {
						pq.add(new int[] {target, w + weight});
						distance[target] = w + weight;
						path[target] = node;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=2;i<=N;i++) {
			if (path[i] == 0) {
				continue;
			}
			k++;
			sb.append(i).append(" ").append(path[i]).append("\n");
		}
		System.out.println(k);
		System.out.print(sb);

		
	}
}