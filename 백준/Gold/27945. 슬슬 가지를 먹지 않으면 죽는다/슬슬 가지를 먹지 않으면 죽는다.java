import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[][] arr;
	static int[] parent;
	
	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if (rootX <= rootY) {
			parent[rootY] = rootX;
		}
		else {
			parent[rootX] = rootY;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for (int i=0;i<N+1;i++) {
			parent[i] = i;
		}
		
		arr = new int[M][3];
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(arr, (a, b) -> Integer.compare(a[2], b[2]));
		
		int day = 1;
		for (int i=0;i<N-1;i++) {
			int u = arr[i][0];
			int v = arr[i][1];
			int t = arr[i][2];
			
			if (day != t) {			
				System.out.println(day);
				return;
			}
			
			if (find(u) != find(v)) {
				union(u, v);
                day++;
			}

		}
		
		System.out.println(day);
	}
}
