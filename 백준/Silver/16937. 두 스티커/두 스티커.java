import java.util.*;
import java.io.*;

public class Main {
	
	static int H,W,N;
	static int[][] arr;
	
	static boolean attachable(int h, int w) {
		if (h <= H && w <= W) {
			return true;
		}
		return false;
	}
	
	static void attach(boolean[][] map, int h, int w) {
		for (int i=0;i<h;i++) {
			for (int j=0;j<w;j++) {
				map[i][j] = true;
			}
		}
	}
	
	static boolean attach2(boolean[][] map, int h, int w) {
		for (int i=H-1;i>=H-h;i--) {
			for (int j=W-1;j>=W-w;j--) {
				if (map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// H = 세로 = c = y = arr[n][0]
		// W = 가로 = r = x = arr[n][1]
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for (int i=0;i<N-1;i++) {
			boolean[][] map = new boolean[H][W];
			// 현재 선택된 스티커가 붙일 수 있는지 확인
			if (attachable(arr[i][0], arr[i][1])) {
				attach(map, arr[i][0], arr[i][1]); // 0,0에 스티커 붙임
				// 나머지 스티커 순회하며 붙일 수 있는지 확인 후 가능하면 최댓값 갱신
				for (int j=i+1;j<N;j++) {
					// 현재 선택된 스티커가 붙일 수 있는지 확인
					if (attachable(arr[j][0], arr[j][1])) {
						// W-1, H-1 위치부터 붙이기 시작
						if (attach2(map, arr[j][0], arr[j][1])) { // 붙일 수 있으면
							answer = Math.max(answer, arr[i][0]*arr[i][1] + arr[j][0]*arr[j][1]);
						}
						else { // 겹치는 등으로 인해 못 붙인 경우
							// 회전해서 붙일 수 있는지 확인 후 붙여보기
							if (attachable(arr[j][1], arr[j][0])) {
								if (attach2(map, arr[j][1], arr[j][0])) { // 회전해서 붙였다면
									answer = Math.max(answer, arr[i][0]*arr[i][1] + arr[j][0]*arr[j][1]);
								}
							}
						}
					}
					// 못 붙이는 경우
					else {
						// 회전해서 붙일 수 있는지 확인
						if (attachable(arr[j][1], arr[j][0])) {
							// W-1, H-1 위치에서 붙이기 시작
							if (attach2(map, arr[j][1], arr[j][0])) {
								answer = Math.max(answer, arr[i][0]*arr[i][1] + arr[j][0]*arr[j][1]);
							}
						}
					}
				}
				// 첫 번째 스티커를 회전하고 다시 시도
				map = new boolean[H][W];
				if (attachable(arr[i][1], arr[i][0])) {
					attach(map, arr[i][1], arr[i][0]);
					// 나머지 스티커 순회하며 붙일 수 있는지 확인 후 가능하면 최댓값 갱신
					for (int j=i+1;j<N;j++) {
						// 현재 선택된 스티커가 붙일 수 있는지 확인
						if (attachable(arr[j][0], arr[j][1])) {
							// W-1, H-1 위치부터 붙이기 시작
							if (attach2(map, arr[j][0], arr[j][1])) { // 붙일 수 있으면
								answer = Math.max(answer, arr[i][0]*arr[i][1] + arr[j][0]*arr[j][1]);
							}
							else { // 겹치는 등으로 인해 못 붙인 경우
								// 회전해서 붙일 수 있는지 확인 후 붙여보기
								if (attachable(arr[j][1], arr[j][0])) {
									if (attach2(map, arr[j][1], arr[j][0])) { // 회전해서 붙였다면
										answer = Math.max(answer, arr[i][0]*arr[i][1] + arr[j][0]*arr[j][1]);
									}
								}
							}
						}
						// 못 붙이는 경우
						else {
							// 회전해서 붙일 수 있는지 확인
							if (attachable(arr[j][1], arr[j][0])) {
								// W-1, H-1 위치에서 붙이기 시작
								if (attach2(map, arr[j][1], arr[j][0])) {
									answer = Math.max(answer, arr[i][0]*arr[i][1] + arr[j][0]*arr[j][1]);
								}
							}
						}
					}
				}
			}
			else { // 못 붙이는 경우
				// 회전해서 붙일 수 있는지 확인
				if (attachable(arr[i][1], arr[i][0])) {
					attach(map, arr[i][1], arr[i][0]); // 0,0에 붙임
					// 순회하며 다른 스티커 붙이기
					for (int j=i+1;j<N;j++) {
						if (attachable(arr[j][0], arr[j][1])) { // 붙일 수 있으면
							if (attach2(map, arr[j][0], arr[j][1])) { // 붙여보기 (W-1, H-1) 위치
								answer = Math.max(answer, arr[i][0]*arr[i][1] + arr[j][0]*arr[j][1]);
							}
							else {
								if (attachable(arr[j][1], arr[j][0])) {
									if (attach2(map, arr[j][1], arr[j][0])) {
										answer = Math.max(answer,  arr[i][0]*arr[i][1] + arr[j][0]*arr[j][1]);
									}
								}
							}
						}
						else {
							// 회전 및 확인 후 붙여보기
							if (attachable(arr[j][1], arr[j][0])) {
								if (attach2(map, arr[j][1], arr[j][0])) {
									answer = Math.max(answer,  arr[i][0]*arr[i][1] + arr[j][0]*arr[j][1]);
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}
