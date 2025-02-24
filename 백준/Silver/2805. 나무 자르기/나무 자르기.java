import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] heights;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		heights = new int[N];
		for (int i=0;i<N;i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(heights);
		
		long left = 0;
		long right = heights[N-1];
		long answer = 1;
		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			
			// 나무 높이 - 절단기 높이가 0이하이면 더 이상 계산할 필요 x
			for (int i=N-1;i>=0;i--) {
				if (heights[i] - mid <= 0) {
					break;
				}
				sum += heights[i] - mid;
			}
			
			if (sum > M) {
				left = mid + 1;
				answer = mid;
			} else if (sum < M ) {
				right = mid - 1;
			} else if (sum == M) {
				answer = mid;
				break;
			}
		}
			
		System.out.println(answer);
	}
}