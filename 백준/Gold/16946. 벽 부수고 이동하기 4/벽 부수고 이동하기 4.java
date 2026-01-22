import java.util.*;
import java.io.*;

public class Main {

		static int N, M;
		static int[][] map;
		static int[][] answer;
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer st;
		
		static List<int[]> wallPos = new ArrayList<>();
		static List<int[]> zeroPos = new ArrayList<>();
		
		static boolean[][] zeroVisit;
		static int zeroCount = 0;
		
		static int[] dx = {0, 0, -1, 1};
		static int[] dy = {-1, 1, 0, 0};
		
		static int[][] flags;
		static int flag = 1;
		
		static void input() throws IOException {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			answer = new int[N][M];
			
			zeroVisit = new boolean[N][M];
			flags = new int[N][M];
			
			for (int i=0;i<N;i++) {
				char[] input = br.readLine().toCharArray();
				for (int j=0;j<M;j++) {
					map[i][j] = input[j] - '0';
					if (map[i][j] == 0) {
						zeroPos.add(new int[] {i, j});
					}
					else {
						wallPos.add(new int[] {i, j});
					}
				}
			}
		}
		
		static void print() {
			StringBuilder sb = new StringBuilder();
			for (int i=0;i<N;i++) {
				for (int j=0;j<M;j++) {
					sb.append(answer[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}
		
		static void countMovablePos(int y, int x, List<int[]> pos) {
			for (int i=0;i<4;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
					continue;
				}
				
				if (zeroVisit[ny][nx] || map[ny][nx] == 1) {
					continue;
				}
				
				zeroCount++;
				zeroVisit[ny][nx] = true;
				pos.add(new int[] {ny, nx});
				countMovablePos(ny, nx, pos);
			}
		}
		
		static void fillZeroCount(List<int[]> pos) {
			for (int i=0;i<pos.size();i++) {
				int y = pos.get(i)[0];
				int x = pos.get(i)[1];
				map[y][x] = zeroCount;
			}
		}
		
		static void flagZeros(List<int[]> pos) {
			for (int i=0;i<pos.size();i++) {
				int y = pos.get(i)[0];
				int x = pos.get(i)[1];
				
				flags[y][x] = flag;
			}
		}
		
		static void sumMovement(int y, int x) {
			int sum = 1;
			boolean[] flagVisit = new boolean[flag+1];
			for (int i=0;i<4;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
					continue;
				}
				
				if (!zeroVisit[ny][nx]) {
					continue;
				}
				
				// flag 확인하여 더하기
				if (flagVisit[flags[ny][nx]]) {
					continue;
				}
				flagVisit[flags[ny][nx]] = true;
				sum += map[ny][nx];
			}
			
			answer[y][x] = sum%10;
		}
		
		public static void main(String[] args) throws IOException {
			input();
			
			// 각 0 에서 dfs 수행하여 이동 가능한 모든 좌표 탐색 후, 해당 좌표들을 이동 횟수로 덮어쓴다.
			for (int i=0;i<zeroPos.size();i++) {
				int[] now = zeroPos.get(i);
				if (!zeroVisit[now[0]][now[1]]) {
					zeroVisit[now[0]][now[1]] = true;
					zeroCount = 1;
					List<int[]> pos = new ArrayList<>();
					pos.add(new int[] {now[0], now[1]});
					countMovablePos(now[0], now[1], pos);
					
					fillZeroCount(pos);
					
					flagZeros(pos);
					flag++;
				}
			}
			
			// 각 벽에서 바로 인접한 상하좌우만 탐색하고, 해당 좌표의 숫자를 더한다.
			// 이때, 동일한 이동을 더하면 안되므로 각 좌표마다 dfs flag를 두어 구별한다.
			for (int i=0;i<wallPos.size();i++) {
				int[] now = wallPos.get(i);
				sumMovement(now[0], now[1]);
			}
			
			print();
		}

}
