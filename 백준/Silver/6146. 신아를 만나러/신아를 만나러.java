
import java.util.*;
import java.io.*;

public class Main {
	
	static int X, Y, N;
	static int minA, minB;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 모든 좌표값에 +500 -> 좌표의 범위가 -500 ~ 500이기 때문.
		X = Integer.parseInt(st.nextToken())+500;
		Y = Integer.parseInt(st.nextToken())+500;
		N = Integer.parseInt(st.nextToken());
		int[][] board = new int[1001][1001];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			board[B+500][A+500] = 1; // 1이면 웅덩이, 0이면 갈 수 있는 곳.
		}
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[1001][1001];
		q.add(new int[] {500, 500, 0}); // 시작점 0, 0 -> 500, 500
		visit[500][500] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (now[0] == X && now[1] == Y) {
				System.out.println(now[2]);
				break;
			}
			for (int i=0;i<4;i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if (nx < 0 || nx > 1000 || ny < 0 || ny > 1000) {
					continue;
				}
				if (board[ny][nx] == 1) {
					continue;
				}
				if (visit[ny][nx]) {
					continue;
				}
				q.add(new int[] {nx, ny, now[2]+1});
				visit[ny][nx] = true;
			}
		}
	}
}
