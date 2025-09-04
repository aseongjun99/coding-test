
import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[][] A;
	// 1 = 좌, 2=좌상, 3=상, 4=우상, 5=우, 6=우하, 7=하, 8=좌하
	static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[][] diag = {
			{-1, -1}, // 좌상
			{-1, 1}, // 우상
			{1, 1}, // 우하
			{1, -1} // 좌하
	};
	static Queue<int[]> clouds = new LinkedList<>();
	static StringTokenizer st;
	
	static int border(int pos) {
		if (pos < 1) {
			return N + pos;
		}
		else if (pos > N) {
			return pos - N;
		}
		else {
			return pos;
		}
	}
	
	static List<int[]> moveClouds(int d, int s, boolean[][] visit) {
		List<int[]> movedClouds = new ArrayList<>();
		s %= N;
		while (!clouds.isEmpty()) {
			int[] c = clouds.poll();
			int ny = c[0] + dy[d]*s;
			int nx = c[1] + dx[d]*s;
			ny = border(ny);
			nx = border(nx);
			A[ny][nx]++;
			movedClouds.add(new int[] {ny, nx});
			visit[ny][nx] = true;
		}
		return movedClouds;
	}
	
	static void magic(List<int[]> movedClouds) {
		for (int i=0;i<movedClouds.size();i++) {
			int[] now = movedClouds.get(i);
			int y = now[0]; int x = now[1];
			for (int j=0;j<diag.length;j++) {
				int ny = y + diag[j][0];
				int nx = x + diag[j][1];
				if (ny < 1 || ny > N || nx < 1 || nx > N) {
					continue;
				}
				if (A[ny][nx] != 0) {
					A[y][x]++;
				}
			}
		}
	}
	
	static void makeClouds(boolean[][] visit) {
		for (int i=1;i<=N;i++) {
			for (int j=1;j<=N;j++) {
				if (A[i][j] >= 2 && !visit[i][j]) {
					A[i][j] -= 2;
					clouds.add(new int[] {i, j});
				}
			}
		}
	}
	
	static int sum() {
		int sum = 0;
		for (int i=1;i<=N;i++) {
			for (int j=1;j<=N;j++) {
				sum += A[i][j];
			}
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N+1][N+1];
		for (int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1;j<=N;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clouds.add(new int[] {N, 1});
		clouds.add(new int[] {N, 2});
		clouds.add(new int[] {N-1, 1});
		clouds.add(new int[] {N-1, 2});
		
		for (int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			boolean[][] visit = new boolean[N+1][N+1];
			List<int[]> movedClouds = moveClouds(d, s, visit);
			magic(movedClouds);
			makeClouds(visit);
		}
		
		System.out.println(sum());
	}
}
